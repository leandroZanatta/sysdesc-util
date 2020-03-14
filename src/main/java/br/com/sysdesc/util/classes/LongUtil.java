package br.com.sysdesc.util.classes;

public class LongUtil {

	private LongUtil() {
	}

	public static boolean isNullOrZero(Long value) {

		return value == null || value.equals(0L);
	}

}
