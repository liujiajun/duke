package command;

import commons.DukeException;
import storage.Storage;
import task.Task;
import task.TaskList;

import java.util.ArrayList;

public abstract class Command {
    abstract public void execute(TaskList tasks, Storage storage) throws DukeException;
}
