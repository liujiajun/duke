package command;

import commons.Message;
import commons.Ui;
import task.Task;

import java.util.ArrayList;

public class ListCommand extends Command{
    public ListCommand() {

    }

    public void execute(ArrayList<Task> tasks) {
        Ui.showToUser(Message.getList(tasks));
    }
}
