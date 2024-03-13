package HW1_and_2;

public class DispenseChange {
    public static void main(String[] args) {
        int quarter = 25;
        int dime = 10;
        int nickel = 5;
        int penny = 1;
        int curr_change = Integer.parseInt(args[0]);
        int in = curr_change;

        int num_quarters = 0;
        int num_dimes = 0;
        int num_nickels = 0;
        int num_pennies = 0;

        while (curr_change > 0) {
            if (curr_change - quarter >= 0) {
                curr_change -= quarter;
                num_quarters += 1;
            } else if (curr_change - dime >= 0) {
                curr_change -= dime;
                num_dimes += 1;
            } else if (curr_change - nickel >= 0) {
                curr_change -= nickel;
                num_nickels += 1;
            } else {
                curr_change -= penny;
                num_pennies += 1;
            }
        }
        System.out.println(in + " cents in coins can be given as:");
        System.out.println(num_quarters + " quarters");
        System.out.println(num_dimes + " dimes");
        System.out.println(num_nickels + " nickels and");
        System.out.println(num_pennies + " pennies");
    }
}
