package allquestions.q3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NurserySchoolManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BabyClass babyClass = new BabyClass("BC101");
        MiddleClass middleClass = new MiddleClass("MC101");
        TopClass topClass = new TopClass("TC101");

        Map<Integer, NurseryClass> classMap = new HashMap<>();
        classMap.put(1, babyClass);
        classMap.put(2, middleClass);
        classMap.put(3, topClass);

        while (true) {
            System.out.println("NURSERY SCHOOL MANAGEMENT MENU");
            System.out.println("===============================");
            System.out.println("1. Assign Teacher");
            System.out.println("2. Enroll Student");
            System.out.println("3. Conduct Activity");
            System.out.println("4. Add Assessment (Top Class only)");
            System.out.println("5. Track Progress");
            System.out.println("6. Generate Report");
            System.out.println("7. Exit");

            int option = readIntInRange(scanner, "Choose an option: ", 1, 7);
            if (option == 7) break;

            int classChoice = readIntInRange(scanner, "Select Class (1=Baby, 2=Middle, 3=Top): ", 1, 3);
            NurseryClass selectedClass = classMap.get(classChoice);
            if (selectedClass == null) {
                System.out.println("Invalid class selected.");
                continue;
            }

            switch (option) {
                case 1 -> {
                    String tid = readDigits(scanner, "Enter teacher ID (digits only): ");
                    String tname = readAlpha(scanner, "Enter teacher name: ");
                    String trole = readAlpha(scanner, "Enter teacher role: ");
                    Teacher t = new Teacher(tid, tname, trole);
                    selectedClass.assignTeacher(t);
                }
                case 2 -> {
                    String sid = readDigits(scanner, "Enter student ID (digits only): ");
                    String sname = readAlpha(scanner, "Enter student name: ");
                    int age = readInt(scanner, "Enter student age: ");
                    String gname = readAlpha(scanner, "Enter guardian name: ");
                    Student s = new Student(sid, sname, age, gname);
                    selectedClass.enrollStudent(s);
                }
                case 3 -> {
                    String activity = readAlpha(scanner, "Enter activity name: ");
                    selectedClass.conductActivity(activity);
                }
                case 4 -> {
                    if (selectedClass instanceof TopClass topC) {
                        String assessment = readAlpha(scanner, "Enter assessment detail: ");
                        topC.addAssessment(assessment);
                    } else {
                        System.out.println("Assessment only allowed for Top Class.");
                    }
                }
                case 5 -> selectedClass.trackProgress();
                case 6 -> selectedClass.generateClassReport();
                default -> System.out.println("INVALID OPTION.");
            }
        }

        scanner.close();
        System.out.println("Exiting system. Goodbye!");
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static int readIntInRange(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            int value = readInt(scanner, prompt);
            if (value >= min && value <= max) {
                return value;
            } else {
                System.out.println("Invalid choice. Please enter a number between " + min + " and " + max + ".");
            }
        }
    }

    private static String readAlpha(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input.matches("[a-zA-Z\\s]+")) {
                return input;
            } else {
                System.out.println("Invalid input. Please enter letters only.");
            }
        }
    }

    private static String readDigits(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input.matches("\\d+")) {
                return input;
            } else {
                System.out.println("Invalid input. Please enter digits only.");
            }
        }
    }
    }
