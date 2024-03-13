package HW6;

import HW5.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EmployeeReport {
    double avg; // Average salary of all employees within a file
    double highest; // Highest salary
    String data; // The file itself: format = "name,id,salary,year_of_hire\n etc"
    Person.Employee topdawg; // The employee with the highest salary
    Person.Employee employee; // A given employee


    EmployeeReport() { // Constructor with no parameters, variables are set from method calls
        this.data = "";
        this.avg = 0;
        this.highest = 0;
        this.topdawg = new Person.Employee("", "", 0, 0);
        this.employee = new Person.Employee("", "", 0, 0);
    }



    // Method to read through file data
    public void readData(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file); // Scanner obj to read through file line-by-line
        StringBuilder file_data = new StringBuilder(); // StringBuilder obj to append each line

        while (sc.hasNextLine()) { // While there is data to be scanned...
            file_data.append(sc.nextLine()); // ...append line of data
            file_data.append("\n"); // ...append newline to keep separate
        }

       this.data = String.valueOf(file_data); // EmployeeReport data = file data
    }

    // Method to compute statistics
    public void computeStats(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file); // Scanner obj to read through file line-by-line
        double net_salaries = 0; // Stat: total amount of money between all employees' salaries
        int count = 0; // Stat: number of employees
        double average; // Stat: average
        double topdawgsalary = 0; // Stat: salary of the highest earning employee

        while (sc.hasNextLine()){ // While there is data to be scanned...
            String[] line = sc.nextLine().split(","); // ...split line of file data into an array
            String name = line[0]; // ...get name of employee
            String id = line[1]; // ...get id of employee
            double salary = Double.parseDouble(line[2]); // ...get salary of employee
            int year_of_hire = Integer.parseInt(line[3]); // ...get year of high of employee
            if (salary > topdawgsalary) { // If this employee makes more than the current top dawg...
                topdawgsalary = salary; // ...The new highest salary is that employee's salary
                this.topdawg = new Person.Employee(name, id, salary, year_of_hire); // ...employee is now the top dawg
            }
            net_salaries += salary; // Add salary to the total salaries stat
            count++; // Add 1 to the number of employees stat
        }

        average = net_salaries / count; // Compute average
        this.avg = average; // Set EmployeeReport average
        this.highest = topdawgsalary; // Set EmployeeReport highest
    }

    public void displayResults(File file) throws FileNotFoundException {
        System.out.printf("Average salary per employee is $%.2f\n", this.avg); // Print average
        System.out.printf("The highest salary is $%.2f\n", this.highest); // Print highest
        System.out.print("\nThe following had the highest salary:");
        topdawg.writeOutput();  // Print data for the highest paid employee
        System.out.printf("Their salary is $%.2f above the average.\n", this.highest - this.avg);
        System.out.print("\nThe rest performed as follows:");
        Scanner sc = new Scanner(file); // Scanner obj to read through file line-by-line
        while(sc.hasNextLine()){ // While there is data to be scanned...
            String[] line = sc.nextLine().split(","); // ...split line of file data into an array
            String name = line[0]; // ...get name of employee
            String id = line[1]; // ...get id of employee
            double salary = Double.parseDouble(line[2]); // ...get salary of employee
            int year_of_hire = Integer.parseInt(line[3]); // ...get year of high of employee
            this.employee = new Person.Employee(name, id, salary, year_of_hire); // Set EmployeeReport employee
            if (!employee.compareEmployees(topdawg)) { // If this employee is not the top earner...
                employee.writeOutput(); // ...print employee data
                if (employee.getSalary() < this.avg) { // ... if the employee makes less than the average...
                    System.out.printf("Their salary is $%.2f below the average.\n", this.avg - employee.getSalary());
                } else if (employee.getSalary() > this.avg) { // ... if the employee makes more than the average...
                    System.out.printf("Their salary is $%.2f above the average.\n", employee.getSalary() - this.avg);
                } else { // ... if the employee makes the average ...
                    System.out.println("Their salary is average.");
                }
            }
        }

    }


}


