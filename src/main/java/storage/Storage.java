package storage;

import commons.DukeException;
import task.Task;
import task.TaskList;

import java.util.*;
import java.io.*;

public class Storage {

    private String path;

    public Storage(String path) {
        this.path = path;
    }

    public void serialize(TaskList tasks) throws DukeException {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(tasks);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            throw new DukeException("IO Exception");
        }
    }

    public TaskList deserialize() throws DukeException {
        TaskList tasks = null;
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            tasks = (TaskList) in.readObject();
            in.close();
            fileIn.close();
            return tasks;
        } catch (ClassNotFoundException c) {
            throw new DukeException("File is damaged");
        } catch (IOException i) {
            if (i instanceof FileNotFoundException) {
                return new TaskList();
            }
            else { throw new DukeException("IO Exception"); }
        }
    }
}
