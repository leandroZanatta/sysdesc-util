package br.com.sysdesc.util.classes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalUtil {

	private BigDecimalUtil() {
	}

	public static final BigDecimal ZERO = BigDecimal.valueOf(0);

	public static boolean isNullOrZero(BigDecimal value) {

		return value == null || value.doubleValue() == 0.0;
	}

	public static boolean maior(BigDecimal valor1, BigDecimal valor2) {

		return ifNulZero(valor1).compareTo(ifNulZero(valor2)) > 0;
	}

	public static boolean maiorOuIgual(BigDecimal valor1, BigDecimal valor2) {

		return ifNulZero(valor1).compareTo(ifNulZero(valor2)) >= 0;
	}

	public static BigDecimal ifNulZero(BigDecimal value) {

		if (value == null) {

			return BigDecimal.ZERO;
		}

		return value;
	}

	public static boolean diferente(BigDecimal valor1, BigDecimal valor2) {
		return valor1.setScale(2, RoundingMode.HALF_EVEN).compareTo(valor2.setScale(2, RoundingMode.HALF_EVEN)) != 0;
	}

}
