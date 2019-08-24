package command;

import commons.*;
import task.*;
import command.*;
import storage.*;
import java.util.*;

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
