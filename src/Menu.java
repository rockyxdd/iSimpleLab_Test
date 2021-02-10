import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private Scanner in = new Scanner(System.in);
    private List<Command> allCommands = new ArrayList<>();

    Menu () {
        this.allCommands.add(new CommandList());
        this.allCommands.add(new CommandListDone());
        this.allCommands.add(new CommandListInProg());
        this.allCommands.add(new CommandListNew());
        this.allCommands.add(new CommandNew());
        this.allCommands.add(new CommandComplete());
        this.allCommands.add(new CommandEdit());
        this.allCommands.add(new CommandRemove());
        this.allCommands.add(new CommandSave());
    }

    public void help () {
        for (Command command: this.allCommands) {
            command.help();
        }
    }
    public boolean executeCommand (String cmd, TaskList toDo) {
        boolean wasExecuted = false;
        String[] words = cmd.split("\s");
        if (words.length != 2) {
            for (Command command : this.allCommands) {
                if (command.getCmd().equals(cmd)) {
                    command.execute(toDo);
                    wasExecuted = true;
                }
            }
        } else
            for (Command command : this.allCommands) {
                if (command.getCmd().equals(words[0])) {
                    command.setId(Integer.parseInt(words[1]));
                    command.execute(toDo);
                    wasExecuted = true;
                }
            }
        return wasExecuted;
    }
    public void runMenu (TaskList toDo) {
        System.out.println("User: ");
        String cmd = in.nextLine();
        while (!cmd.equals("exit")) {
            if (!executeCommand(cmd, toDo))
                System.out.println("Ошибка ввода! Данной команды не существует!");
            System.out.println("User: ");
            cmd = in.nextLine();
        }
    }
}
