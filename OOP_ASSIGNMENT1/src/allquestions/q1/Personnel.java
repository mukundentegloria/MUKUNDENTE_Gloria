package allquestions.q1;

public class Personnel {
    private String personnelId;
    private String personnelName;
    private String personnelRole;
    private Mission assignedMission;


    public Personnel(String id, String name, String role) {
        this.personnelId = id;
        this.personnelName = name;
        this.personnelRole = role;
    }

    public Personnel(String personnelId, String personnelName, String personnelRole, Mission assignedMission) {
        this.personnelId = personnelId;
        this.personnelName = personnelName;
        this.personnelRole = personnelRole;
        this.assignedMission = assignedMission;
    }

    public String getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(String personnelId) {
        this.personnelId = personnelId;
    }

    public String getPersonnelName() {
        return personnelName;
    }

    public void setPersonnelName(String personnelName) {
        this.personnelName = personnelName;
    }

    public String getPersonnelRole() {
        return personnelRole;
    }

    public void setPersonnelRole(String personnelRole) {
        this.personnelRole = personnelRole;
    }

    public Mission getAssignedMission() {
        return assignedMission;
    }

    public void setAssignedMission(Mission assignedMission) {
        this.assignedMission = assignedMission;
    }

}
