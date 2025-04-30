package allquestions.q3;

import java.util.ArrayList;
import java.util.List;

public class TopClass extends NurseryClass{
    private List<String> assessments = new ArrayList<>();

    public TopClass(String classId) {
        super(classId, "Top Class", 25);
    }

    @Override
    public boolean enrollStudent(Student student) {
        if (student.getAge() < 4 || student.getAge() > 5) {
            System.out.println("Student age not suitable for Top Class.");
            return false;
        }
        if (students.size() >= maxCapacity) {
            System.out.println("Top Class is full.");
            return false;
        }
        if (isDuplicateStudent(student.getStudentId())) {
            System.out.println("Duplicate student ID detected.");
            return false;
        }
        students.add(student);
        System.out.println("Student enrolled successfully in Top Class.");
        return true;
    }

    public void addAssessment(String assessment) {
        assessments.add(assessment);
        System.out.println("Assessment added: " + assessment);
    }

    @Override
    public void trackProgress() {
        System.out.println("Tracking reading, writing, and arithmetic progress.");
    }

    @Override
    public void generateClassReport() {
        System.out.println("\n--- Class Report: Top Class ---");
        System.out.println("Teacher: " + (assignedTeacher != null ? assignedTeacher.getTeacherName() : "None"));
        System.out.println("Total Students: " + students.size());
        System.out.println("Activities Conducted: " + activities);
        System.out.println("Assessments Done: " + assessments);
    }

}
