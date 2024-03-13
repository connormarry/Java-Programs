package HW5;


public class Person {   // parent class

    // data members for the class

        String name;
        public Person(String initialName)
        {
            name = initialName;
        }
        public void setName(String newName)
        {
            name = newName;
        }
        public String getName()
        {
            return name;
        }
        public void writeOutput()
        {
            System.out.println("Name: " + name);
        }
        public boolean hasSameName(Person otherPerson)
        {
            return this.name.equalsIgnoreCase(otherPerson.name);
        }


    public static class Employee extends Person {    // child class

        // data members for the class
        String id;
        double salary;
        int year_of_hire;

        // constructor
        public Employee(String name, String id, double salary, int year_of_hire) {
            super(name);
            this.id = id;
            this.salary = salary;
            this.year_of_hire = year_of_hire;

        }

        // accessor methods
        public String getId() {
            return id;
        }

        public double getSalary() {
            return salary;
        }

        public int getYear_of_hire() {
            return year_of_hire;
        }

        public String getName() {
            return super.getName();
        }


        // mutator methods
        public void setId(String new_id) {
            this.id = new_id;
        }

        public void setSalary(double new_salary) {
            this.salary = new_salary;
        }

        public void setYear_of_hire(int new_year) {
            this.year_of_hire = new_year;
        }

        public void setName(String new_name) {
            super.setName(new_name);
        }

        // print output
        public void writeOutput() {
            System.out.printf("\nName: %s\n", this.name);
            System.out.printf("Employee ID: %s\n", this.id);
            System.out.printf("Salary: $%.2f\n", this.salary);
            System.out.printf("Year of Hire: %d\n", this.year_of_hire);
        }

        // compare two employees
        public boolean compareEmployees(Employee e) {
            return this.name.equals(e.getName()) &&
                    this.id.equals(e.getId()) &&
                    this.salary == e.getSalary() &&
                    this.year_of_hire == e.getYear_of_hire();
        }

    }
}

