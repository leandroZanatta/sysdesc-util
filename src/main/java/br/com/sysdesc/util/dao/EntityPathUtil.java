package br.com.sysdesc.util.dao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.mysema.query.types.EntityPath;
import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.path.EntityPathBase;
import com.mysema.query.types.path.ListPath;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.StringPath;

import br.com.sysdesc.util.classes.ListUtil;
import br.com.sysdesc.util.classes.StringUtil;
import br.com.sysdesc.util.enumeradores.TipoFieldEnum;
import br.com.sysdesc.util.exception.SysDescException;
import br.com.sysdesc.util.vo.FieldPesquisaVO;

public class EntityPathUtil {

	private EntityPathUtil() {

	}

	public static <T> BooleanExpression getExpressionLike(EntityPath<T> entityPath, Boolean contem, String pesquisa,
			Long tipoDado, String campo) {

		switch (TipoFieldEnum.forCodigo(tipoDado)) {

		case LONG:
			return getLongClausule(entityPath, contem, pesquisa, campo);

		case STRING:
			return getStringClausule(entityPath, contem, pesquisa, campo);

		default:
			return null;
		}
	}

	private static <T> BooleanExpression getStringClausule(EntityPath<T> entityPath, boolean contem, String pesquisa,
			String campo) {

		String valor = (contem ? "%" : "") + pesquisa + "%";

		return getFieldString(entityPath, campo.split("\\.")).likeIgnoreCase(valor);
	}

	private static <T> BooleanExpression getLongClausule(EntityPath<T> entityPath, boolean contem, String pesquisa,
			String campo) {

		if (StringUtil.isNumeric(pesquisa)) {

			String valor = (contem ? "%" : "") + pesquisa + "%";

			return getFieldLong(entityPath, campo.split("\\.")).like(valor);
		}

		return null;
	}

	private static StringPath getFieldString(Object path, String[] campos) {

		if (campos.length > 0) {

			Object field = getField(path, campos[0]);

			if (field == null) {

				throw new SysDescException("O CAMPO INFORMADO NÃO FOI ENCONTRADO");
			}

			if (campos.length == 1) {

				return (StringPath) field;
			}

			return getFieldString(field, Arrays.copyOfRange(campos, 1, campos.length));

		}

		throw new SysDescException("O CAMPO INFORMADO NÃO PODE SER VAZIO");

	}

	@SuppressWarnings("unchecked")
	private static NumberPath<Long> getFieldLong(Object path, String[] campos) {

		if (campos.length > 0) {

			Object field = getField(path, campos[0]);

			if (field == null) {

				throw new SysDescException("O CAMPO INFORMADO NÃO FOI ENCONTRADO");
			}

			if (campos.length == 1) {

				return (NumberPath<Long>) field;
			}

			return getFieldLong(field, Arrays.copyOfRange(campos, 1, campos.length));

		}

		throw new SysDescException("O CAMPO INFORMADO NÃO PODE SER VAZIO");

	}

	private static Object getField(Object path, String campo) {

		List<Field> fields = ListUtil.toList(path.getClass().getFields());

		Optional<Field> field = fields.stream().filter(x -> x.getName().equals(campo)).findFirst();

		if (field.isPresent()) {

			try {

				field.get().setAccessible(Boolean.TRUE);

				return field.get().get(path);

			} catch (IllegalArgumentException | IllegalAccessException e) {
				return null;
			}
		}

		return null;

	}

	public static List<FieldPesquisaVO> getAllFieldsFromEntity(Class<? extends EntityPathBase<?>> clazz) {

		List<Class<?>> baseClasses = new ArrayList<>();
		baseClasses.add(clazz);

		List<FieldPesquisaVO> retorno = getAllFieldsFromEntity(baseClasses, "", clazz);

		retorno.sort((o1, o2) -> {

			Integer lengthO1 = o1.getName().split("\\.").length;
			Integer lengthO2 = o2.getName().split("\\.").length;

			if (!lengthO1.equals(lengthO2)) {
				return Integer.compare(lengthO1, lengthO2);
			}

			return o1.getName().compareTo(o2.getName());
		});

		return retorno;
	}

	public static List<FieldPesquisaVO> getAllFieldsFromEntity(List<Class<?>> baseClass, String fieldStart,
			Class<? extends EntityPathBase<?>> clazz) {

		List<FieldPesquisaVO> paths = new ArrayList<>();

		Arrays.asList(clazz.getFields()).forEach(field -> {

			if (field.getModifiers() == 17 && !field.getType().equals(ListPath.class)
					&& !baseClass.contains(field.getType())) {

				if (field.getType().getSuperclass().equals(EntityPathBase.class)) {
					baseClass.add(field.getType());
				}

				getField(fieldStart, paths, field, baseClass);
			}

		});

		return paths;
	}

	@SuppressWarnings("unchecked")
	private static void getField(String fieldStart, List<FieldPesquisaVO> paths, Field field,
			List<Class<?>> baseClass) {

		if (field.getType().getSuperclass().equals(EntityPathBase.class)) {

			paths.addAll(getAllFieldsFromEntity(baseClass, fieldStart + field.getName() + ".",
					(Class<EntityPathBase<?>>) field.getType()));

			return;
		}

		paths.add(new FieldPesquisaVO(fieldStart + field.getName(), field));
	}

}
