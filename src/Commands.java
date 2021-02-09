import java.util.Scanner;

public class Commands extends Task {

    private String cmd;

    public void scanCommand() {
        System.out.println("User: ");
        Scanner in = new Scanner(System.in);
        this.cmd = in.nextLine();
    }

    public void helpList() {
        System.out.println("Вывод всех задач: list\n" +
                "Вывод новых задач: list -s new\n" +
                "Вывод выполненных задач: list -s done\n" +
                "Вывод задач в разработке: list -s in progress\n" +
                "Пометить задачу как выполненную: complete task_id\n" +
                "Добавить новую задачу: new\n" +
                "Редактировать задачу: edit task_id\n" +
                "Удалить задачу: remove task_id\n" +
                "Сохранить изменения в XML файл: save" +
                "Выход: exit");
    }

    public int editTaskMenu() {
        System.out.println("1) Изменить заголовок\n" +
                "2) Изменить описание\n" +
                "3) Изменить приоритет\n" +
                "4) Изменить дедлайн\n" +
                "5) Выход");
        return readInt("Выбор: ","Ошибка! Введите число от 1 до 5.");
    }

    public boolean quitBeforeSave (boolean saveNotDone) {
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

    public void menu(TaskList toDo){

        boolean isQuit = false;
        boolean saveNotDone = false;

        while (!isQuit) {
            scanCommand();
            String[] words = this.cmd.split("\s");
            if (words.length != 2) {
                switch (this.cmd) {
                    case "help":
                        helpList();
                        break;
                    case "list":
                        toDo.printAll();
                        break;
                    case "list -s new":
                        toDo.printStatus(words[2]);
                        break;
                    case "list -s done":
                        toDo.printStatus(words[2]);
                        break;
                    case "list -s in progress":
                        toDo.printStatus(words[2] + " " + words[3]);
                        break;
                    case "new":
                        toDo.inputTask();
                        saveNotDone = true;
                        break;
                    case "save":
                        WorkWithXML printer = new WorkWithXML();
                        printer.printXML(toDo);
                        saveNotDone = false;
                        break;
                    case "exit":
                        if (quitBeforeSave(saveNotDone)) {
                            isQuit = true;
                            break;
                        }
                        break;
                    default:
                        System.out.println("Ошибка: Неверно выбранный пункт!");
                        break;
                }
            } else switch (words[0]) {
                case "complete":
                    toDo.completeTask(words[1]);
                    saveNotDone = true;
                    break;
                case "remove":
                    toDo.removeTask(words[1]);
                    saveNotDone = true;
                    break;
                case "edit":
                    toDo.editTask(words[1]);
                    saveNotDone = true;
                    break;
                default:
                    System.out.println("Ошибка: Неверно выбранный пункт!");
                    break;
            }
        }
    }

}
