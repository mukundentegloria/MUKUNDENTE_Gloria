package allquestions.q3;

public class Student {
    private String studentId;
    private String studentName;
    private int age;
    private String guardianName;

    public Student(String studentId, String studentName, int age, String guardianName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.guardianName = guardianName;
    }

    public String getStudentId() { return studentId; }
    public String getStudentName() { return studentName; }
    public int getAge() { return age; }
    public String getGuardianName() { return guardianName; }
}
