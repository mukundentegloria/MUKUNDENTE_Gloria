package allquestions.q3;
 public class MiddleClass extends NurseryClass {
     public MiddleClass(String classId) {
         super(classId, "Middle Class", 20);
     }

     @Override
     public boolean enrollStudent(Student student) {
         if (student.getAge() < 3 || student.getAge() > 4) {
             System.out.println("Student age not suitable for Middle Class.");
             return false;
         }
         if (students.size() >= maxCapacity) {
             System.out.println("Middle Class is full.");
             return false;
         }
         if (isDuplicateStudent(student.getStudentId())) {
             System.out.println("Duplicate student ID detected.");
             return false;
         }
         students.add(student);
         System.out.println("Student enrolled successfully in Middle Class.");
         return true;
     }

     @Override
     public void trackProgress() {
         System.out.println("Tracking language development and basic counting.");
     }

     @Override
     public void generateClassReport() {
         System.out.println("\n--- Class Report: Middle Class ---");
         System.out.println("Teacher: " + (assignedTeacher != null ? assignedTeacher.getTeacherName() : "None"));
         System.out.println("Total Students: " + students.size());
         System.out.println("Activities Conducted: " + activities);
     }
}

