import java.util.*;

public class Duke {
    private static final String BEGIN_DIVIDER = "____________________________________________________________";
    private static final String END_DIVIDER = BEGIN_DIVIDER + System.lineSeparator();
    private static final String LINE_PREFIX = "     ";

    private static final String COMMAND_LIST = "list";
    private static final String COMMAND_BYE = "bye";
    private static final String COMMAND_DONE = "done";

    private static final String MESSAGE_HELLO = "Hello! I'm Duke";
    private static final String MESSAGE_HELLO_2 = "What can I do for you?";
    private static final String MESSAGE_ADDED = "added: %1$s";
    private static final String MESSAGE_LIST_ITEM = "%1$d. %2$s %3$s";
    private static final String MESSAGE_BYE = "Bye. Hope to see you again soon!";
    private static final String MESSAGE_FINISH_DONE = "Nice! I've marked this task as done: ";
    private static final String MESSAGE_DONE_ITEM = "✅ %1$s";

    private static final Scanner SCAN = new Scanner(System.in);

    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        showToUser(BEGIN_DIVIDER, MESSAGE_HELLO, MESSAGE_HELLO_2, END_DIVIDER);

        while(SCAN.hasNextLine()) {
            String userCommand = SCAN.nextLine();
            executeCommand(userCommand);
        }
    }

    private static void executeList() {
        showToUser(BEGIN_DIVIDER);
        int i = 0;
        for (Task s : tasks) {
            i++;
            showToUser(String.format(MESSAGE_LIST_ITEM, i, s.getStatusIcon(), s.description));
        }
        showToUser(END_DIVIDER);
    }

    private static void executeAdd(String task) {
        tasks.add(new Task(task));
        showToUser(BEGIN_DIVIDER, String.format(MESSAGE_ADDED, task), END_DIVIDER);
    }

    private static void setDone(String line) {
        String arg = line.strip().split(" ")[1];
        int index = Integer.parseInt(arg) - 1;
        tasks.get(index).setDone(true);
        showToUser(BEGIN_DIVIDER, MESSAGE_FINISH_DONE, String.format(MESSAGE_DONE_ITEM, tasks.get(index).description), END_DIVIDER);
    }

    private static void executeQuit() {
        showToUser(BEGIN_DIVIDER, MESSAGE_BYE, END_DIVIDER);
        System.exit(0);
    }

    private static String getCommand(String line) {
        return line.strip().split(" ")[0];
    }
    private static void executeCommand(String line) {
        String command = getCommand(line);
        switch (command) {
            case COMMAND_LIST:
                executeList();
                break;
//            case COMMAND_DONE:
//                setDone(line);
//                break;
            case COMMAND_BYE:
                executeQuit();
                break;
            default:
                executeAdd(line);
        }
    }
    private static void showToUser(String... message) {
        for (String m : message) {
            System.out.println(LINE_PREFIX + m);
        }
    }
}
