public class CommandComplete extends Command{

    private String cmd;
    private int id;

    public String getCmd() {
        return cmd;
    }
    public void setId(int id) {
        this.id = id;
    }

    CommandComplete () {
        this.cmd = "complete";
    }

    @Override
    public void help() {
        System.out.println("Завершить задачу: complete <task_id>");
    }

    @Override
    public void execute(TaskList toDo) {
        toDo.completeTask(toDo.findId(this.id));
    }
}