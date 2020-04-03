package Package;
import java.io.File;
import java.util.ArrayList;

public class Finder {
    private boolean logicR;
    private String directory;
    private String filename;
    private ArrayList<File> listOfFiles = new ArrayList<>();

    public Finder(boolean logicR, String directory, String filename) {
        this.logicR = logicR;
        this.directory = directory;
        this.filename = filename;
    }

    public ArrayList<File> find() {
        if (logicR) findWithR(new File(directory));
        else findNoR();
        return listOfFiles;
    }

    private void findNoR() {
        File dir = new File(directory);
        for(File item : dir.listFiles()){
            if (filename.equals(item.getName())) listOfFiles.add(item);
        }
    }

    private void findWithR(File directory) {
        for(File item : directory.listFiles()){
            if (item.isDirectory()) {
                findWithR(item); //рекурсия если папка
            }
            if (filename.equals(item.getName())) listOfFiles.add(item);
        }
    }

}

//command for test        Java src/Package/FinderProject.java find -r -d /Users/Admin/files/forTestJava/ picture.png

