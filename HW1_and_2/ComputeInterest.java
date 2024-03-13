package HW1_and_2;

public class ComputeInterest {
    public static void main(String[] args) {
        int principal = Integer.parseInt(args[0]);
        double interest_rate = Double.parseDouble(args[1]);
        int years = Integer.parseInt(args[2]);

        interest_rate /= 100;

        double simple_interest = principal + (principal * interest_rate * years);
        double compound_interest =  (principal * Math.pow((1 + interest_rate), years));

        System.out.println("The amount with simple interest is " + simple_interest);
        System.out.println("The amount with compound interest is " + compound_interest);
        System.out.println("The difference is: " + Math.abs(simple_interest - compound_interest));
    }
}
