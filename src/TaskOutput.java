import java.util.Scanner;

public class TaskOutput extends ImplementTask {

    public int editTaskMenu() {
        System.out.println("1) Изменить заголовок\n" +
                "2) Изменить описание\n" +
                "3) Изменить приоритет\n" +
                "4) Изменить дедлайн\n" +
                "5) Выход");
        return readInt("Выбор: ", "Ошибка! Введите число от 1 до 5.");
    }
    public int editTaskOutput () {
        TaskOutput cmd = new TaskOutput();
        while (true) {
            switch (cmd.editTaskMenu()) {
                case 1:
                    System.out.println("Введите новый заголовок: ");
                    return 1;
                case 2:
                    System.out.println("Введите новое описание: ");
                    return 2;
                case 3:
                    System.out.println("Введите новый приоритет: ");
                    return 3;
                case 4:
                    System.out.println("Введите новый дедлайн: ");
                    return 4;
                case 5:
                    return 5;
                default:
                    System.out.println("Ошибка! Введите число от 1 до 5.");
                    break;
            }
        }
    }
}

