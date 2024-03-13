package HW7;

public class Undergraduate extends Student {
    private String thisLevel;

    public Undergraduate(String initialName, int initialStudentNumber, String initialLevel) {
        super(initialName, initialStudentNumber);
        thisLevel = initialLevel;
    }

    public void reset(String newName, int newStudentNumber, String newLevel) {
        setName(newName);
        setStudentNumber(newStudentNumber);
        thisLevel = newLevel;
    }

    public enum level {
        FRESHMAN, SOPHOMORE, JUNIOR, SENIOR;

    }
    public static level Level;

    public level getLevel() {
            return Level;
        }
    public void setLevel(level input) {
        Level = input;
    }


    public void writeOutput()
    {
        System.out.println("Name: " + getName( ));
        System.out.println("Student Number: " + getStudentNumber());
        System.out.println("Level: " + getLevel());
    }
    public boolean SameUndergrad(Undergraduate otherUndergraduate)
    {
        return this.hasSameName(otherUndergraduate)
                && this.equals(otherUndergraduate)
                && (Level == otherUndergraduate.getLevel());

    }
        }


