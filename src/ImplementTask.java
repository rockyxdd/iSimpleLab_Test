import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ImplementTask {
    public void printTask(Task task) {
        System.out.println( "Идентификатор: " + task.getId() + "\n" +
                "Задача: " + task.getCaption() + "\n" +
                "Описание: " + task.getDescription() + "\n" +
                "Приоритет: " + task.getDescription() + "\n" +
                "Дедлайн: " + new SimpleDateFormat("yyyy-MM-dd").format(task.getDeadline()) + "\n" +
                "Статус: " + task.getStatus());
        if (task.getStatus().equals("done"))
            System.out.println("Дата завершения: " + new SimpleDateFormat("yyyy-MM-dd").format(task.getCompleteDate()));
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
    public boolean checkStatus (String status) {
        return !(status.equals("done") || status.equals("new") || status.equals("in progress"));
    }
    public String readStatus (String msg, String error) {
        Scanner in = new Scanner(System.in);
        System.out.println(msg);
        String status = in.nextLine();
        while (checkStatus(status)) {
            System.out.println(error + "\n" + msg);
            status = in.nextLine();
        }
        return status;
    }
    public Task editTask(Task task) {
        Scanner in = new Scanner(System.in);
        boolean isQuit = false;
        Commands cmd = new Commands();
        while (!isQuit) {
            switch (cmd.editTaskMenu()) {
                case 1:
                    System.out.println("Введите новый заголовок: ");
                    task.setCaption(in.nextLine());
                    break;
                case 2:
                    System.out.println("Введите новое описание: ");
                    task.setDescription(in.nextLine());
                    break;
                case 3:
                    System.out.println("Введите новый приоритет: ");
                    task.setPriority(readInt("Введите приоритет задачи: ", "Ошибка! Введите целочисленное значение!"));
                    break;
                case 4:
                    System.out.println("Введите новый дедлайн: ");
                    task.setDeadline(readDate("Введите дедлайн задачи: ", "Ошибка! Введите дату в формате yyyy-MM-dd"));
                    break;
                case 5:
                    isQuit = true;
                    break;
                default:
                    System.out.println("Ошибка! Введите число от 1 до 5.");
                    break;
            }
        }
        return task;
    }
}
