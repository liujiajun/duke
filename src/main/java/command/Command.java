package command;

import commons.DukeException;
import storage.Storage;
import task.Task;

import java.util.ArrayList;

public abstract class Command {
    abstract public void execute(ArrayList<Task> tasks, Storage storage) throws DukeException;
}
