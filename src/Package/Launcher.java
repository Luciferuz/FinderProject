package Package;

public class Launcher {

    private boolean logicR = false;
    private String directory = "."; //если -d нет, то работа в текущем каталоге
    private String filename;
    private String[] args;

    public Launcher(String[] arguments) {
        args = arguments; // = userCommand
        launcher(); //из конструктора вызвал метод лаунчер
    }

    private void launcher() {
        if (args.length > 4 || args.length < 1) throw new IllegalArgumentException();

        for (int index = 0; index < args.length - 1; index++) {
            if (!args[index].equals("-r") && !args[index].equals("-d")) throw new IllegalArgumentException();
            else if (args[index].equals("-r")) {
                logicR = true;
            } else if (args[index].equals("-d")) {
                directory = args[index + 1];
                index++;
            }
        }
        filename = args[args.length - 1];

        if (!logicR && args.length == 2) throw new IllegalArgumentException();
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