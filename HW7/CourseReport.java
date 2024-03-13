package HW7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class CourseReport {
    public static void main(String[] args) {
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Please enter filename of file that contains course info:");
                String filename = sc.next();
                File file = new File(filename);
                sc = new Scanner(file);
                int empCount = 0;
                int studentCount = 0;
                int taCount = 0;
                int insCount = 0;
                int gradCount = 0;
                int underCount = 0;
                int freshCount = 0;
                int sophCount = 0;
                int junCount = 0;
                int senCount = 0;
                int masCount = 0;
                int docCount = 0;
                StringBuilder instructors = new StringBuilder();
                StringBuilder tas = new StringBuilder();


                Course mycourse = new Course("", "", new Faculty("", "", 0, 0, ""), new Staff("", "", 0, 0, 0), new Student("", 0));
                while (sc.hasNextLine()) {
                    //Split each line into an array of 2 elements
                    String[] line = sc.nextLine().split(" ", 2);
                    //create course with default values
                    //Analyze each line and set data as needed
                    switch (line[0]) {
                        case "Number:" -> {
                            String coursenum = line[1];
                            mycourse.setCourseNum(coursenum);
                        }
                        case "Name:" -> {
                            String coursename = line[1];
                            mycourse.setCourseName(coursename);
                        }
                        case "Instructor:" -> {
                            String[] temp = line[1].split(";");
                            Faculty ins = new Faculty(temp[0], temp[1], Double.parseDouble(temp[2].replace(",", "").strip()), Integer.parseInt(temp[3].strip()), temp[4]);
                            mycourse.setInstructors(ins);
                            if (!instructors.toString().contains(ins.getName())) {
                                instructors.append(ins.getName()).append("\n");
                            }
                            insCount++;
                            empCount++;
                        }
                        case "Staff:" -> {
                            String[] temp = line[1].split(";");
                            Staff staff = new Staff(temp[0], temp[1], Double.parseDouble(temp[2].replace(",", "").strip()), Integer.parseInt(temp[3].strip()), Integer.parseInt(temp[4].strip()));
                            mycourse.setTas(staff);
                            if (!tas.toString().contains(staff.getName())) {
                                tas.append(staff.getName()).append("\n");
                            }
                            empCount++;
                        }
                        case "Undergraduate:" -> {
                            String[] temp = line[1].split(";");
                            Undergraduate undergrad = new Undergraduate(temp[0], Integer.parseInt(temp[1].strip()), temp[2]);
                            undergrad.setLevel(Undergraduate.level.valueOf(temp[2].strip()));
                            if (undergrad.getLevel().equals(Undergraduate.level.FRESHMAN)) {
                                freshCount++;
                            } else if (undergrad.getLevel().equals(Undergraduate.level.SOPHOMORE)) {
                                sophCount++;
                            } else if (undergrad.getLevel().equals(Undergraduate.level.JUNIOR)) {
                                junCount++;
                            } else if (undergrad.getLevel().equals(Undergraduate.level.SENIOR)) {
                                senCount++;
                            }
                            mycourse.setStudent(undergrad);
                            underCount++;
                            studentCount++;
                        }
                        case "Graduate:" -> {
                            String[] temp = line[1].split(";");
                            Graduate grad = new Graduate(temp[0], Integer.parseInt(temp[1].strip()), temp[2]);
                            grad.setProgram(Graduate.program.valueOf(temp[2].strip()));
                            if (grad.getProgram().equals(Graduate.program.DOCTORAL)) {
                                docCount++;
                            } else if (grad.getProgram().equals(Graduate.program.MASTERS)) {
                                masCount++;
                            }
                            mycourse.setStudent(grad);
                            gradCount++;
                            studentCount++;
                        }
                    }
                }


                while (true) {
                    //Prompt user for more info
                    System.out.print("""
                                                
                            What would you like to know?
                            1. Name of the course.
                            2. Number of the course.
                            3. How many employees?
                            4. Who are the instructors?
                            5. Who are the teaching assistants?
                            6. How many instructors are teaching?
                            7. How many teaching assistants?
                            8. How many students?
                            9. How many graduate students?
                            10. How many undergraduate students?
                            11. How many freshman/sophomore/juniors/seniors?
                            12. How many masters/doctoral students?
                            13. Find a specific student, either based on the student’s
                                 name or student number.
                            14. Exit
                            """);
                    sc = new Scanner(System.in);
                    switch (sc.nextLine()) {
                        case "1" -> System.out.println(mycourse.getCourseName());
                        case "2" -> System.out.println(mycourse.getCourseNum());
                        case "3" -> System.out.println(empCount);
                        case "4" -> System.out.println(instructors);
                        case "5" -> System.out.println(tas);
                        case "6" -> System.out.println(insCount);
                        case "7" -> System.out.println(taCount);
                        case "8" -> System.out.println(studentCount);
                        case "9" -> System.out.println(gradCount);
                        case "10" -> System.out.println(underCount);
                        case "11" ->
                                System.out.println("Freshman: " + freshCount + "\nSophomore: " + sophCount + "\nJunior: " + junCount + "\nSenior: " + senCount);
                        case "12" -> System.out.println("Masters: " + masCount + "\nDoctoral: " + docCount);
                        case "13" -> {
                            while (true) {
                                sc = new Scanner(System.in);
                                System.out.print("Would you like to search by name or number?: ");
                                if (sc.next().equalsIgnoreCase("name")) {
                                    System.out.print("Please enter name (last, first): ");
                                    Student student = new Student(sc.nextLine(), Student.getStudentNumber());
                                    student.writeOutput();
                                    break;
                                } else if (sc.next().equalsIgnoreCase("number")) {
                                    System.out.print("Please enter student number: ");
                                    Student student = new Student(Student.getStudentName(), sc.nextInt());
                                    student.writeOutput();
                                    break;
                                } else {
                                    System.out.println("Error: Please type either 'name' or 'number'...");
                                }
                            }
                        }
                        case "14" -> {
                            return;
                        }
                        default -> System.out.println("Error: Please enter an integer option between 1 and 14...");
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error: File not found...");
            }
        } while (true);
    }
}
