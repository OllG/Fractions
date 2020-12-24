package pl.olpinski;

public class Fraction {
    //region Getters
    public int getWholeNumber() {
        return wholeNumber;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
    //endregion

    int wholeNumber;
    int numerator;
    int denominator;

    public Fraction(int wholeNumber, int numerator, int denominator) {
        if(denominator == 0)
            throw new RuntimeException("denominator cannot be 0.");

        this.wholeNumber = wholeNumber;
        this.numerator = numerator;
        this.denominator = denominator;

        removeMinusFromNumerator();
    }

    public void changeToImproperFraction()
    {
        int addToNumerator = wholeNumber * denominator;
        numerator += addToNumerator;
        wholeNumber = 0;
    }

    public void changeToProperFraction()
    {
        int addToWholeNumber = numerator / denominator;
        int numeratorRest = numerator % denominator;
        wholeNumber += addToWholeNumber;
        numerator = numeratorRest;
    }

    public void removeMinusFromNumerator()
    {
        while (numerator < 0)
        {
            takeOneFromWhole();
        }
    }

    private void takeOneFromWhole()
    {
        wholeNumber--;
        numerator += denominator;
    }

    public void multiplyParts(int multiplier)
    {
        numerator *= multiplier;
        denominator *= multiplier;
    }

    public void simplify()
    {
        int gcd = Operations.GreatestCommonDivisor(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    public boolean isExactlySame(Fraction input)
    {
        return (wholeNumber == input.wholeNumber &&
        numerator == input.numerator &&
        denominator == input.denominator);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Fraction))
        {
            return false;
        }

        Fraction input = (Fraction)obj;

        Fraction selfCloned = cloneExact();
        Fraction inputCloned = input.cloneExact();

        selfCloned.changeToProperFraction();
        inputCloned.changeToProperFraction();

        //refactor
        if(selfCloned.numerator == 0 && inputCloned.numerator == 0)
            selfCloned.denominator = inputCloned.denominator;

        return selfCloned.isExactlySame(inputCloned);

    }

    public Fraction cloneExact()
    {
        return new Fraction(wholeNumber, numerator, denominator);
    }

    @Override
    public String toString() {
        return wholeNumber +
                "(" + numerator +
                "/" + denominator +
                ")";
    }
}
