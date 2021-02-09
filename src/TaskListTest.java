import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


class TaskListTest {

    TaskListTest() {
    }
    @Test
    void uniqueId() throws ParseException {
        Task task1 = new Task("1","1","1",1, new SimpleDateFormat("yyyy-MM-dd").parse("1111-11-11"),"done",new SimpleDateFormat("yyyy-MM-dd").parse("1111-11-11"));
        Task task2 = new Task("2","2","2",2, new SimpleDateFormat("yyyy-MM-dd").parse("2222-11-22"),"new",new Date(0));
        TaskList test = new TaskList();
        test.addTask(task1);
        test.addTask(task2);
        String idToFail ="1";
        String idToPass = "3";

        Assertions.assertEquals(false,test.uniqueId(idToFail));
        Assertions.assertEquals(true, test.uniqueId(idToPass));
    }
}