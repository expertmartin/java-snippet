package com.general;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.Test;

public class GeneralTest {

	@Test
	public void testDate() {
		//Long tradeDate = 1508161461000; //000000
		long tradeDate = 1508161461000L; //000000;

		//Long tradeDate = -9999L; //000000L;
		Date date = new Date(tradeDate);

		System.out.println("today long = " + System.currentTimeMillis());
		System.out.println("tradeDate  = " + tradeDate);

		System.out.println("tradeDate = " + date);

		String[] formats = new String[] { "yyyy-MM-dd", "yyyy-MM-dd HH:mm", "yyyy-MM-dd HH:mmZ",
				"yyyy-MM-dd HH:mm:ss.SSSZ", "yyyy-MM-dd'T'HH:mm:ss.SSSZ", };
		for (String format : formats) {
			SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
			System.err.format("%30s %s\n", format, sdf.format(date));
			sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
			System.err.format("%30s %s\n", format, sdf.format(date));
		}

	}


	public static void showFormatedDate(long longDate) {
		System.out.println("longDate = " + longDate);

		String[] formats = new String[] {
				"yyyy-MM-dd", "yyyy-MM-dd HH:mm",
				"yyyy-MM-dd HH:mmZ",
				"yyyy-MM-dd HH:mm:ss.SSSZ",
				"yyyy-MM-dd'T'HH:mm:ss.SSSZ", };

		for (String format : formats) {
			SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
			System.err.format("Locale.US: %30s %s\n", format, sdf.format(longDate));

			sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
			System.err.format("UTC: %30s %s\n", format, sdf.format(longDate));
		}
	}

	
}
