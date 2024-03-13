package HW5;
import java.util.Scanner;

public class TestEmployee {

    public static void main(String[] args) {
        // create booleans for error catching/rerunning
        boolean first_try = true;
        boolean retry = false;

        while (first_try || retry) {
            first_try = false;
            retry = false;
            try {
                // prompt user for input values for employee #1
                Scanner inputStream = new Scanner(System.in);
                System.out.println("Employee 1");
                System.out.print("Enter employee name: ");
                String name1 = inputStream.nextLine();
                System.out.print("Enter employee id: ");
                String id1 = inputStream.nextLine();
                System.out.print("Enter employee salary: ");
                double salary1 = inputStream.nextDouble();
                System.out.print("Enter date (year) of hire: ");
                int year_of_hire1 = inputStream.nextInt();

                // create employee object e1 using these values
                Person.Employee e1 = new Person.Employee(name1, id1, salary1, year_of_hire1);

                // print output of the instance variables for e1
                e1.writeOutput();

                // resets the name and salary of e1
                inputStream = new Scanner(System.in);
                System.out.print("\nEnter new name for employee #1: ");
                String new_name = inputStream.nextLine();
                System.out.print("Enter new salary for employee #1: ");
                double new_salary = inputStream.nextDouble();
                e1.setName(new_name);
                e1.setSalary(new_salary);


                // print updated output for e1
                e1.writeOutput();

                // prompt user for input values for employee #2
                inputStream = new Scanner(System.in);
                System.out.println("\nEmployee 2");
                System.out.print("Enter employee name: ");
                String name2 = inputStream.nextLine();
                System.out.print("Enter employee id: ");
                String id2 = inputStream.nextLine();
                System.out.print("Enter employee salary: ");
                double salary2 = inputStream.nextDouble();
                System.out.print("Enter date (year) of hire: ");
                int year_of_hire2 = inputStream.nextInt();


                // create employee object e2 using these values
                Person.Employee e2 = new Person.Employee(name2, id2, salary2, year_of_hire2);

                // redisplay the instance variables for e1 & e2
                System.out.println("\n╔══════════════════════════════════════╗");
                System.out.println(  "║       ↓ ↓ ↓   Results   ↓ ↓ ↓        ║");
                System.out.println(  "╚══════════════════════════════════════╝");
                System.out.print("\nEmployee 1");
                e1.writeOutput();
                System.out.print("\nEmployee 2");
                e2.writeOutput();

                // compare and print result
                if (e1.compareEmployees(e2)) {
                    System.out.println("\nThey are the same employee");
                } else {
                    System.out.println("\nThey are not the same employees");
                }

            } catch (Exception e) {
                System.out.println("\nError: Invalid Input\nPlease try again...\n");
                retry = true;
            }
        }
    }
}
