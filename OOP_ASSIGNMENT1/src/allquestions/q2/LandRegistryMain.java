package allquestions.q2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LandRegistryMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Land> landList = new ArrayList<>();

        System.out.println(" LAND MANAGEMENT SYSTEM ");
        System.out.println("===========================");

        while (true) {
            System.out.println("\nChoose Land Type to Register:");
            System.out.println("1. Agricultural Land");
            System.out.println("2. Residential Land");
            System.out.println("3. Commercial Land");
            System.out.println("4. Industrial Land");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            if (choice.equals("5")) {
                System.out.println("Exiting...\n");
                break;
            }


            String landId = inputNumericString(scanner, "Enter Land ID (numbers only): ");
            String ownerName = inputAlphabeticString(scanner, "Enter Owner Name (letters only): ");
            String location = inputAlphabeticString(scanner, "Enter Location (letters only): ");
            double sizeInAcres = inputDouble(scanner, "Enter Size in Acres: ");
            String landUseStatus = inputAlphabeticString(scanner, "Enter Land Use Status (e.g., Vacant, In Use): ");
            Date registrationDate = new Date();

            Land land = null;

            switch (choice) {
                case "1":
                    land = new AgriculturalLand(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus);
                    break;
                case "2":
                    int units = inputInt(scanner, "Enter Number of Residential Units: ");
                    land = new ResidentialLand(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus, units);
                    break;
                case "3":
                    boolean isCommercialZone = inputBoolean(scanner, "Is it a Commercial Zone? (true/false): ");
                    land = new CommercialLand(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus, isCommercialZone);
                    break;
                case "4":
                    boolean hasClearance = inputBoolean(scanner, "Has Environmental Clearance? (true/false): ");
                    land = new IndustrialLand(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus, hasClearance);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    continue;
            }

            landList.add(land);
            System.out.println("\nRegistered Successfully! Generating Report...\n");
            land.generateLandReport();
        }

        System.out.println("\nAll Registered Lands:");
        for (Land l : landList) {
            l.generateLandReport();
        }

        scanner.close();
    }

    private static String inputString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (!input.trim().isEmpty()) {
                return input;
            }
            System.out.println("Invalid input. Please enter a valid string.");
        }
    }

    private static String inputNumericString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input.matches("\\d+")) {
                return input;
            }
            System.out.println("Invalid input. Please enter numbers only.");
        }
    }

    private static String inputAlphabeticString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input.matches("[a-zA-Z\\s]+")) {
                return input;
            }
            System.out.println("Invalid input. Please enter letters only.");
        }
    }

    private static double inputDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private static int inputInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
    }

    private static boolean inputBoolean(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("true") || input.equals("false")) {
                return Boolean.parseBoolean(input);
            }
            System.out.println("Invalid input. Please type 'true' or 'false'.");
        }
    }

}
