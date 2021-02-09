import java.util.*;

public class TaskList extends Task {

    private List<Task> toDoList = new ArrayList<>();

    public List<Task> getToDoList() {
        return toDoList;
    }
    public void addTask(Task t) {
        this.toDoList.add(t);
    }

    public void printAll () {
        for (Task task : this.toDoList)
            task.printTask();
    }
    public void printStatus (String status) {
        for (Task task : this.toDoList) {
            if (task.getStatus().equals(status))
                task.printTask();
        }
    }

    public boolean uniqueId (String taskId) {
        for (Task task: this.toDoList) {
            if (task.getId().equals(taskId))
                return false;
        }
        return true;
    }
    public String readId (String msg, String error) {
        System.out.println(msg);
        Scanner in = new Scanner(System.in);
        String isUnique = in.nextLine();

        if (!uniqueId(isUnique)) {
            System.out.println(error);
            isUnique = readId(msg, error);
        }
        return isUnique;
    }
    public int findId (String taskId) {
        for (int i = 0; i < this.toDoList.size(); ++i) {
            if (this.toDoList.get(i).getId().equals(taskId))
                return i;
        }
        System.out.println("Отсутствует задача с заданным идентификатором!\n" +
                "Введите идентификатор: ");
        Scanner in = new Scanner(System.in);
        String newTaskId = in.nextLine();
        return findId(newTaskId);
    }
    public void inputTask () {
        Scanner in = new Scanner(System.in);
        Task newTask = new Task();

        newTask.setId(readId("Введите идентификатор", "Ошибка! Идентификатор не является уникальным!"));
        System.out.println("Введите заголовок задачи: ");
        newTask.setCaption(in.nextLine());
        System.out.println("Введите описание задачи: ");
        newTask.setDescription(in.nextLine());
        newTask.setPriority(readInt("Введите приоритет задачи: ","Ошибка! Введите целочисленное значение!"));
        newTask.setDeadline(readDate("Введите дедлайн задачи: ", "Ошибка! Введите дату в формате yyyy-MM-dd"));
        newTask.setStatus(readStatus("Введите статус задачи: ","Ошибка! Задача может находится в статусах: done, new, in progress"));
        if (newTask.getStatus().equals("done"))
            newTask.setCompleteDate(readDate("Введите дату завершения задачи: ", "Ошибка! Введите дату в формате yyyy-MM-dd"));

        addTask(newTask);
    }
    public void removeTask (String taskId) {
        this.toDoList.remove(findId(taskId));
    }
    public void completeTask (String taskId) {
        int id = findId(taskId);
        this.toDoList.get(id).setStatus("done");
        this.toDoList.get(id).setCompleteDate(new Date());
    }
    public void editTask (String taskId) {
        this.toDoList.get(findId(taskId)).editTask();
    }
}
