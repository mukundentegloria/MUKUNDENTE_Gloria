package allquestions.q1;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

abstract class Mission {
    protected String missionId;
    protected String missionName;
    protected Date missionStartDate;
    protected Date missionEndDate;
    protected String status;
    protected List<Personnel> assignedPersonnel;


    public Mission(String missionId, String missionName, Date missionStartDate, Date missionEndDate, String status, List<Personnel> assignedPersonnel) {

        if (missionStartDate.after(missionEndDate)) {
            throw new IllegalArgumentException("Start date must be before end date.");
        }

        HashSet<String> ids = new HashSet<>();
        for (Personnel p : assignedPersonnel) {
            if (!ids.add(p.getPersonnelId())) {
                throw new IllegalArgumentException("Duplicate personnel found: " + p.getPersonnelId());
            }
        }
        this.missionId = missionId;
        this.missionName = missionName;
        this.missionStartDate = missionStartDate;
        this.missionEndDate = missionEndDate;
        this.status = status;
        this.assignedPersonnel = assignedPersonnel;
    }


    public abstract void assignTask();
    public abstract void allocateResources(List<Resource> availableResources);
    public abstract void trackMissionProgress();
    public abstract void generateMissionReport();


    public boolean validateMissionDuration(){
        return missionStartDate.before(missionEndDate);

    }

    public boolean validatePersonnelAssignment(){
        return assignedPersonnel.stream().map(Personnel::getPersonnelId).distinct().count() == assignedPersonnel.size();
    }


    public String getMissionId() {
        return missionId;
    }

    public void setMissionId(String missionId) {
        this.missionId = missionId;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public Date getMissionStartDate() {
        return missionStartDate;
    }

    public void setMissionStartDate(Date missionStartDate) {
        this.missionStartDate = missionStartDate;
    }

    public Date getMissionEndDate() {
        return missionEndDate;
    }

    public void setMissionEndDate(Date missionEndDate) {
        this.missionEndDate = missionEndDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Personnel> getAssignedPersonnel() {
        return assignedPersonnel;
    }

    public void setAssignedPersonnel(List<Personnel> assignedPersonnel) {
        this.assignedPersonnel = assignedPersonnel;
    }
}
