package Package;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Launcher {

    private static boolean logicR = false;
    private static String directory;
    private static String filename;


    public void launcher() {
        System.out.println("Введите команду по образцу find [-r] [-d directory] filename.txt");
        Scanner scanner = new Scanner(System.in);
        String userCommand = scanner.nextLine();

        if (!Pattern.matches("find(\\s-r)?\\s(-d)\\s/([A-z]+/)+(\\s-r)?\\s(.)+", userCommand)) throw new IllegalArgumentException();

        Pattern pattern = Pattern.compile("\\s"); //разбивка по пробелу
        String[] parts = pattern.split(userCommand);
        if (parts.length != 4 && parts.length != 5) throw new IllegalArgumentException();

        for (int index = 1; index < parts.length; index++) {
            if (parts[index].equals("-r")) {
                logicR = true;
                continue;
            }
            if (parts[index].equals("-d")) {
                directory = parts[index + 1];
                index++;
                continue;
            }
            filename = parts[index];
        }

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
