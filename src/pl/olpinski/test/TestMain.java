package pl.olpinski.test;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.olpinski.Fraction;

import static org.junit.jupiter.api.Assertions.*;


public class TestMain {

    Fraction a;

    @BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init() {
        a = new Fraction(2, 3, 4);
    }

    @Test
    void testIfExactlySame()
    {
        assertTrue(a.isExactlySame(new Fraction(2, 3, 4)));
    }

    @Test
    void testIfNotExactlySame()
    {
        assertFalse(a.isExactlySame(new Fraction(0, 11, 4)));
    }

    @Test
    void changeToImproperFraction()
    {
        a.changeToImproperFraction();
        assertEquals(0, a.getWholeNumber());
        assertEquals(11, a.getNumerator());
        assertEquals(4, a.getDenominator());
    }

    @Test
    void checkChangeToProperFraction()
    {
        Fraction b = new Fraction(0, 11, 4);
        b.changeToProperFraction();

        assertEquals(2, b.getWholeNumber());
        assertEquals(3, b.getNumerator());
        assertEquals(4, b.getDenominator());
    }

    @Test
    void checkingEquals()
    {
        assertEquals(new Fraction(1, 7, 4), a);
        assertEquals(new Fraction(0, 11, 4), a);
    }
}
