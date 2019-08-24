package task;

import parser.TimeParser;

import java.util.Date;

public class Event extends Task{

    protected Date at;

    public Event(String description, Date at) {
        super(description);
        this.at = at;
    }

    public String toString() {
        return String.format(super.toString(), "\uD83D\uDCC5") + String.format(" (at: %s)", TimeParser.convertDateToString(at));
    }
}
