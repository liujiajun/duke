import logic.Duke;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DukeTest {

    private Duke duke = new Duke();

    public DukeTest() {
    }

    @Test
    public void addTask_todo_addSuccess() {
        String input = "todo 123";
        String expected = "----------------------------------------------\n" +
                "Got it. I've added this task:\n" +
                "  \uD83D\uDCCB ❌ 123\n" +
                "Now you have 1 tasks in the list.\n" +
                "----------------------------------------------\n";
        assertEquals(expected, duke.getResponse(input));

    }

    @Test
    public void addTask_deadline_addSuccess() {
        String input = "deadline 456 /by 10-10-1999 1800";
        String expected = "----------------------------------------------\n" +
                "Got it. I've added this task:\n" +
                "  ⏰ ❌ 456 (by: 10-10-1999 1800)\n" +
                "Now you have 2 tasks in the list.\n" +
                "----------------------------------------------\n";
        assertEquals(expected, duke.getResponse(input));

    }
}
