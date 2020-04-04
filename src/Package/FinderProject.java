package Package;

public class FinderProject {

    public static void main(String[] args) {
        Launcher start = new Launcher(args);

        boolean logicR = start.getLogicR();
        String directory = start.getDirectory();
        String filename = start.getFilename();

        System.out.println(new Finder(logicR, directory, filename).find());
    }
}
