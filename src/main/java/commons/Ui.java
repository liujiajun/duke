package commons;

public class Ui {

    public static void showToUser(String... message) {
        for (String m : message) {
            System.out.println(m);
        }
    }

    public static void showError(String message) {
        showToUser(Message.getMessageError(message));
    }
}
