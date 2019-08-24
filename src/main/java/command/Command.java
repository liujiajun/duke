package command;

import commons.DukeException;
import task.Task;

import java.util.ArrayList;

public abstract class Command {
    abstract public void execute(ArrayList<Task> tasks) throws DukeException;
}
