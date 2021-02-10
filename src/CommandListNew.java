public class CommandListNew extends Command {

    private String cmd;

    public String getCmd() {
        return cmd;
    }
    CommandListNew () {
        this.cmd = "list -s new";
    }

    @Override
    public void help() {
        System.out.println("Вывод всех новых задач: list -s new");
    }

    @Override
    public void execute(TaskList toDo) {
        toDo.printStatus("new");
    }
}