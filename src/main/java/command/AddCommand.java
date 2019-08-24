package command;

import commons.Message;
import commons.Ui;
import task.Task;

import java.util.ArrayList;

public class AddCommand extends Command{

    protected Task task;

    public AddCommand(Task task) {
        super();
        this.task = task;
    }

    public void execute(ArrayList<Task> tasks) {
        tasks.add(task);
        Ui.showToUser(Message.getAddition(task, tasks));
    }
}
