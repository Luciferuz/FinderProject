package Package;
import java.io.File;
import java.util.Objects;

public class Finder {
    private boolean logicR;
    private String directory;
    private String filename;
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_WHITE = "\u001B[37m";

    public Finder(boolean logicR, String directory, String filename) {
        this.logicR = logicR;
        this.directory = directory;
        this.filename = filename;
    }

    public void find() {
        System.out.println(ANSI_WHITE + "------------------");
        System.out.println(ANSI_RED + "Найденные файлы: ");
        if (logicR) findWithR(directory);
        else findNoR();
        System.out.println(ANSI_WHITE + "------------------");
    }

    public void findNoR() {
        File dir = new File(directory);
        for(File item : dir.listFiles()){
            if (filename.equals(item.getName())) System.out.println(ANSI_BLUE + item.getName());
        }
    }

    public void findWithR(String directory) {
        File dir = new File(directory);
        for(File item : dir.listFiles()){
            if (item.isDirectory()) {
                findWithR(item.getAbsolutePath()); //рекурсия если папка
            }
            if (filename.equals(item.getName())) System.out.println(ANSI_BLUE + item.getName());
        }
    }


}

//command for test       find -r -d /Users/Admin/files/forTestJava/ picture.png
