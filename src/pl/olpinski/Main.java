package pl.olpinski;

public class Main {

    public static void main(String[] args) {
	// write your code here

        /*Fraction test = new Fraction(2, 6, 5);
        System.out.println(test);
        test.extractWholeNumber();
        System.out.println(test);
        test.removeWholeNumber();
        System.out.println(test);*/

        /*System.out.println(Operations.GreatestCommonDivisor(55, 44));*/

        Fraction test = new Fraction(2, 35, 49);
        System.out.println(test);
        test.simplify();
        System.out.println(test);

        System.out.println(Operations.LeastCommonMultiple(12, 18));
    }
}
