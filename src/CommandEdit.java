public class CommandEdit extends Command{

    private String cmd;
    private int id;

    public String getCmd() {
        return cmd;
    }
    public void setId(int id) {
        this.id = id;
    }

    CommandEdit () {
        this.cmd = "edit";
    }

    @Override
    public void help() {
        System.out.println("Редактировать задачу: edit <task_id>");
    }

    @Override
    public void execute(TaskList toDo) {
        toDo.editTask(toDo.findId(this.id));
    }
}