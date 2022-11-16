package com.todotxt.todotxttouch.util;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class StringsTest {

    @Test
    public void testIsBlankCaseNull() {
        String s = null;

        boolean returned = Strings.isBlank(s);

        assertTrue(returned);
    }

    @Test
    public void testIsBlankCaseEmpty() {
        String s = "";

        boolean returned = Strings.isBlank(s);

        assertTrue(returned);
    }

    @Test
    public void testIsBlackCaseWhitespaces() {
        String s = "    ";

        boolean returned = Strings.isBlank(s);

        assertTrue(returned);
    }

    @Test
    public void testIsBlankNotEmptyString() {
        String s = "test";

        boolean returned = Strings.isBlank(s);

        assertFalse(returned);
    }

    @Test
    public void testInsertPaddedInsertedStringEmpty() {
        String s = "test";
        int insertAt = 1;
        String stringToInsert = "";

        String returned = Strings.insertPadded(s, insertAt, stringToInsert);

        assertEquals(s, returned);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testInsertPaddedInsertIndexNegative() {
        String s = "test";
        int insertAt = -1;
        String stringToInsert = "test";

        thrown.expect(IndexOutOfBoundsException.class);
        String returned = Strings.insertPadded(s, insertAt, stringToInsert);
    }

    @Test
    public void testInsertPaddedInsertWithoutSpaces() {
        String s = "test";
        int insertAt = 1;
        String stringToInsert = "test";

        String returned = Strings.insertPadded(s, insertAt, stringToInsert);

        assertEquals("t test est", returned);
    }

    @Test
    public void testInsertPaddedInsertWithOneSpace() {
        String s = "t est";
        int insertAt = 1;
        String stringToInsert = "test";

        String returned = Strings.insertPadded(s, insertAt, stringToInsert);

        assertEquals("t test est", returned);
    }

    @Test
    public void testInsertPaddedInsertToBeginning() {
        String s = "test";
        int insertAt = 0;
        String stringToInsert = "test";

        String returned = Strings.insertPadded(s, insertAt, stringToInsert);

        assertEquals("test test", returned);
    }

    @Test
    public void testInsertPaddedInsertToBeginningWithSpace() {
        String s = " test";
        int insertAt = 0;
        String stringToInsert = "test";

        String returned = Strings.insertPadded(s, insertAt, stringToInsert);

        assertEquals("test test", returned);
    }

}
