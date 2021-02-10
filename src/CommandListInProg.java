public class CommandListInProg extends Command {

    private String cmd;

    public String getCmd() {
        return cmd;
    }
    CommandListInProg () {
        this.cmd = "list -s in progress";
    }

    @Override
    public void help() {
        System.out.println("Вывод задач в разработке: list -s in progress");
    }

    @Override
    public void execute(TaskList toDo) {
        toDo.printStatus("in progress");
    }
}