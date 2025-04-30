package allquestions.q1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CombatMission extends Mission{
    private List<Resource> allocatedResources;

    public CombatMission(String missionId, String missionName, Date missionStartDate, Date missionEndDate, String status, List<Personnel> assignedPersonnel) {
        super(missionId, missionName, missionStartDate, missionEndDate, status, assignedPersonnel);



        if (assignedPersonnel.size() < 3) {
            throw new IllegalArgumentException("Combat Mission requires at least 3 personnel.");
        }
        this.allocatedResources = new ArrayList<>();
    }

    @Override
    public void assignTask() {
        System.out.println("Assigning combat-specific tasks (attack, defense, strategic movement):");
        for (Personnel p : assignedPersonnel) {
            System.out.println("- " + p.getPersonnelName() + " assigned to combat task.");
        }
    }


    @Override
    public void allocateResources(List<Resource> availableResources) {

        System.out.println("Allocating Combat Resources:");

        boolean hasAmmo = false;
        boolean hasVehicle = false;

        for (Resource r : availableResources) {
            if ((r.getResourceName().equalsIgnoreCase("Ammunition") ||
                    r.getResourceName().equalsIgnoreCase("Vehicle") ||
                    r.getResourceName().equalsIgnoreCase("Weapon")) && r.getQuantity() > 0) {

                allocatedResources.add(r);
                System.out.println("Allocated: " + r.getResourceName() + " x" + r.getQuantity());

                if (r.getResourceName().equalsIgnoreCase("Ammunition")) hasAmmo = true;
                if (r.getResourceName().equalsIgnoreCase("Vehicle")) hasVehicle = true;
            }

        }

        if (!hasAmmo || !hasVehicle) {
            System.out.println("Warning: Ensure ammunition and vehicle are available for combat effectiveness.");
        }
    }

    @Override
    public void trackMissionProgress() {
        System.out.println("Tracking Combat Mission Progress...");
        status = "IN_PROGRESS";
        System.out.println("Status updated to: " + status);
    }


    @Override
    public void generateMissionReport() {

        System.out.println("===== Combat Mission Report =====");
        System.out.println("Mission: " + missionName);
        System.out.println("Start: " + missionStartDate);
        System.out.println("End: " + missionEndDate);
        System.out.println("Status: " + status);
        System.out.println("Personnel Involved:");
        for (Personnel p : assignedPersonnel) {
            System.out.println("- " + p);
        }

        System.out.println("Resources Allocated:");
        for (Resource r : allocatedResources) {
            System.out.println("- " + r);
        }
        System.out.println("=================================\n");
    }

}

