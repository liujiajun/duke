package command;

import commons.DukeException;
import commons.Message;
import commons.Ui;
import storage.Storage;
import task.Task;

import java.util.ArrayList;

public class FindCommand extends Command {
    private String keyWord;

    public FindCommand(String keyWord) {
        this.keyWord = keyWord.strip();
    }

    public void execute(ArrayList<Task> tasks, Storage storage) throws DukeException {
        ArrayList<Task> results = new ArrayList<>();
        for (Task t : tasks) {
            if (t.getDescription().contains(keyWord)) {
                results.add(t);
            }
        }
        Ui.showToUser(Message.getSearch(results));
    }
}
