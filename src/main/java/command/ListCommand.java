package command;

import commons.Message;
import commons.Ui;
import storage.Storage;
import task.Task;
import task.TaskList;

import java.util.ArrayList;

public class ListCommand extends Command {
    public ListCommand() {

    }

    public void execute(TaskList tasks, Storage storage) {
        Ui.showToUser(Message.getList(tasks));
    }
}
