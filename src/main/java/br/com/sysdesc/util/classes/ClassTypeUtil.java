package br.com.sysdesc.util.classes;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ClassTypeUtil {

	private ClassTypeUtil() {
	}

	@SuppressWarnings("unchecked")
	public static <T> Class<T> getGenericType(Class<?> classePai) {

		final ParameterizedType type = (ParameterizedType) classePai.getGenericSuperclass();

		return (Class<T>) type.getActualTypeArguments()[0];
	}

	public static Object[] getCorrectMethodParameters(Method method, Object... objects) {
		Map<Class<?>, Object> map = new HashMap<>();

		for (Object object : objects) {
			map.put(object.getClass(), object);
		}

		return Arrays.asList(method.getParameterTypes()).stream().map(map::get).toArray();
	}

}
