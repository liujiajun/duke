package command;

import commons.DukeException;
import commons.Message;
import commons.Ui;
import storage.Storage;
import task.Task;

import java.util.ArrayList;

public class ExitCommand extends Command {

    @Override
    public void execute(ArrayList<Task> tasks, Storage storage) throws DukeException {
        Ui.showToUser(Message.getExit());
        System.exit(0);
    }
}
