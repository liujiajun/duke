package logic;

import command.Command;
import commons.DukeException;
import commons.Message;
import commons.Ui;
import parser.Parser;
import storage.Storage;
import task.TaskList;

import java.util.Scanner;

public class Duke {

    private Scanner SCANNER;
    private Storage STORAGE;
    private static TaskList tasks = new TaskList();

    public Duke() {
        SCANNER = new Scanner(System.in);
        STORAGE = new Storage("duke.dat");
    }

    public String getResponse(String input) {
        try {
            Command command = Parser.getCommand(input);
            command.execute(tasks, STORAGE);
        } catch (DukeException e) {
            Ui.showError(e.getMessage());
        }
        return Ui.getOutput();
    }

    public void initialize() {

        Ui.showToUser(Message.getWelcome());

        try {
            tasks = STORAGE.deserialize();
        } catch (DukeException e) {
            Ui.showError(e.getMessage());
        }
    }

    public void start() {
        initialize();

        while (SCANNER.hasNextLine()) {
            String line = SCANNER.nextLine();
            getResponse(line);
        }
    }

    public static void main(String[] args) {
        Duke duke = new Duke();
        duke.start();
    }

}
