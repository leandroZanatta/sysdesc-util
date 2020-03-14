package br.com.sysdesc.util.classes;

import java.lang.reflect.ParameterizedType;

public class ClassTypeUtil {

	private ClassTypeUtil() {
	}

	@SuppressWarnings("unchecked")
	public static <T> Class<T> getGenericType(Class<?> classePai) {

		final ParameterizedType type = (ParameterizedType) classePai.getGenericSuperclass();

		return (Class<T>) type.getActualTypeArguments()[0];
	}

}
