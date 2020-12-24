package pl.olpinski;

public class Operations {

    public static Fraction Addition(Fraction a, Fraction b)
    {
        if(a.wholeNumber < 0)
            a.numerator *= -1;
        if(b.wholeNumber < 0)
            b.numerator *= -1;

        int lcm = Operations.LeastCommonMultiple(a.denominator, b.denominator);

        int aMultiplier = lcm/a.denominator;
        int bMultiplier = lcm/b.denominator;

        a.multiplyParts(aMultiplier);
        b.multiplyParts(bMultiplier);

        Fraction result = new Fraction(a.wholeNumber + b.wholeNumber, a.numerator + b.numerator, a.denominator);
        result.changeToProperFraction();
        result.simplify();
        result.removeMinusFromNumerator();

        return result;
    }

    public static int GreatestCommonDivisor(int a, int b)
    {
       int gcd = 1;

       for(int i = 1; (i <= a) && (i <= b); i++)
       {
           if((a % i == 0) && (b % i == 0))
           {
               gcd = i;
           }
       }

       return gcd;
    }

    public static int LeastCommonMultiple(int a, int b)
    {
        if(a == 0 || b == 0)
            return 0;

        if(a == b)
            return a;

        int lcm;
        int lowerNumber;
        int higherNumber;

        if(a > b) {
            lcm = a;
            higherNumber = a;
            lowerNumber = b;
        }
        else {
            lcm = b;
            higherNumber = b;
            lowerNumber = a;
        }

        while ((lcm % lowerNumber) != 0)
        {
            lcm += higherNumber;
        }

        return lcm;
    }
}
