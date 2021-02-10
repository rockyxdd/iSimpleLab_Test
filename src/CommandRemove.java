public class CommandRemove extends Command{

    private String cmd;
    private int id;

    public String getCmd() {
        return cmd;
    }
    public void setId(int id) {
        this.id = id;
    }
    CommandRemove () {
        this.cmd = "remove";
    }

    @Override
    public void help() {
        System.out.println("Удалить задачу: remove <task_id>");
    }

    @Override
    public void execute(TaskList toDo) {
        toDo.removeTask(toDo.findId(this.id));
    }
}