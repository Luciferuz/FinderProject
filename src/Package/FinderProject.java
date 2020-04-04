package Package;
import java.io.File;
import java.util.List;

public class FinderProject {

    public static void main(String[] args) {
        Launcher start = new Launcher(args);

        boolean logicR = start.getLogicR();
        String directory = start.getDirectory();
        String filename = start.getFilename();

        List<File> list = new Finder(logicR, directory, filename).find();
        for (File item : list) {
            System.out.println(item);
        }
    }
}