import command.*;
import task.*;
import commons.*;
import java.util.*;

public class Duke {
    private static final String BEGIN_DIVIDER = "----------------------------------------------";
    private static final String END_DIVIDER = BEGIN_DIVIDER + System.lineSeparator();
    private static final String LINE_PREFIX = "     ";

    private static final String COMMAND_LIST = "list";
    private static final String COMMAND_BYE = "bye";
    private static final String COMMAND_DONE = "done";
    private static final String COMMAND_TODO = "todo";
    private static final String COMMAND_DEADLINE = "deadline";
    private static final String COMMAND_EVENT = "event";
    private static final String COMMAND_DELETE = "delete";

    private static final Scanner SCANNER = new Scanner(System.in);

    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Ui.showToUser(Message.getWelcome());
        while(SCANNER.hasNextLine()) {
            String line = SCANNER.nextLine();
            try {
                Command command = getCommand(line);
                command.execute(tasks);
            } catch (DukeException e) {
                Ui.showError(e.getMessage());
            }

        }
    }

    private static Command getCommand(String line) throws DukeException{
        String commandWord = line.strip().split(" ")[0];
        switch (commandWord) {
            case COMMAND_TODO:
                return parseTodo(line);
            case COMMAND_DEADLINE:
                return parseDeadline(line);
            case COMMAND_EVENT:
                return parseEvent(line);
            case COMMAND_LIST:
                return parseList(line);
            case COMMAND_DONE:
                return parseDone(line);
//            case COMMAND_DELETE:
//                return parseDeletion(line);
        }
        throw new DukeException(Message.MESSAGE_UNKNOWN_COMMAND);
    }

    private static Dictionary<String, String> getCommandArgs(String line) throws DukeException{
        if (line.indexOf(" ") == -1) throw new DukeException("Please enter valid arguemnts");
        Dictionary<String, String> args = new Hashtable<String, String>();
        String argsLine;
        try {
            argsLine = line.strip().substring(line.indexOf(" ") + 1);
        } catch (StringIndexOutOfBoundsException e) {
            throw new DukeException("Please enter valid arguemnts");
        }

        String[] splitted = argsLine.strip().split(" /");
        args.put("primary", splitted[0]);
        for (String s : splitted) {
            if (s.isEmpty()) { continue; }
            String para = s.split(" ")[0];
            try {
                String value = s.substring(s.indexOf(" ") + 1);
                args.put(para, value);
            } catch (StringIndexOutOfBoundsException e){
                throw new DukeException("Please enter valid arguemnts");
            }

        }
        return args;
    }
    private static Command parseTodo(String line) throws DukeException{
        Dictionary<String, String> args = getCommandArgs(line);
        Todo todo = new Todo(args.get("primary"));

        if (args.get("primary") == null) { throw new DukeException("Please enter todo description"); }

        return new AddCommand(todo);
    }

    private static Command parseDeadline(String line) throws DukeException{
        Dictionary<String, String> args = getCommandArgs(line);
        if (args.get("primary") == null) { throw new DukeException("Please enter deadline description"); }
        if (args.get("by") == null) { throw new DukeException("Please enter deadline date"); }

        Deadline ddl = new Deadline(args.get("primary"), args.get("by"));
        return new AddCommand(ddl);
    }

    private static Command parseEvent(String line) throws DukeException{
        Dictionary<String, String> args = getCommandArgs(line);

        if (args.get("primary") == null) { throw new DukeException("Please enter event description"); }
        if (args.get("at") == null) { throw new DukeException("Please enter event date"); }

        Event evt = new Event(args.get("primary"), args.get("at"));
        return new AddCommand(evt);
    }

    private static Command parseList(String line) {
        return new ListCommand();
    }

    private static Command parseDone(String line) throws DukeException{
        Dictionary<String, String> args = getCommandArgs(line);
        try {
            int index = Integer.parseInt(args.get("primary"));
            return new DoneCommand(index);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new DukeException("Please enter a valid index number");
        }
    }

    private static Command parseDeletion(String line) throws DukeException{
        Dictionary<String, String> args = getCommandArgs(line);
        try {
            int index = Integer.parseInt(args.get("primary"));
            return new DeleteCommand(index);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new DukeException("Please enter a valid index number");
        }
    }
}
