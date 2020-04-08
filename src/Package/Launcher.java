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

        for (int index = 0; index < args.length - 1; index++) {
            if (args[index].equals("-r") || args[index].equals("-d")) {
                switch (args[index]) {
                    case "-r": {
                        logicR = true;
                        break;
                    }
                    case "-d": {
                        directory = args[index + 1];
                        index++;
                        break;
                    }
                }
            } else throw new IllegalArgumentException("Некорректный аргумент");
        }
        filename = args[args.length - 1];

        if (!logicR && args.length == 2) throw new IllegalArgumentException("Некорректная длина массива");
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