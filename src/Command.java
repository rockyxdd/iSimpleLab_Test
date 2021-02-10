public abstract class Command {

    private String cmd;
    private int id;

    public String getCmd() {
        return cmd;
    }
    public void setId(int id) {
        this.id = id;
    }

    public abstract void help();
    public abstract void execute(TaskList toDo);

}
