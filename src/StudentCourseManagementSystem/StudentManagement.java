package StudentCourseManagementSystem;

import StudentCourseManagementSystem.Exception.InvalidStudentIdException;

import java.util.Scanner;

class Student {
    private int studentId;
    private String studentName;
    private String registeredCourse;
    private final Student[] JavaCourseStudents = new Student[10];
    private final Student[] PythonCourseStudents = new Student[10];
    private int JavaCourseIndex = 0;
    private int PythonCourseIndex = 0;
    private int JavaCourseCapacity = 10;
    private int PythonCourseCapacity = 10;

    public Student() {

    }

    public Student(int studentId, String studentName, String registeredCourse) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.registeredCourse = registeredCourse;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setRegisteredCourse(String registeredCourse) {
        this.registeredCourse = registeredCourse;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getRegisteredCourse() {
        return registeredCourse;
    }

    public boolean addStudentInJavaCourse(Student student) {
        if (JavaCourseIndex < JavaCourseCapacity) {
            JavaCourseStudents[JavaCourseIndex] = student;
            JavaCourseIndex++;
            return true;
        } else {
            return false;
        }
    }

    public boolean addStudentInPythonCourse(Student student) {
        if (PythonCourseIndex < PythonCourseCapacity) {
            PythonCourseStudents[PythonCourseIndex] = student;
            PythonCourseIndex++;
            return true;
        } else {
            return false;
        }
    }

    public boolean removeJavaCourseStudent(int id) {
        for (int i = 0; i < JavaCourseIndex; i++) {
            if (JavaCourseStudents[i].studentId == id) {
                // Shifting elements to remove the student
                for (int j = i; j < JavaCourseIndex - 1; j++) {
                    JavaCourseStudents[j] = JavaCourseStudents[j + 1];
                }
                JavaCourseStudents[JavaCourseIndex - 1] = null;
                JavaCourseIndex--;
                return true;
            }
        }
        return false;
    }
    public boolean removePythonCourseStudent(int id) {
        for (int i = 0; i < PythonCourseIndex; i++) {
            if (PythonCourseStudents[i].studentId == id) {
                // Shifting elements to remove the student
                for (int j = i; j < PythonCourseIndex - 1; j++) {
                    PythonCourseStudents[j] = PythonCourseStudents[j + 1];
                }
                PythonCourseStudents[PythonCourseIndex - 1] = null;
                PythonCourseIndex--;
                return true;
            }
        }
        return false;
    }
    public void printJavaCourseStudents() {
        for (int i = 0; i < JavaCourseIndex; i++) {
            System.out.println(JavaCourseStudents[i]);
        }
    }
    public void printPythonCourseStudents() {
        for (int i = 0; i < PythonCourseIndex; i++) {
            System.out.println(PythonCourseStudents[i]);
        }
    }


    @Override
    public String toString() {
        return "StudentDatabase{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", registeredCourse='" + registeredCourse + '\'' +
                '}';
    }
}
public class StudentManagement {


