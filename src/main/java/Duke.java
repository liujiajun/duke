import command.*;
import storage.Storage;
import task.*;
import commons.*;
import parser.*;
import java.util.*;

public class Duke {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Storage STORAGE = new Storage("duke.dat");
    private static TaskList tasks = new TaskList();

    public static void main(String[] args) {
        Ui.showToUser(Message.getWelcome());

        try {
            tasks = STORAGE.deserialize();
        } catch (DukeException e) {
            Ui.showError(e.getMessage());
        }

        while(SCANNER.hasNextLine()) {
            String line = SCANNER.nextLine();
            try {
                Command command = Parser.getCommand(line);
                command.execute(tasks, STORAGE);
            } catch (DukeException e) {
                Ui.showError(e.getMessage());
            }

        }
    }

}
