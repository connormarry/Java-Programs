package HW1_and_2;

import java.util.Scanner;

public class CompareStrings {
    public static void main(String[] args){
        Scanner in_stream = new Scanner(System.in); //scanner object for input stream

        System.out.print("Enter the first string: ");
        String first = in_stream.next();

        System.out.print("Enter the second string: ");
        String second = in_stream.next();

        System.out.println();
        if (first.equals(second)){ //case-sensitive

            System.out.println("The two strings are equal");

        } else {

            System.out.println("The two strings are not equal");

            if (first.equalsIgnoreCase(second)){    //not case-sensitive

                System.out.println("But the two strings are equal, ignoring case");

            } else {

                System.out.println("The two strings are not equal, even ignoring case");
            }
        }
        in_stream.close();
    }
}
