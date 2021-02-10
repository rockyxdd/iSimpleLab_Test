
public class Main {

    public static void main(String[] args) {
        String uri = "ToDoList.xml";
        WorkWithFile toDoList = new WorkWithXML();
        TaskList toDo = toDoList.read(uri);
        Menu start = new Menu();
        start.runMenu(toDo);
    }
}
