package allquestions.q1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HumanitarianMission extends Mission{
    private List<Resource> allocatedResources;
    public HumanitarianMission(String missionId, String missionName, Date missionStartDate, Date missionEndDate, String status, List<Personnel> assignedPersonnel) {
        super(missionId, missionName, missionStartDate, missionEndDate, status, assignedPersonnel);


        boolean hasLogisticsOrMedical = assignedPersonnel.stream()
                .anyMatch(p -> p.getPersonnelRole().equalsIgnoreCase("Logistics Officer") ||
                        p.getPersonnelRole().equalsIgnoreCase("Medic"));

        if (!hasLogisticsOrMedical) {
            throw new IllegalArgumentException("Humanitarian mission requires at least one Logistics Officer or Medic.");
        }
        // Link personnel to this mission
        for (Personnel p : assignedPersonnel) {
            p.setAssignedMission(this);
        }

        this.allocatedResources = new ArrayList<>();
    }


    @Override
    public void assignTask() {
        System.out.println("Assigning humanitarian tasks (logistics, distribution, medical aid):");
        for (Personnel p : assignedPersonnel) {
            System.out.println("- " + p.getPersonnelName() + " assigned to humanitarian task based on role.");
        }
    }

    @Override
    public void allocateResources(List<Resource> availableResources) {

        System.out.println("Allocating Humanitarian Resources...");

        boolean hasFood = false;
        boolean hasMedical = false;

        for (Resource r : availableResources) {
            if ((r.getResourceName().equalsIgnoreCase("Food Supplies") ||
                    r.getResourceName().equalsIgnoreCase("Medical Kit") ||
                    r.getResourceName().equalsIgnoreCase("Transport Vehicle")) && r.getQuantity() > 0) {
                allocatedResources.add(r);
                System.out.println("Allocated: " + r.getResourceName() + " x" + r.getQuantity());

                if (r.getResourceName().equalsIgnoreCase("Food Supplies")) hasFood = true;
                if (r.getResourceName().equalsIgnoreCase("Medical Kit")) hasMedical = true;
            }
        }


        if (!hasFood || !hasMedical) {
            System.out.println("Warning: Essential resources (Food or Medical Kits) are missing.");
        }
    }



    @Override
    public void trackMissionProgress() {
        System.out.println("Tracking Humanitarian Aid Distribution...");
        status = "IN_PROGRESS";
        System.out.println("Status updated to: " + status);

    }

    @Override
    public void generateMissionReport() {
        System.out.println("===== Humanitarian Mission Report =====");
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
        System.out.println("=======================================\n");
    }
    }


