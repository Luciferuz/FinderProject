package Package;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Launcher {

    private boolean logicR = false;
    private String directory = System.getProperty("user.dir"); //если -d нет, то работа в текущем каталоге
    private String filename;
    private String[] args;

    public Launcher(String[] arguments) {
        args = arguments;
        launcher(); //из конструктора вызвал метод лаунчер
    }


    private void launcher() {
        List<String> userCommand = new ArrayList<>(Arrays.asList(args));
        //System.out.println(userCommand);
        //System.out.println(userCommand.size());
        if (userCommand.size() > 5 || userCommand.size() < 2) throw new IllegalArgumentException();

        for (int index = 1; index < userCommand.size() - 1; index++) {
            //System.out.println(userCommand.get(index));
            if (!userCommand.get(index).equals("-r") && !userCommand.get(index).equals("-d")) throw new IllegalArgumentException();
            if (userCommand.get(index).equals("-r")) {
                logicR = true;
                continue;
            }
            if (userCommand.get(index).equals("-d")) {
                directory = userCommand.get(index + 1);
                index++;
                continue;
            }
        }
        filename = userCommand.get(userCommand.size() - 1);
    }

    public boolean getLogicR() {
        return logicR;
    }

    public String getDirectory() {
        return directory;
    }

    public String getFilename() {
        return filename;
    }
}
