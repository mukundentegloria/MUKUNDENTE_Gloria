package allquestions.q1;

public class Task {
    private String taskId;
    private String taskName;
    private String taskDescription;
    private boolean completed;

    public Task(String id, String name, String description) {
        this.taskId = id;
        this.taskName = name;
        this.taskDescription = description;
        this.completed = false;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
