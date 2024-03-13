package HW7;

import HW5.Person;

public class Faculty extends Person.Employee {
    private String thisTitle;

    public Faculty (String name, String id, double salary, int year_of_hire, String initialTitle) {
        super(name, id, salary, year_of_hire);
        this.setId(id);
        this.setSalary(salary);
        this.setYear_of_hire(year_of_hire);
        thisTitle = initialTitle;
    }

    public void setTitle(String newTitle) {
        thisTitle = newTitle;
    }

    public String getTitle() {
        return thisTitle;
    }


    public void writeOutput () {
        System.out.printf("\nName: %s\n" + this.getName());
        System.out.printf("Employee ID %s\n", this.getId());
        System.out.printf("Salary: %f\n", this.getSalary());
        System.out.printf("Year of Hire: %d\n", this.getYear_of_hire());
        System.out.println("Title: " + thisTitle);
        }
    }


