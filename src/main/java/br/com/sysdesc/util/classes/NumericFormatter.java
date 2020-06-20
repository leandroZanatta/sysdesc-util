package br.com.sysdesc.util.classes;

import java.text.NumberFormat;

public class NumericFormatter {

	private NumericFormatter() {
	}

	private static NumberFormat numberFormat = NumberFormat.getNumberInstance();

	static {
		numberFormat.setMaximumFractionDigits(0);
		numberFormat.setMinimumFractionDigits(0);
		numberFormat.setGroupingUsed(true);
	}

	public static String format(Number number) {

		return numberFormat.format(number);
	}

}
