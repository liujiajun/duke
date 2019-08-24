package task;

public class Event extends Task{

    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    public String toString() {
        return String.format(super.toString(), "\uD83D\uDCC5") + String.format(" (at: %s)", at);
    }
}
