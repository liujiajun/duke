package command;

import commons.DukeException;
import commons.Message;
import commons.Ui;
import storage.Storage;
import task.Task;

import java.util.ArrayList;

public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(int index) {
        this.index = index - 1;
    }

    public void execute(ArrayList<Task> tasks, Storage storage) throws DukeException {
        try {
            String message = Message.getDeletion(tasks.get(index), tasks);
            tasks.remove(index);
            storage.serialize(tasks);
            Ui.showToUser(message);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            throw new DukeException("Please provide valid index");
        }
    }
}
