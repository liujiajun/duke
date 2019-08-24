package command;

import commons.*;
import task.*;
import command.*;
import storage.*;

import java.util.ArrayList;

public class AddCommand extends Command{

    protected Task task;

    public AddCommand(Task task) {
        super();
        this.task = task;
    }

    public void execute(ArrayList<Task> tasks, Storage storage) throws DukeException {
        tasks.add(task);
        storage.serialize(tasks);
        Ui.showToUser(Message.getAddition(task, tasks));
    }
}
