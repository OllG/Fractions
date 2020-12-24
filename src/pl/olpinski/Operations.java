package pl.olpinski;

public class Operations {

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
