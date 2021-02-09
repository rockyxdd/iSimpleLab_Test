import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Task {

    private String id;
    private String caption;
    private String description;
    private int priority;
    private Date deadline;
    private String status;
    private Date completeDate;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCaption() {
        return caption;
    }
    public void setCaption(String caption) {
        this.caption = caption;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public Date getDeadline() {
        return deadline;
    }
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Date getCompleteDate() {
        return completeDate;
    }
    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public Task() {
        this.id = null;
        this.caption = null;
        this.description = null;
        this.priority = 0;
        this.deadline = new Date(0);
        this.status = "new";
        this.completeDate = new Date(0);
    }
    public Task(String newId, String newCaption, String newDescription, int newPriority, Date newDeadline, String newStatus, Date newCompleteDate) {
        this.id = newId;
        this.caption = newCaption;
        this.description = newDescription;
        this.priority = newPriority;
        this.deadline = newDeadline;
        this.status = newStatus;
        this.completeDate = newCompleteDate;
    }
    public void printTask() {
        System.out.println( "Идентификатор: " + this.id + "\n" +
                "Задача: " + this.caption + "\n" +
                "Описание: " + this.description + "\n" +
                "Приоритет: " + this.priority + "\n" +
                "Дедлайн: " + new SimpleDateFormat("yyyy-MM-dd").format(this.deadline) + "\n" +
                "Статус: " + this.status);
        if (this.status.equals("done"))
            System.out.println("Дата завершения: " + new SimpleDateFormat("yyyy-MM-dd").format(this.completeDate));
        System.out.println("\n");
    }
    public int readInt (String msg, String error) {
        boolean isInt = false;
        int num = -1;
        while (!isInt) {
            try{
                System.out.println(msg);
                Scanner in = new Scanner(System.in);
                num = in.nextInt();
                in.nextLine();
                isInt = true;
            } catch (InputMismatchException e) {
                System.out.println(error);
            }
        }
        return num;
    }
    public Date readDate(String msg, String error) {
        boolean isDate = false;
        Date date = new Date();
        while (!isDate) {
            try{
                System.out.println(msg);
                Scanner in = new Scanner(System.in);
                date = new SimpleDateFormat("yyyy-MM-dd").parse(in.nextLine());
                isDate = true;
            } catch (ParseException e) {
                System.out.println(error);
            }
        }
        return date;
    }
    public String readStatus (String msg, String error) {
        Scanner in = new Scanner(System.in);
        System.out.println(msg);
        String status = in.nextLine();
        while (!(status.equals("done") || status.equals("new") || status.equals("in progress"))) {
            System.out.println(error + "\n" + msg);
            status = in.nextLine();
        }
        return status;
    }

    public void editTask() {
        Scanner in = new Scanner(System.in);
        boolean isQuit = false;
        Commands cmd = new Commands();

        while (!isQuit) {
            switch (cmd.editTaskMenu()) {
                case 1:
                    System.out.println("Введите новый заголовок: ");
                    setCaption(in.nextLine());
                    break;
                case 2:
                    System.out.println("Введите новое описание: ");
                    setDescription(in.nextLine());
                    break;
                case 3:
                    System.out.println("Введите новый приоритет: ");
                    setPriority(readInt("Введите приоритет задачи: ", "Ошибка! Введите целочисленное значение!"));
                    break;
                case 4:
                    System.out.println("Введите новый дедлайн: ");
                    setDeadline(readDate("Введите дедлайн задачи: ", "Ошибка! Введите дату в формате yyyy-MM-dd"));
                    break;
                case 5:
                    isQuit = true;
                    break;
                default:
                    System.out.println("Ошибка! Введите число от 1 до 5.");
                    break;
            }
        }
    }
}
