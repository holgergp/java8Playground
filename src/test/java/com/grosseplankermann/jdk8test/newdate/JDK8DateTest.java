package com.grosseplankermann.jdk8test.newdate;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Test to showcase the new JDK8 Date functionality
 * User: flunky
 */
public class JDK8DateTest {

    @Test
    public void simpleLocalDateFunctions() throws Exception {
        LocalDate now = LocalDate.now();
        LocalDate later = LocalDate.now().plusDays(2);
        assertTrue(now.isBefore(later));
    }

    @Test
    public void simpleLocalDateFunctionsUsingPeriods() throws Exception {
        LocalDate now = LocalDate.now();
        LocalDate someTime = LocalDate.of(2012, 12, 1);
        LocalDate before = LocalDate.now().minus(Period.ofMonths(2));

        assertTrue(now.isAfter(before));
        assertTrue(someTime.isBefore(now));
        assertEquals(2012, someTime.getYear());
        assertEquals(Month.DECEMBER, someTime.getMonth());
    }

    @Test
    public void simpleLocalDateTime() throws Exception {
        LocalDateTime now = LocalDateTime.now();
        LocalDate before = LocalDate.now().minus(Period.ofMonths(2));

        assertTrue(now.toLocalDate().isAfter(before));
    }

    @Test
    public void simpleLocalTimeParsing() throws Exception {
        LocalTime time1 = LocalTime.parse("10:14:30");
        LocalTime time2 = LocalTime.parse("11:15:30", DateTimeFormatter.ISO_TIME);
        assertTrue(time1.isBefore(time2));

    }

    @Test
    public void workWithJDK7() throws Exception {
        Calendar calendar = new GregorianCalendar();
        LocalDateTime dateTime = LocalDateTime.now();

        final LocalDateTime calendarDateTime = LocalDateTime.ofInstant(calendar.toInstant(), ZoneOffset.systemDefault());

        assertTrue(calendarDateTime.isBefore(dateTime.plusSeconds(1)));
    }

    @Test
    public void clockwork() throws Exception {

        final long milisSystem = System.currentTimeMillis();
        Clock clock = Clock.systemDefaultZone();
        assertTrue(clock.millis() >= milisSystem);
    }
}
