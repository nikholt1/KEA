import java.time.LocalDate;
import java.time.Period;

public class Student {
    private String name;
    private int studentId;
    private Period ageCalc;
    private int age;

    public Student(String name, int studentId, int day, int month, int year) {
        this.name = name;
        this.studentId = studentId;
        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        ageCalc = Period.between(birthDate, today);
        this.age = ageCalc.getYears();


    }

    public int getStudentId() {
        return studentId;
    }


    public String toString() {
        return "Student" +
                "name='" + name + '\'' +
                ", studentId=" + studentId +
                ", age=" + age
                ;
    }
}
