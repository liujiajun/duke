package task;

public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    public String toString() {
        return String.format(super.toString(), "\uD83D\uDCCB");
    }
}
