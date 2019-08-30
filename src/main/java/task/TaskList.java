package task;

import commons.DukeException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TaskList implements Serializable {

    private List<Task> tasks = new ArrayList<>();

    public void add(Task task) {
        tasks.add(task);
    }

    public Task get(int index) {
        return tasks.get(index);
    }

    public void remove(int index) {
        tasks.remove(index);
    }

    public int size() {
        return tasks.size();
    }
}

