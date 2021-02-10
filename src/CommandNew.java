public class CommandNew extends Command {

    private String cmd;

    public String getCmd() {
        return cmd;
    }
    CommandNew () {
        this.cmd = "new";
    }

    @Override
    public void help() {
        System.out.println("Добавление новой задачи: new");
    }

    @Override
    public void execute(TaskList toDo) {
        toDo.addTask(toDo.inputTask());
    }
}
