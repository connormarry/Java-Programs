package HW7;


public class Graduate extends Student {
    private String thisProgram;

    public Graduate(String initialName, int initialStudentNumber, String initialProgram) {
        super(initialName, initialStudentNumber);
        thisProgram = initialProgram;
    }

    public void reset(String newName, int newStudentNumber, String newProgram) {
        setName(newName);
        setStudentNumber(newStudentNumber);
        thisProgram = newProgram;
    }

    public enum program {
        MASTERS, DOCTORAL;
    }
    public static program Program;

    public program getProgram() {
        return Program;
    }

    public void setProgram(program input) {Program = input;}

    public void writeOutput() {
        System.out.println("Name: " + getName());
        System.out.println("Student Number: " + getStudentNumber());
        System.out.println("Program: " + getProgram());
    }

    public boolean SameGrad(Graduate otherGraduate) {
        return this.hasSameName(otherGraduate)
                && this.equals(otherGraduate)
                && (Program == otherGraduate.getProgram());
    }
}
