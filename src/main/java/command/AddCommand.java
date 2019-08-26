package command;

import commons.DukeException;
import commons.Message;
import commons.Ui;
import storage.Storage;
import task.Task;

import java.util.ArrayList;

public class AddCommand extends Command {

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
