package task;

import parser.TimeParser;

import java.util.Date;

public class Event extends Task{

    protected Date from;
    protected Date to;

    public Event(String description, Date from, Date to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    public String toString() {
        return String.format(super.toString(), "\uD83D\uDCC5") + String.format(" (%s -- %s)", TimeParser.convertDateToString(from), TimeParser.convertDateToString(to));
    }
}
