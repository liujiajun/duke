import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static final String BEGIN_DIVIDER = "----------------------------------------------";
    public static final String END_DIVIDER = BEGIN_DIVIDER + System.lineSeparator();
    public static final String LINE_PREFIX = "     ";

    public static final String COMMAND_LIST = "list";
    public static final String COMMAND_BYE = "bye";
    public static final String COMMAND_DONE = "done";
    public static final String COMMAND_TODO = "todo";
    public static final String COMMAND_DEADLINE = "deadline";
    public static final String COMMAND_EVENT = "event";

    public static final String MESSAGE_ERROR = "\u2639 OOPS!!! %s";
    public static final String MESSAGE_HELLO = "Hello! I'm Duke";
    public static final String MESSAGE_HELLO_2 = "What can I do for you?";
    public static final String MESSAGE_ADDED = "Got it. I've added this task:\n  %s";
    public static final String MESSAGE_LIST_ITEM = "%1$d. %2$s %3$s";
    public static final String MESSAGE_BYE = "Bye. Hope to see you again soon!";
    public static final String MESSAGE_FINISH_DONE = "Nice! I've marked this task as done:\n  ✅ %s";
    public static final String MESSAGE_DELETION = "Noted. I've removed this task: \n" +
            " %s \n" +
            "  Now you have %d tasks in the list.";
    public static final String MESSAGE_SEARCH = "Here are the matching tasks in your list:";

    public static final String MESSAGE_UNKNOWN_COMMAND = "This is an unknown command.";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        showToUser(getWelcome());

        while (SCANNER.hasNextLine()) {
            String line = SCANNER.nextLine();
            if (line.equals("bye")) {
                showToUser(BEGIN_DIVIDER, "Bye. Hope to see you again soon!", END_DIVIDER);
                System.exit(0);
            }
            showToUser(BEGIN_DIVIDER, line, END_DIVIDER);

        }
    }

    public static String getWelcome() {
        return buildMessage(BEGIN_DIVIDER, MESSAGE_HELLO, MESSAGE_HELLO_2, END_DIVIDER);
    }

    private static void showToUser(String... message) {
        for (String m : message) {
            System.out.println(m);
        }
    }

    private static String buildMessage(String... message) {
        StringBuilder res = new StringBuilder();
        for (String m : message) {
            res.append(m);
            res.append("\n");
        }
        return res.toString().strip();
    }
}
