package HW7;

public class Course {
    private String courseNum;
    private String courseName;
    private Faculty instructors;
    private Staff tas;
    private Student student;

    public Course(String courseNum, String courseName, Faculty instructors, Staff tas, Student student) {
        this.courseNum = courseNum;
        this.courseName = courseName;
        this.instructors = instructors;
        this.tas = tas;
        this.student = student;
    }

    public String getCourseNum() {
        return courseNum;
    }
    public String getCourseName() {
        return courseName;
    }
    public Faculty getInstructors() {
        return instructors;
    }
    public Staff getTas() {
        return tas;
    }
    public Student getStudent() {
        return student;
    }

    public void setCourseNum(String num){
        this.courseNum = num;
    }
    public void setCourseName(String name){
        this.courseName = name;
    }
    public void setInstructors(Faculty instructors) {
        this.instructors = instructors;
    }
    public void setTas(Staff tas) {
        this.tas = tas;
    }
     public void setStudent(Student student) {
        this.student = student;
    }
}
