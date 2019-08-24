package command;

import commons.*;
import task.*;
import command.*;
import storage.*;

import java.util.ArrayList;

public abstract class Command {
    abstract public void execute(ArrayList<Task> tasks, Storage storage) throws DukeException;
}
