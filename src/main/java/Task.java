public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "✅" : "❌"); //return tick or X symbols
    }

    public void setDone(boolean done) {
        this.isDone = done;
    }
}
