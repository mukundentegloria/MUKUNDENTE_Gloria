package allquestions.q3;
import java.util.ArrayList;
import java.util.List;

public abstract class NurseryClass {
    protected String classId;
    protected String className;
    protected int maxCapacity;
    protected Teacher assignedTeacher;
    protected List<Student> students = new ArrayList<>();
    protected List<String> activities = new ArrayList<>();

    public NurseryClass(String classId, String className, int maxCapacity) {
        this.classId = classId;
        this.className = className;
        this.maxCapacity = maxCapacity;
    }

    public abstract boolean enrollStudent(Student student);
    public abstract void trackProgress();

    public void conductActivity(String activityName) {
        activities.add(activityName);
        System.out.println("Activity conducted: " + activityName);
    }

    public abstract void generateClassReport();

    public boolean isDuplicateStudent(String studentId) {
        return students.stream().anyMatch(s -> s.getStudentId().equals(studentId));
    }

    public void assignTeacher(Teacher teacher) {
        if (this instanceof BabyClass && !teacher.getTeacherRole().equalsIgnoreCase("Early Childhood Educator")) {
            System.out.println("Only Early Childhood Educators can be assigned to Baby Class.");
            return;
        }
        this.assignedTeacher = teacher;
        System.out.println("\nTEACHER ASSIGNED SUCCESSFULLY TO " + className);
    }

    public String getClassName() {
        return className;
    }
}
