public class CommandList extends Command {

    private String cmd;

    public String getCmd() {
        return cmd;
    }

    CommandList () {
        this.cmd = "list";
    }

    @Override
    public void help() {
        System.out.println("Вывод всех задач: list");
    }

    @Override
    public void execute(TaskList toDo) {
        toDo.printAll();
    }
}
