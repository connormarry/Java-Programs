package HW3;

import java.util.Scanner;

public class TriangleTester {
    public static void main(String[] args){

        //Created scanner object to obtain side lengths
        double s1, s2, s3;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first length: ");
        s1 = sc.nextDouble();
        System.out.print("Enter the second length: ");
        s2 = sc.nextDouble();
        System.out.print("Enter the third length: ");
        s3 = sc.nextDouble();

        //Triangle inequality theorem: if any side is greater than the sum of the other two, they cannot form a triangle
        if ((s1 + s2 <= s3) || (s1 + s3 <= s2) || (s2 + s3 <= s1)) {
            System.out.println("These lengths cannot form a triangle");
        } else {
            System.out.println("These lengths can form a triangle");

            /* Converse Pythagoras theorem: for side lengths a, b, and c
               with c being the largest, the following is true:

            *   if c^2 < a^2 + b^2, then the sides form an acute triangle
            *   if c^2 = a^2 + b^2, then the sides form a right triangle
            *   if c^2 > a^2 + b^2, then the sides form an obtuse triangle */

            //Checking which side is the largest
            double a, b, c;
            if ((s1 > s2) && (s1 > s3)) {c = s1; a = s2; b = s3;}
            else if ((s2 > s1) && (s2 > s3)) {c = s2; a = s1; b = s3;}
            else {c = s3; a = s1; b = s2;}

            //Applying the theorem
            if ((c*c) < (a*a) + (b*b)) {
                System.out.println("It is an acute triangle");
            } else if ((c*c) == (a*a) + (b*b)) {
                System.out.println("It is a right triangle");
            } else {
                System.out.println("It is an obtuse triangle");
            }
        }

    }
}
