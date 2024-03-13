package HW3;

import java.util.Scanner;
import java.text.DecimalFormat;

public class ChocolateBars {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        Scanner input_stream = new Scanner(System.in);

        //store all user inputs in variables
        System.out.print("Enter the weight in pounds: ");
        //float weight = input_stream.nextFloat();
        float weight = Float.parseFloat(input_stream.nextLine());
        System.out.print("Enter the height in inches: ");
        //float height = input_stream.nextFloat();
        float height = Float.parseFloat(input_stream.nextLine());
        System.out.print("Enter the age in years: ");
        int age = Integer.parseInt(input_stream.nextLine());
        //int age = input_stream.nextInt();
        //input_stream.nextLine();

        //store gender
        System.out.print("Enter M for Man, W for Woman: ");
        String gender = input_stream.nextLine();

        //loop until user input is proper ("W" or "M") for gender
        while (!gender.equals("W") && !gender.equals("M")) {
            System.out.print("Error! Please enter M for Man or W for Woman: ");
            gender = input_stream.nextLine();
        }


        //store activity level in variable al
        System.out.print("Enter S for Sedentary, O for Occasionally, A for Active, H for Highly Active: ");
        String al = input_stream.nextLine();

        //loop until user input is proper for al
        while (!al.equals("S") && !al.equals("O") && !al.equals("A") && !al.equals("H")) {
            System.out.print("Error! Please enter S for Sedentary, O for Occasionally, A for Active, H for Highly Active: ");
            al = input_stream.nextLine();
        }

        //assign the increase for BMR in bump based on the activity level
        double bump = 0.0;
        if (al.equals("S")) {
            bump = 1.20;
        } else if (al.equals("O")) {
            bump = 1.30;
        } else if (al.equals("A")) {
            bump = 1.40;
        } else if (al.equals("H")) {
            bump = 1.50;
        }

        //calculate BMR for men
        if (gender.equals("M")) {
            //store general calculation for BMR for men
            double mBMR = (66.0 + 6.3 * (double) weight + 12.9 * (double) height - 6.8 * (double) age);
            //multiply BMR by bump to account for new increase
            mBMR = mBMR * bump;
            //use decimal formatter to format BMR to 2 places after the decimal point
            System.out.println("BMR adjusted for gender and lifestyle is: " + df.format(mBMR));
            //find the number of chocolate bars by dividing by 230 calories and floor for a whole number (rounded down)
            double bars = Math.floor(mBMR / 230);
            System.out.println("Number of chocolate bars for man is: " + (int) bars);
        }
        //calculate BMR for women with changes based on gender in the general calculation
        else if (gender.equals("W")) {
            double wBMR = (655.0 + 4.3 * (double) weight + 4.7 * (double) height - 4.7 * (double) age);
            wBMR = wBMR * bump;
            System.out.println("BMR adjusted for gender and lifestyle is: " + df.format(wBMR));
            double bars = Math.floor(wBMR / 230);
            System.out.println("Number of chocolate bars for woman is: " + (int) bars);
        }
    }
}