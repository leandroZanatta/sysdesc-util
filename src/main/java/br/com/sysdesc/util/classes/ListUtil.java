package br.com.sysdesc.util.classes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListUtil {

	private ListUtil() {
	}

	@SafeVarargs
	public static <T> List<T> toList(T... array) {

		List<T> retorno = new ArrayList<>();

		Collections.addAll(retorno, array);

		return retorno;
	}

	public static <T> boolean isNullOrEmpty(List<T> lista) {

		return lista == null || lista.isEmpty();
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] toArray(List<T> lista, Class<T> returnType) {

		T[] array = null;

		array = (T[]) Array.newInstance(returnType, lista.size());

		return lista.toArray(array);
	}
}
