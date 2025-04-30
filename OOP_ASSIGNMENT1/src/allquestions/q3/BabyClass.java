package allquestions.q3;

public class BabyClass extends NurseryClass{
    public BabyClass(String classId) {
        super(classId, "Baby Class", 15);
    }

    @Override
    public boolean enrollStudent(Student student) {
        if (student.getAge() < 2 || student.getAge() > 3) {
            System.out.println("Student age not suitable for Baby Class.");
            return false;
        }
        if (students.size() >= maxCapacity) {
            System.out.println("Baby Class is full.");
            return false;
        }
        if (isDuplicateStudent(student.getStudentId())) {
            System.out.println("Duplicate student ID detected.");
            return false;
        }
        students.add(student);
        System.out.println("Student enrolled successfully in Baby Class.");
        return true;
    }

    @Override
    public void trackProgress() {
        System.out.println("Tracking motor skills and play-based learning.");
    }

    @Override
    public void generateClassReport() {
        System.out.println("\n--- Class Report: Baby Class ---");
        System.out.println("Teacher: " + (assignedTeacher != null ? assignedTeacher.getTeacherName() : "None"));
        System.out.println("Total Students: " + students.size());
        System.out.println("Activities Conducted: " + activities);
    }

}
