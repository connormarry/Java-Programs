package HW7;

import HW5.Person;

public class Staff extends Person.Employee {

    private final int payGrade;

    public Staff(String name, String id, double salary, int year_of_hire, int initialPaygrade) {
        super(name, id, salary, year_of_hire);
        payGrade = initialPaygrade;
    }

    public int getPaygrade(){
        return payGrade;
    }

    public void writeOutput () {
        System.out.printf("\nName: %s\n" + this.getName());
        System.out.printf("Employee ID %s\n", this.getId());
        System.out.printf("Salary: %f\n", this.getSalary());
        System.out.printf("Year of Hire: %d\n", this.getYear_of_hire());
        System.out.println("Pay Grade: " + payGrade);
            }
}





