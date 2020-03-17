package Package;
import java.io.File;
import java.util.Objects;

public class Finder {
    private boolean logicR;
    private String directory;
    private String filename;

    public Finder(boolean logicR, String directory, String filename) {
        this.logicR = logicR;
        this.directory = directory;
        this.filename = filename;
    }

    public void find() {
        File dir = new File(directory);
        for(File item : Objects.requireNonNull(dir.listFiles())){
            System.out.println(item.getName());
        }
    }

}

//find -r -d Users/Admin/ files
