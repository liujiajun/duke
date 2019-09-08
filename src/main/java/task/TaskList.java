package task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a list of Task objects.
 */
public class TaskList implements Serializable {

    private List<Task> tasks = new ArrayList<>();

    /**
     * Add a new Task.
     *
     * @param task the Task to add.
     */
    public void add(Task task) {
        tasks.add(task);
    }

    /**
     * Get a Task.
     * @param index index of the Task to get.
     * @return a Task at the index.
     */
    public Task get(int index) {
        return tasks.get(index);
    }

    /**
     * Remove a Task.
     * @param index index of the Task to remove.
     */
    public void remove(int index) {
        tasks.remove(index);
    }

    /**
     * Returns the number of Tasks in the list.
     * @return the number of Tasks in the list.
     */
    public int size() {
        return tasks.size();
    }
}

