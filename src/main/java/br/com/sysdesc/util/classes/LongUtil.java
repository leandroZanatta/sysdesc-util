package br.com.sysdesc.util.classes;

public class LongUtil {

    private LongUtil() {
    }

    public static boolean isNullOrZero(Long value) {

        return value == null || value.equals(0L);
    }

    public static boolean maior(Long valor1, Long valor2) {

        if (valor1 == null || valor2 == null) {
            return false;
        }

        return valor1 > valor2;
    }

}
