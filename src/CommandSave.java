public class CommandSave extends Command {

    private String cmd;

    public String getCmd() {
        return cmd;
    }
    CommandSave () {
        this.cmd = "save";
    }

    @Override
    public void help() {
        System.out.println("Сохранить изменения в файл: save");
    }

    @Override
    public void execute(TaskList toDo) {
        WorkWithFile save = new WorkWithXML();
        save.print(toDo,"ToDoList.xml");
    }
}
