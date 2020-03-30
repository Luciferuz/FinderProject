package Package;

public class Main {

    public static void main(String[] args) {
        new Launcher(args).launcher();

        boolean logicR = new Launcher().getLogicR();
        String directory = new Launcher().getDirectory();
        String filename = new Launcher().getFilename();

        System.out.println(new Finder(logicR, directory, filename).find());
    }
}
