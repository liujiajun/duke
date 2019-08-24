package command;

import commons.*;
import task.*;
import command.*;
import storage.*;
import java.util.*;

public class DoneCommand extends Command {

    protected int index;

    public DoneCommand(int index) { this.index = index - 1; }

    public void execute(ArrayList<Task> tasks, Storage storage) throws DukeException {
        try {
            tasks.get(index).setDone(true);
            storage.serialize(tasks);
            Ui.showToUser(Message.getDone(tasks.get(index)));
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Index out of bound.");
        }

    }
}