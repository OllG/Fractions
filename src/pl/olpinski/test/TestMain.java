package pl.olpinski.test;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.olpinski.Fraction;
import pl.olpinski.Operations;

import static org.junit.jupiter.api.Assertions.*;


public class TestMain {

    Fraction a;
    Fraction b;

    @BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init() {
        a = new Fraction(2, 3, 4);
        b= new Fraction(1, 5, 6);
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

    @Test
    void leastCommonMultiple()
    {
        assertEquals(48, Operations.LeastCommonMultiple(12, 16));
    }

    @Test
    void GreatestCommonDivisor()
    {
        assertEquals(9, Operations.GreatestCommonDivisor(54, 63));
    }

    @Test
    void Addition()
    {
        assertEquals(new Fraction(4, 7, 12), Operations.Addition(a, b));
    }
}
