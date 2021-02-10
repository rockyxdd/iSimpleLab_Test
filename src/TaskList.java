import java.util.*;

public class TaskList extends ImplementTask {

    private List<Task> toDoList = new ArrayList<>();

    public List<Task> getToDoList() {
        return toDoList;
    }
    public void addTask(Task t) {
        this.toDoList.add(t);
    }

    public void printAll () {
        for (Task task : this.toDoList)
            printTask(task);
    }
    public void printStatus (String status) {
        for (Task task : this.toDoList) {
            if (task.getStatus().equals(status))
                printTask(task);
        }
    }

    public boolean uniqueId (int taskId) {
        for (Task task : this.toDoList) {
            if (task.getId() == taskId)
                return false;
        }
        return true;
    }

    public int readId (String msg, String error1, String error2) {

        int isUnique = readInt(msg, error1);

        if (!uniqueId(isUnique)) {
            System.out.println(error2);
            isUnique = readId(msg, error1, error2);
        }
        return isUnique;
    }
    public int findId (int taskId) {
        for (int i = 0; i < this.toDoList.size(); ++i) {
            if (this.toDoList.get(i).getId() == taskId)
                return i;
        }
        System.out.println("Отсутствует задача с заданным идентификатором!");
        int newTaskId = readInt("Введите идентификатор задачи: ", "Ошибка! Введите целочисленное значение!" );
        return findId(newTaskId);
    }

    public Task inputTask () {
        Scanner in = new Scanner(System.in);
        Task newTask = new Task();

        newTask.setId(readId("Введите идентификатор задачи: ", "Ошибка! Введите целочисленное значение!","Ошибка! Идентификатор не является уникальным!"));
        System.out.println("Введите заголовок задачи: ");
        newTask.setCaption(in.nextLine());
        System.out.println("Введите описание задачи: ");
        newTask.setDescription(in.nextLine());
        newTask.setPriority(readInt("Введите приоритет задачи: ","Ошибка! Введите целочисленное значение!"));
        newTask.setDeadline(readDate("Введите дедлайн задачи: ", "Ошибка! Введите дату в формате yyyy-MM-dd"));
        newTask.setStatus(readStatus("Введите статус задачи: ","Ошибка! Задача может находится в статусах: done, new, in progress"));
        if (newTask.getStatus().equals("done"))
            newTask.setCompleteDate(readDate("Введите дату завершения задачи: ", "Ошибка! Введите дату в формате yyyy-MM-dd"));

        return newTask;
    }
    public void removeTask (int taskId) {
        this.toDoList.remove(taskId);
    }
    public void completeTask (int taskId) {
        this.toDoList.get(taskId).setStatus("done");
        this.toDoList.get(taskId).setCompleteDate(new Date());
    }
    public void editTask (int taskId) {
        this.toDoList.get(taskId).setTask(editTask(this.toDoList.get(taskId)));
    }
}
