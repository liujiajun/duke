package command;

import commons.*;
import task.*;
import command.*;
import storage.*;
import java.util.*;

public class ListCommand extends Command{
    public ListCommand() {

    }

    public void execute(ArrayList<Task> tasks, Storage storage) {
        Ui.showToUser(Message.getList(tasks));
    }
}
