package allquestions.q1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RescueMission extends Mission {
    private List<Resource> allocatedResources;

    public RescueMission(String missionId, String missionName, Date missionStartDate, Date missionEndDate, String status, List<Personnel> assignedPersonnel) {
        super(missionId, missionName, missionStartDate, missionEndDate, status, assignedPersonnel);




        boolean hasMedic = false;
        for (Personnel p : assignedPersonnel) {
            if (p.getPersonnelRole().equalsIgnoreCase("Medic")) {
                hasMedic = true;
                break;
            }
        }

        if (!hasMedic) {
            throw new IllegalArgumentException("A Rescue Mission must have at least one Medic assigned.");
        }

        for (Personnel p : assignedPersonnel) {
            p.setAssignedMission(this);
        }

        this.allocatedResources = new ArrayList<>();
    }



    @Override
    public void assignTask() {
        System.out.println("Assigning rescue, medical, and logistics tasks to personnel:");
        for (Personnel p : assignedPersonnel) {
            System.out.println("- " + p.getPersonnelName() + " is assigned based on role: " + p.getPersonnelRole());
        }
    }

    @Override
    public void allocateResources (List<Resource> availableResources) {
        System.out.println("Allocating Rescue Resources:");
        boolean hasMedicalKit = false;

        for (Resource r : availableResources) {
            if ((r.getResourceName().equalsIgnoreCase("Medical Kit") ||
                    r.getResourceName().equalsIgnoreCase("Ambulance") ||
                    r.getResourceName().equalsIgnoreCase("Rescue Equipment")) && r.getQuantity() > 0) {

                allocatedResources.add(r);
                System.out.println("Allocated: " + r.getResourceName() + " x" + r.getQuantity());

                if (r.getResourceName().equalsIgnoreCase("Medical Kit")) {
                    hasMedicalKit = true;
                }
            }

        }

        if (!hasMedicalKit) {
            System.out.println("Warning: No Medical Kits allocated. This may impact mission success.");
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

        System.out.println("----- Rescue Mission Report -----");
        System.out.println("Mission Name: " + missionName);
        System.out.println("Start Date: " + missionStartDate);
        System.out.println("End Date: " + missionEndDate);
        System.out.println("Status: " + status);

        System.out.println("Personnel Assigned:");
        for (Personnel p : assignedPersonnel) {
            System.out.println("- " + p.getPersonnelName() + " (" + p.getPersonnelRole() + ")");
        }
        System.out.println("Resources Allocated:");
        for (Resource r : allocatedResources) {
            System.out.println("- " + r.getResourceName() + " (" + r.getQuantity() + ")");
        }

        System.out.println("Tasks: Rescue, medical aid, logistics support.");
        System.out.println("----------------------------------");
    }
    }

