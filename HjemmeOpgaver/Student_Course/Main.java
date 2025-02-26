package KEAOPGAVER.Afleveringer;


public class Main {

    public static void main(String[] args) {


        Student student1 = new Student("Niklas Holt Läu", 1234, 20, 2, 2000);

        Course course1 = new Course("Java Udemy", 2, 2025);
        course1.addStudent(student1);
        course1.showStudentList();
        course1.removeStudent(student1.getStudentId());
        course1.showStudentList();

        Student student2 = new Student("John Doe", 4312, 10, 12, 2001 );
        Student student3 = new Student("Jane doe", 9992, 15, 3, 1997);

        course1.addStudent(student2);
        course1.showStudentList();
        course1.addStudent(student3);
        course1.showStudentList();
        course1.addStudent(student1);
        course1.showStudentList();
        System.out.println(course1);
    }

}
