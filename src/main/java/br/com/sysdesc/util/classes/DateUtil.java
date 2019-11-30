package br.com.sysdesc.util.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

	public static final String FORMATO_DD_MM_YYY = "dd/MM/yyy";
	public static final String FORMATO_DD_MM_YYYY_HH_MM_SS = "dd/MM/yyyy HH:mm:ss";
	private static final ZoneId FUSO_HORARIO = ZoneId.systemDefault();

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

		return Date.from(
				currentDateTime.withHour(0).withMinute(0).withSecond(0).withNano(0).atZone(FUSO_HORARIO).toInstant());
	}

	public static Date getFinalDate(Date data) {
		LocalDateTime currentDateTime = LocalDateTime.ofInstant(data.toInstant(), FUSO_HORARIO);

		return Date.from(currentDateTime.withHour(23).withMinute(59).withSecond(59).withNano(999).atZone(FUSO_HORARIO)
				.toInstant());

	}
}
