package command;

import commons.Message;
import commons.Ui;
import task.Task;

import java.util.ArrayList;

public class DoneCommand extends Command {

    protected Task task;

    protected int index;

    public DoneCommand(int index) {
        this.index = index - 1;
    }

    public void execute(ArrayList<Task> tasks) {
        task = tasks.get(index);
        task.setDone(true);
        Ui.showToUser(Message.getDone(task));
    }
}