package allquestions.q1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReconMission extends Mission{
    private List<Resource> allocatedResources;

    public ReconMission(String missionId, String missionName, Date missionStartDate, Date missionEndDate, String status, List<Personnel> assignedPersonnel) {
        super(missionId, missionName, missionStartDate, missionEndDate, status, assignedPersonnel);



        if (assignedPersonnel.size() < 2) {
            throw new IllegalArgumentException("Recon Mission must have at least 2 personnel assigned.");

        }

        for (Personnel p : assignedPersonnel) {
            p.setAssignedMission(this);
        }

        this.allocatedResources = new ArrayList<>();
    }

    @Override
    public void assignTask() {
        System.out.println("Assigning reconnaissance tasks (surveillance, intelligence gathering):");
        for (Personnel p : assignedPersonnel) {
            System.out.println("- " + p.getPersonnelName() + " assigned to intel task.");
        }
    }

    public void allocateResources(List<Resource> availableResources) {
        System.out.println("Allocating Reconnaissance Resources:");
        boolean droneAvailable = false;


        for (Resource r : availableResources) {
            if (r.getResourceName().equalsIgnoreCase("Drone") && r.getQuantity() > 0) {
                droneAvailable = true;
                allocatedResources.add(r);
                System.out.println("Allocated: " + r.getResourceName() + " x" + r.getQuantity());
            } else if ((r.getResourceName().equalsIgnoreCase("Communication Tool") ||
                    r.getResourceName().equalsIgnoreCase("Camera")) && r.getQuantity() > 0) {
                allocatedResources.add(r);
                System.out.println("Allocated: " + r.getResourceName() + " x" + r.getQuantity());
            }
        }

        if (!droneAvailable) {
            System.out.println("Error: Recon mission requires at least one drone. None available.");
        }
    }

    @Override
    public void trackMissionProgress() {
        System.out.println("Tracking Recon Mission Progress...");
        status = "IN_PROGRESS";
        System.out.println("Status updated to: " + status);
    }

    @Override
    public void generateMissionReport() {

        System.out.println("----- Recon Mission Report -----");
        System.out.println("Mission Name: " + missionName);
        System.out.println("Start Date: " + missionStartDate);
        System.out.println("End Date: " + missionEndDate);
        System.out.println("Status: " + status);
        System.out.println("Personnel Assigned:");

        for (Personnel p : assignedPersonnel) {
            System.out.println("- " + p);

            System.out.println("Resources Allocated:");
            for (Resource r : allocatedResources) {
                System.out.println("- " + r);
            }

            System.out.println("Tasks: Reconnaissance and intelligence gathering.");
            System.out.println("--------------------------------\n");
        }
    }

    }

