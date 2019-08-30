package command;

import commons.DukeException;
import commons.Message;
import commons.Ui;
import storage.Storage;
import task.Task;
import task.TaskList;

import java.util.ArrayList;

public class DoneCommand extends Command {

    protected int index;

    public DoneCommand(int index) {
        this.index = index - 1;
    }

    public void execute(TaskList tasks, Storage storage) throws DukeException {
        try {
            tasks.get(index).setDone(true);
            storage.serialize(tasks);
            Ui.showToUser(Message.getDone(tasks.get(index)));
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Index out of bound.");
        }

    }
}