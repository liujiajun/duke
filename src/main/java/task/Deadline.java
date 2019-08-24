package task;

import parser.TimeParser;

import java.util.Date;

public class Deadline extends Task {

    protected Date by;

    public Deadline(String description, Date by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return String.format(super.toString(), "⏰") + String.format(" (by: %s)", TimeParser.convertDateToString(by));
    }
}
