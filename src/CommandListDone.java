public class CommandListDone extends Command {

    private String cmd;

    public String getCmd() {
        return cmd;
    }
    CommandListDone () {
        this.cmd = "list -s done";
    }

    @Override
    public void help() {
        System.out.println("Вывод всех выполненных задач: list -s done");
    }

    @Override
    public void execute(TaskList toDo) {
        toDo.printStatus("done");
    }
}