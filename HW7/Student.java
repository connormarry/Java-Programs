package HW7;

import HW5.Person;

public class Student extends Person
{
    private static int studentNumber;
    private static String studentName;
    public Student(String initialName, int initialStudentNumber)
    {
        super(initialName);
        studentName = initialName;
        studentNumber = initialStudentNumber;
    }

    public static String getStudentName() {
        return studentName;
    }

    public void reset(String newName, int newStudentNumber)
    {
        setName(newName);
        studentNumber = newStudentNumber;
    }
    public static int getStudentNumber()
    {
        return studentNumber;
    }
    public void setStudentNumber(int newStudentNumber)
    {
        studentNumber = newStudentNumber;
    }
    public void writeOutput()
    {
        System.out.println("Name: " + getName( ));
        System.out.println("Student Number: " + studentNumber);
    }
    public boolean equals(Student otherStudent)
    {
        return this.hasSameName(otherStudent) &&
                (studentNumber == otherStudent.getStudentNumber());
    }
}