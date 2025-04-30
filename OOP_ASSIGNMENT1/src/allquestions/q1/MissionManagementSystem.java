package allquestions.q1;

import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;

public class MissionManagementSystem {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("MISSION MANAGEMENT SYSTEM");
        System.out.println("=========================");

        List<Personnel> personnelList = new ArrayList<>();
        System.out.println("Enter number of personnel to add:");
        int personnelCount = getPositiveIntInput();

        for (int i = 0; i < personnelCount; i++) {
            System.out.println("\n--- Enter Personnel " + (i + 1) + " Details ---");
            String id = getDigitsOnlyInput("ID (digits only): ");

            // String id = getNonEmptyAlphanumericString("ID: ");
            String name = getValidatedName("Name: ");
            String role = getValidatedName("Role: ");
            personnelList.add(new Personnel(id, name, role));
        }


        List<Resource> resourceList = new ArrayList<>();
        System.out.println("\nEnter number of resources to add:");
        int resourceCount = 3;

        for (int i = 0; i < resourceCount; i++) {
            System.out.println("\n--- Enter Resource " + (i + 1) + " Details ---");
            String name = getValidatedName("Resource Name: ");
            String type = getValidatedName("Resource Type: ");
            System.out.print("Quantity: ");
            int quantity = getPositiveIntInput();
            String description = getNonEmptyString("Description: ");
            resourceList.add(new Resource(name, type, quantity, description));
        }


        System.out.println("\nSelect Mission Type:");
        System.out.println("1. Recon Mission\n2. Rescue Mission\n3. Combat Mission\n4. Humanitarian Mission");
        int missionChoice = getMissionChoice();


        System.out.println("\n--- Enter Mission Details ---");
        String missionId = getNonEmptyAlphanumericString("Mission ID: ");
        String missionName = getValidatedName("Mission Name: ");

        Date startDate = getDateInput("Start Date (yyyy-MM-dd): ");
        Date endDate = getDateInput("End Date (yyyy-MM-dd): ");
        while (endDate.before(startDate)) {
            System.out.println("End date cannot be before start date. Please re-enter.");
            endDate = getDateInput("End Date (yyyy-MM-dd): ");
        }

        String status = getValidatedName("Mission Status: ");

        Mission mission = null;
        switch (missionChoice) {
            case 1:
                if (personnelList.size() < 2) {
                    System.out.println("ReconMission requires at least 2 personnel.");
                    return;
                }
                mission = new ReconMission(missionId, missionName, startDate, endDate, status, personnelList);
                break;
            case 2:
                mission = new RescueMission(missionId, missionName, startDate, endDate, status, personnelList);
                break;
            case 3:
                mission = new CombatMission(missionId, missionName, startDate, endDate, status, personnelList);
                break;
            case 4:
                mission = new HumanitarianMission(missionId, missionName, startDate, endDate, status, personnelList);
                break;
        }

        System.out.println("\n--- Executing Mission ---\n");
        mission.assignTask();
        mission.allocateResources(resourceList);
        mission.trackMissionProgress();
        mission.generateMissionReport();
    }

    private static int getPositiveIntInput() {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine());
                if (value > 0) return value;
                System.out.println("Please enter a positive number.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private static String getNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (!input.trim().isEmpty()) return input;
            System.out.println("Input cannot be empty.");
        }
    }

    private static String getNonEmptyAlphanumericString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty() && input.matches("[a-zA-Z0-9]+")) return input;
            System.out.println("Input must be non-empty and alphanumeric.");
        }
    }

    private static String getValidatedName(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty() && input.matches("[a-zA-Z ]+")) return input;
            System.out.println("Input must contain only letters and spaces.");
        }
    }

    private static Date getDateInput(String prompt) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        while (true) {
            System.out.print(prompt);
            String dateStr = scanner.nextLine();
            try {
                return sdf.parse(dateStr);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            }
        }
    }

    private static int getMissionChoice() {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 4) return choice;
                System.out.println("Please enter a valid choice (1-4).\n");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number between 1 and 4.");
            }
        }
    }

    private static String getDigitsOnlyInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty() && input.matches("\\d+")) {
                return input;
            } else {
                System.out.println("Input must be digits only and non-empty.");
            }
        }
    }

}

