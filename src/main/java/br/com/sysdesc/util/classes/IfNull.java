package br.com.sysdesc.util.classes;

import java.util.function.Function;

public class IfNull {

	private IfNull() {
	}

	public static <T> T get(T objeto, T caseNull) {

		if (objeto == null) {
			return caseNull;
		}

		return objeto;
	}

	public static String getStringEmpty(String value) {

		if (!StringUtil.isNullOrEmptyTrim(value)) {
			return value.trim();
		}

		return null;
	}

	public static String getStringChar(String value, String string) {

		if (StringUtil.isNullOrEmptyTrim(value)) {
			return null;
		}

		if (!value.contains(string)) {
			return value;
		}

		return null;
	}

	public static <T, K> K caseNull(T object, K defaultvalue, Function<T, K> function) {

		return object == null ? defaultvalue : function.apply(object);
	}

}
