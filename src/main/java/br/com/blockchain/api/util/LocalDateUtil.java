package br.com.blockchain.api.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Classe utilitaria para conversão de datas
 * @author Dayana
 */
public final class LocalDateUtil {

	/**
	 * Convert {@link LocalDateTime} em String com Pattern dd/MM/yyyy HH:mm
	 * @param localDateTime LocalDateTime
	 * @return String formatada em dd/MM/yyyy HH:mm
	 */
	public static String convertLocalDateTimeToString(final LocalDateTime localDateTime) {
		return localDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
	}
	
	public static LocalDate convertStringtToLocalDate(final String date) {
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return LocalDate.parse(date, pattern);
	}
	
	public static String convertLocalDateToString(final LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return date.format(formatter);
	}
	
	public static LocalDateTime convertStringToLocalDateTime(final String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		return LocalDateTime.parse(date, formatter);	
	}
}
