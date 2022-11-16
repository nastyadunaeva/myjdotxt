package com.todotxt.todotxttouch.util;

import com.chschmid.jdotxt.gui.JdotxtGUI;
import com.chschmid.jdotxt.util.LanguagesController;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class RelativeDateTest {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void testRelativeDateD2Later() {
        Calendar d2 = new GregorianCalendar(2015, 0, 5);
        Calendar d1 = new GregorianCalendar(2015, 0, 4);
        String expected = sdf.format(d2.getTime());

        String result = RelativeDate.getRelativeDate(d1, d2);

        assertEquals(expected, result);
    }

    @Test
    public void testRelativeDateToday() {
        JdotxtGUI.lang = new LanguagesController("English");
        Calendar d2 = new GregorianCalendar(2015, 0, 5);
        Calendar d1 = new GregorianCalendar(2015, 0, 5);
        d1.set(Calendar.HOUR_OF_DAY, 22);
        String expected = "today";

        String result = RelativeDate.getRelativeDate(d1, d2);

        assertEquals(expected, result);
    }

    @Test
    public void testRelativeDate1Day() {
        JdotxtGUI.lang = new LanguagesController("English");
        Calendar d2 = new GregorianCalendar(2015, 0, 5);
        Calendar d1 = new GregorianCalendar(2015, 0, 5);
        d1.add(Calendar.DAY_OF_MONTH, 1);
        d1.add(Calendar.HOUR_OF_DAY, 22);
        String expected = "1 day ago";

        String result = RelativeDate.getRelativeDate(d1, d2);

        assertEquals(expected, result);
    }

    @Test
    public void testRelativeDateNDays() {
        JdotxtGUI.lang = new LanguagesController("English");
        Calendar d2 = new GregorianCalendar(2015, 0, 5);
        Calendar d1 = new GregorianCalendar(2015, 0, 5);
        d1.add(Calendar.DAY_OF_YEAR, 15);
        String expected = "15 days ago";

        String result = RelativeDate.getRelativeDate(d1, d2);

        assertEquals(expected, result);
    }

    @Test
    public void testRelativeDate1Month() {
        JdotxtGUI.lang = new LanguagesController("English");
        Calendar d2 = new GregorianCalendar(2015, 0, 5);
        Calendar d1 = new GregorianCalendar(2015, 0, 5);
        d1.add(Calendar.DAY_OF_YEAR, 40);
        String expected = "1 month ago";

        String result = RelativeDate.getRelativeDate(d1, d2);

        assertEquals(expected, result);
    }

    @Test
    public void testRelativeDateNMonths() {
        JdotxtGUI.lang = new LanguagesController("English");
        Calendar d2 = new GregorianCalendar(2015, 0, 5);
        Calendar d1 = new GregorianCalendar(2015, 0, 5);
        d1.add(Calendar.DAY_OF_YEAR, 30 * 6);
        String expected = "5 months ago";

        String result = RelativeDate.getRelativeDate(d1, d2);

        assertEquals(expected, result);
    }

    @Test
    public void testRelativeDateMoreYear() {
        JdotxtGUI.lang = new LanguagesController("English");
        Calendar d2 = new GregorianCalendar(2015, 0, 5);
        Calendar d1 = new GregorianCalendar(2017, 0, 5);
        String expected = "2015-01-05";

        String result = RelativeDate.getRelativeDate(d1, d2);

        assertEquals(expected, result);
    }
}
