package br.com.sysdesc.util.classes;

import java.text.NumberFormat;

public class MoneyFormatter {

    private static NumberFormat numberFormat = NumberFormat.getNumberInstance();

    static {
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setGroupingUsed(true);
    }

    public static String format(Number number) {

        return numberFormat.format(number);
    }

}
