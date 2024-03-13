package HW6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EmployeeReportTest {
    public static void main(String[] args) {
        //Initialize Variables
        String file = "";
        boolean retry = false; // variable for error catching/looping
        boolean first = true; // variable to start loop
        while (first || retry) { // While the user still has to put in a valid file name...
            first = false; // ...first = false, not needed anymore
            retry = false; // ...retry = false unless a FileNotFoundException occurs
            try {
                Scanner sc = new Scanner(System.in); // ...scanner obj to read user input
                System.out.print("Please enter the file that stores employee records: ");
                file = sc.nextLine(); // ...get file name from user
                File inputFile = new File(file); // ...open the file
                EmployeeReport e = new EmployeeReport(); // ...open the EmployeeReport
                e.readData(inputFile); // ...get data from file
                e.computeStats(inputFile);  // ...compute the statistics
                e.displayResults(inputFile); // ...print the results

            } catch (FileNotFoundException e) { // If a FileNotFoundException occurs...
                System.out.printf("\nError: File '%s' not found... Please try again\n", file); // ... print error
                retry = true; // ... continue the loop
            }
        }


    }
}
