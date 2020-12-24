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
        assertTrue(a.getWholeNumber() == 0);
        assertTrue(a.getNumerator() == 11);
        assertTrue(a.getDenominator() == 4);
    }

    @Test
    void checkChangeToProperFraction()
    {
        Fraction b = new Fraction(0, 11, 4);
        b.changeToProperFraction();

        assertTrue(a.getWholeNumber() == 2);
        assertTrue(a.getNumerator() == 3);
        assertTrue(a.getDenominator() == 4);
    }

    @Test
    void checkingEquals()
    {
        assertTrue(a.equals(new Fraction(0, 11, 4)));
        assertTrue(a.equals(new Fraction(1, 7, 4)));
    }
}
