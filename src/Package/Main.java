package Package;

public class Main {

    public static void main(String[] args) {
        new Launcher().launcher();
        boolean logicR = new Launcher().getLogicR();
        String directory = new Launcher().getDirectory();
        String filename = new Launcher().getFilename();

        new Finder(logicR, directory, filename).find();
    }
}
