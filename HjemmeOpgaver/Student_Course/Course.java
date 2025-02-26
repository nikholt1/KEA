
import java.util.Arrays;

public class Course {



    private Student[] students = new Student[0];
    private String courseName;
    private int maxParticipants;
    private int courseYear;


    // main constructor
    public Course(String courseName, int maxParticipants, int courseYear) {
        this.courseName = courseName;
        this.maxParticipants = maxParticipants;
        students = new Student[maxParticipants];
        this.courseYear = courseYear;
        System.out.println(Arrays.toString(students));
    }

    // methods
    public void addStudent(Student student) {
        int i = 0;
        for (; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                break;
            }
        }
        if (i >= maxParticipants) {
            System.out.println("course is full");

        }

    }
    public void removeStudent(int studentId) {
        for (int i = 0; i < students.length; i++) {
            System.out.println(studentId);
            if (students[i].getStudentId() == studentId) {
                System.out.println("removing" + students[i] + "from " + courseName);
                students[i] = null;

            }
            break;
        }
    }

    public void showStudentList() {
        System.out.println(Arrays.toString(students));
    }

    public String toString() {
        return "Course: " +
                "students=" + Arrays.toString(students) +
                ", courseName='" + courseName + '\'' +
                ", maxParticipants=" + maxParticipants +
                ", courseYear=" + courseYear
                ;
    }
}


