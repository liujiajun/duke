package commons;

import task.*;

import java.util.*;

public class Message {
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
    public static final String MESSAGE_ADDED = "Got it. I've added this task:\n  %s\n" +
            "Now you have %d tasks in the list.";
    public static final String MESSAGE_LIST_ITEM = "%1$d. %2$s %3$s";
    public static final String MESSAGE_BYE = "Bye. Hope to see you again soon!";
    public static final String MESSAGE_FINISH_DONE = "Nice! I've marked this task as done:\n  ✅ %s";
    public static final String MESSAGE_DELETION = "Noted. I've removed this task: \n" +
            " %s \n" +
            "Now you have %d tasks in the list.";
    public static final String MESSAGE_SEARCH = "Here are the matching tasks in your list:";

    public static final String MESSAGE_UNKNOWN_COMMAND = "This is an unknown command.";
    public static String getMessageError(String message) {
        return buildMessage(BEGIN_DIVIDER, String.format(MESSAGE_ERROR, message), END_DIVIDER);
    }

    public static String getWelcome() {
        return buildMessage(BEGIN_DIVIDER, MESSAGE_HELLO, MESSAGE_HELLO_2, END_DIVIDER);
    }

    public static String getAddition(Task t, ArrayList<Task> tasks) {
        return buildMessage(BEGIN_DIVIDER, String.format(MESSAGE_ADDED, t, tasks.size()), END_DIVIDER);
    }

    public static String getDeletion(Task t, ArrayList<Task> tasks) {
        return buildMessage(BEGIN_DIVIDER, String.format(MESSAGE_DELETION,
                t.toString(),
                tasks.size() - 1));
    }
    public static String getList(ArrayList<Task> tasks) {
        StringBuilder message = new StringBuilder();
        message.append(BEGIN_DIVIDER + "\n");
        int i = 0;
        for (Task s : tasks) {
            i++;
            message.append(String.format("%d. %s", i, s.toString()));
            message.append("\n");
        }
        message.append(END_DIVIDER);
        return message.toString();
    }

    public static String getSearch(ArrayList<Task> tasks) {
        StringBuilder message = new StringBuilder();
        message.append(BEGIN_DIVIDER + "\n");
        message.append(MESSAGE_SEARCH + "\n");
        int i = 0;
        for (Task s : tasks) {
            i++;
            message.append(String.format("  %d. %s", i, s.toString()));
            message.append("\n");
        }
        message.append(END_DIVIDER);
        return message.toString();
    }
    public static String getDone(Task task) {
        return buildMessage(BEGIN_DIVIDER,
                String.format(MESSAGE_FINISH_DONE, task.getDescription()),
                END_DIVIDER);
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
