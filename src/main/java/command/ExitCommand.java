package command;

import commons.DukeException;
import commons.Message;
import commons.Ui;
import storage.Storage;
import task.Task;
import task.TaskList;

import java.util.ArrayList;

public class ExitCommand extends Command {

    @Override
    public void execute(TaskList tasks, Storage storage) throws DukeException {
        Ui.showToUser(Message.getExit());
        System.exit(0);
    }
}