    public static void CourseListing(int studentId) throws InvalidStudentIdException {
        int option;

        Student JavaCourse = new Student();

        Student PythonCourse = new Student();

        Student StudentEntry = new Student();

        //creating few student objects
        Student StudentEntry1 = new Student(1,"Tanvi","Java");
        Student StudentEntry2 = new Student(2,"Soni","Java");
        Student StudentEntry3 = new Student(3,"Rajesh","Java");
        Student StudentEntry4 = new Student(4,"Ujwala","Java");
        Student StudentEntry5 = new Student(5,"Ankit","Python");
        Student StudentEntry6 = new Student(6,"Anushka","Python");
        Student StudentEntry7 = new Student(7,"Yusra","Python");
        Student StudentEntry8 = new Student(8,"Saneeya","Python");

        //Adding some students to Java course
        JavaCourse.addStudentInJavaCourse(StudentEntry1);
        JavaCourse.addStudentInJavaCourse(StudentEntry2);
        JavaCourse.addStudentInJavaCourse(StudentEntry3);
        JavaCourse.addStudentInJavaCourse(StudentEntry4);

        //Adding some students to Python course
        PythonCourse.addStudentInPythonCourse(StudentEntry5);
        PythonCourse.addStudentInPythonCourse(StudentEntry6);
        PythonCourse.addStudentInPythonCourse(StudentEntry7);
        PythonCourse.addStudentInPythonCourse(StudentEntry8);

        Scanner Input = new Scanner(System.in);

        System.out.println("Course listing");
        System.out.println("Available courses are : ");
        System.out.println("1.Java Course (2pm-4pm)");
        System.out.println("2.Python Course (4pm-6pm)");
        System.out.println("3.View course details");
        System.out.println("4.Exit");
        System.out.println("Choose an option");

        option = Input.nextInt();
        switch (option){
            case 1:
                System.out.println("Choose an option");
                System.out.println("1.Register for Java course");
                System.out.println("2.Drop Java course");
                System.out.println("3.View registered students");
                System.out.println("4.Exit");

                option = Input.nextInt();
                switch (option){
                    case 1:
                        StudentEntry.setStudentId(studentId);

                        System.out.println("Enter your First Name");
                        StudentEntry.setStudentName(Input.next());

                        StudentEntry.setRegisteredCourse("Java");

                        JavaCourse.addStudentInJavaCourse(StudentEntry);

                        System.out.println("Successful registration");

                        studentId++;

                        System.out.println("view student list (Yes/No)");
                        String option2 = Input.next();
                        if (option2.equalsIgnoreCase("Yes")) {
                            JavaCourse.printJavaCourseStudents();
                        }

                        CourseListing(studentId);
                        break;

                    case 2:
                        System.out.println("Enter student id");
                        studentId = Input.nextInt();

                        if (JavaCourse.getStudentId() != studentId ){
                            throw new InvalidStudentIdException("Student Id " + studentId + " does not exists.  Please enter a valid Student Id4" +
                                    ".");
                        }else {
                            JavaCourse.removeJavaCourseStudent(studentId);
                            System.out.println("student removed successfully");
                        }
                        System.out.println("view student list (Yes/No)");
                        option2 = Input.next();
                        if (option2.equalsIgnoreCase("Yes")) {
                            JavaCourse.printJavaCourseStudents();
                        }

                        CourseListing(studentId);
                        break;

                    case 3:
                        JavaCourse.printJavaCourseStudents();

                        CourseListing(studentId);
                        break;
                    case 4:
                        exit();
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
                break;


                case 2:
                    System.out.println("Choose an option");
                    System.out.println("1.Register for Python course");
                    System.out.println("2.Drop Python course");
                    System.out.println("3.View registered students");
                    System.out.println("4.Exit");

                    option = Input.nextInt();
                    switch (option){
                        case 1:
                            StudentEntry.setStudentId(studentId);

                            System.out.println("Enter your First Name");
                            StudentEntry.setStudentName(Input.next());

                            StudentEntry.setRegisteredCourse("Python");

                            PythonCourse.addStudentInPythonCourse(StudentEntry);

                            System.out.println("Successful registration");

                            studentId++;
                            System.out.println("view student list (Yes/No)");
                            String option2 = Input.next();
                            if (option2.equalsIgnoreCase("Yes")) {
                                PythonCourse.printPythonCourseStudents();
                            }

                            CourseListing(studentId);
                            break;
                        case 2:
                            if (PythonCourse.getStudentId() != studentId){
                                throw new InvalidStudentIdException("Student Id " + studentId + " does not exists. Please enter a valid Student Id.");
                            }else {
                                System.out.println("Enter student id");
                                studentId = Input.nextInt();
                                PythonCourse.removePythonCourseStudent(studentId);
                                System.out.println("StudentCourseManagementSystem.Student removed successfully!1");
                            }
                            System.out.println("view student list (Yes/No)");
                            option2 = Input.next();
                            if (option2.equalsIgnoreCase("Yes")) {
                                PythonCourse.printPythonCourseStudents();
                            }

                            CourseListing(studentId);
                            break;
                        case 3:
                            PythonCourse.printPythonCourseStudents();
                            CourseListing(studentId);
                            break;
                        case 4:
                            exit();
                            break;
                        default:
                            System.out.println("Invalid option");
                            break;
                    }
                    break;
            case 3:
                System.out.println("1.view java course details");
                System.out.println("2.view python course details");
                option = Input.nextInt();
                displayCourseDetails(option);
            case 4:
                exit();
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }
    public static void exit(){
        System.out.println("Thank You for Visiting!");
    }
    public static void displayCourseDetails(int option){
        if(option==1) {
            System.out.println("Course Code: CS101-JAVA");
            System.out.println("Course Title: Introduction to Java Programming");
            System.out.println("Course Description: This course provides a comprehensive introduction to Java programming, focusing on fundamental concepts such as variables, data types, control structures (loops, conditionals), object-oriented programming (OOP), and basic libraries. It is designed for beginners who want to learn the Java language and how to create simple applications. The course will cover writing, debugging, and testing basic Java programs, as well as understanding Java's platform-independent nature.");
            System.out.println("Capacity: 10 students");
            System.out.println("Schedule: 2:00 PM to 4:00 PM (Monday to Friday)");
        } else if (option == 2) {
            System.out.println("Course Code: CS102-PYTHON");
            System.out.println("Course Title: Introduction to Python Programming");
            System.out.println("Course Description: This course introduces students to the Python programming language, emphasizing simplicity and readability. It covers the basic concepts like variables, data types, control structures, functions, and error handling. The course will also introduce basic Python libraries and tools that are essential for data analysis, web development, and automation. Ideal for beginners, the course will also provide a foundation for more advanced topics in Python.");
            System.out.println("Capacity: 10 students");
            System.out.println("Schedule: 4:00 PM to 6:00 PM (Monday to Friday)");
        }else {
            System.out.println("Invalid option");
        }
    }
    public static void main(String[] args) {

        int studentId = 9;

        try {
            CourseListing(studentId);
        }catch (InvalidStudentIdException e){
            System.out.println(e.getMessage());
        }

    }
}
