import java.util.Scanner;

public class Commands extends ImplementTask {

    public int editTaskMenu() {
        System.out.println("1) Изменить заголовок\n" +
                "2) Изменить описание\n" +
                "3) Изменить приоритет\n" +
                "4) Изменить дедлайн\n" +
                "5) Выход");
        return readInt("Выбор: ", "Ошибка! Введите число от 1 до 5.");
    }

    public boolean quitBeforeSave(boolean saveNotDone) {
        if (saveNotDone) {
            System.out.println("Вы хотите выйти, не сохранив изменения в файл?\n" +
                    "Введите <yes> или <no>\n" +
                    "Выбор: ");
            Scanner in = new Scanner(System.in);
            String choice = in.nextLine();
            while (!(choice.equals("yes") || choice.equals("no"))) {
                System.out.println("Ошибка! Введите <yes> или <no>\n" +
                        "Выбор: ");
                choice = in.nextLine();
            }
            return choice.equals("yes");
        }
        return true;
    }
}

