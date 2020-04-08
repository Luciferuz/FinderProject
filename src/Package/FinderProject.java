package Package;
import java.io.File;
import java.util.List;

public class FinderProject {

    public static void main(String[] args) {

        try {
            if (args.length > 4 || args.length < 1) throw new IllegalArgumentException("Некорректная длина массива");
            for (int index = 0; index < args.length - 1; index++) {
                if (args[index].equals("-r") || args[index].equals("-d")) {
                    switch (args[index]) {
                        case "-r": {
                            if (args.length == 2) throw new IllegalArgumentException("Некорректная длина массива");
                            break;
                        }
                        case "-d": {
                            index++;
                            break;
                        }
                    }
                } else throw new IllegalArgumentException("Некорректный аргумент");
            }
        } catch (IllegalArgumentException e) {
            System.exit(1);
            System.out.println(e.getMessage());
        }

        Launcher start = new Launcher(args);

        boolean logicR = start.getLogicR();
        String directory = start.getDirectory();
        String filename = start.getFilename();

        List<File> list = new Finder(logicR, directory, filename).find();
        for (File item : list) System.out.println(item);
    }
}