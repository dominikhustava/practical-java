package com.hustava.practicaljava.rest.util;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandomDateUtil {
	static Logger log = LoggerFactory.getLogger(RandomDateUtil.class);
	
	
	private static final long minDay = LocalDate.of(2010, Month.JANUARY, 1).toEpochDay();
	private static final long maxDay = LocalDate.now().toEpochDay();
	
	public static LocalDate generateRandomLocalDate() {
		long randomDay = minDay + ThreadLocalRandom.current().nextLong(maxDay - minDay);
		return LocalDate.ofEpochDay(randomDay);
	}
	
	public static Date generateRandomDate() {
		var randomLocalDate = generateRandomLocalDate();
		var date = Date.from(randomLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		return date;
	}
	
}
