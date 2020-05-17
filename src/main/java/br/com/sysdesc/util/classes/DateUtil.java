package br.com.sysdesc.util.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {

    private DateUtil() {
    }

    public static final String FORMATO_DD_MM = "dd/MM";
    public static final String FORMATO_MM_YYYYY = "MM/YYYY";
    public static final String FORMATO_DD_MM_YYY = "dd/MM/yyyy";
    public static final String FORMATO_DD_MM_YYYY_HH_MM_SS = "dd/MM/yyyy HH:mm:ss";
    public static final String FORMATO_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    private static final ZoneId FUSO_HORARIO = ZoneId.systemDefault();
    private static final List<String> FERIADOS_FIXOS = Arrays.asList("01/01", "21/04", "01/05", "07/09", "12/10", "02/11", "15/11", "25/12");
    private static final List<Integer> DIAS_UTEIS = Arrays.asList(1, 2, 3, 4, 5);

    public static Date parse(String formato, String valor) {

        try {
            return new SimpleDateFormat(formato).parse(valor);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String format(String formato, Date valor) {

        return new SimpleDateFormat(formato).format(valor);
    }

    public static Date getInitialDate(Date data) {

        LocalDateTime currentDateTime = LocalDateTime.ofInstant(data.toInstant(), FUSO_HORARIO);

        return Date.from(currentDateTime.withHour(0).withMinute(0).withSecond(0).withNano(0).atZone(FUSO_HORARIO).toInstant());
    }

    public static Date getFinalDate(Date data) {
        LocalDateTime currentDateTime = LocalDateTime.ofInstant(data.toInstant(), FUSO_HORARIO);

        return Date.from(currentDateTime.withHour(23).withMinute(59).withSecond(59).withNano(999).atZone(FUSO_HORARIO).toInstant());

    }

    public static Date addDays(Date data, Long dias) {

        return addDate(data, dias);
    }

    public static Date subtractDays(Date data, Long dias) {

        return addDate(data, -dias);
    }

    public static boolean menorOuIgual(Date date1, Date date2) {

        return date1.getTime() <= date2.getTime();
    }

    public static boolean menor(Date date1, Date date2) {

        return date1.getTime() < date2.getTime();
    }

    public static boolean isLastDayOfMonth(Date date) {

        Calendar calendar = getCalendar(date);

        return calendar.get(Calendar.DATE) == calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static boolean isFirstDayOfMonth(Date date) {

        return getCalendar(date).get(Calendar.DATE) == 1;
    }

    public static boolean isDayOrLastDayOfMonth(Date date, Long diavalidar) {

        Calendar calendar = getCalendar(date);

        int dia = calendar.get(Calendar.DATE);
        int ultimoDiaMes = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        return dia == diavalidar || (ultimoDiaMes < diavalidar && dia == ultimoDiaMes);
    }

    public static Integer getDayOfMonth(Date date) {

        return getCalendar(date).get(Calendar.DATE);
    }

    public static Integer getLastDayOfMonth(Date date) {

        return getCalendar(date).getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static Date setDay(Date date, Long dia) {
        Calendar calendar = getCalendar(date);

        calendar.set(Calendar.DATE, dia.intValue());

        return calendar.getTime();
    }

    public static Date obterDiaUtil(Date date) {

        while (!isDiaUtil(date)) {
            date = addDays(date, 1L);
        }

        return date;
    }

    private static boolean isDiaUtil(Date date) {

        Calendar calendar = getCalendar(date);

        if (!DIAS_UTEIS.contains(calendar.get(Calendar.DAY_OF_WEEK))) {
            return false;
        }

        if (FERIADOS_FIXOS.contains(new SimpleDateFormat(FORMATO_DD_MM).format(date))) {
            return false;
        }

        return true;
    }

    public static Date addMonth(Date data, Long meses) {

        Calendar calendar = getCalendar(data);

        calendar.add(Calendar.MONTH, meses.intValue());

        return calendar.getTime();
    }

    public static Integer getDaysOfDates(Date dataInicial, Date dataFinal) {

        return getCalendar(dataFinal).get(Calendar.DAY_OF_YEAR) - getCalendar(dataInicial).get(Calendar.DAY_OF_YEAR);
    }

    private static Date addDate(Date data, Long dias) {

        Calendar calendar = getCalendar(data);

        calendar.add(Calendar.DATE, dias.intValue());

        return calendar.getTime();
    }

    private static Calendar getCalendar(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar;
    }

    public static boolean maior(Date date1, Date date2) {

        return !menorOuIgual(date1, date2);
    }

    public static Integer getYear(Date dataAtual) {

        return getCalendar(dataAtual).get(Calendar.YEAR);
    }

    public static Integer getMonth(Date dataAtual) {

        return getCalendar(dataAtual).get(Calendar.MONTH);
    }

}
