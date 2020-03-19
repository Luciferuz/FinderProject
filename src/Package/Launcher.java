package Package;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Launcher {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m"; //для цвета в консоли
    private static boolean logicR = false;
    private static String directory;
    private static String filename;

    public void launcher() {
        System.out.println("Введите команду по образцу " + ANSI_YELLOW + "find [-r] [-d directory] filename.txt" + ANSI_RESET);
        Scanner scanner = new Scanner(System.in);
        String userCommand = scanner.nextLine();
        if (!Pattern.matches("find(\\s-r)?\\s(-d)\\s([A-z](/)?)+\\s(.)+", userCommand)) System.out.println("Incorrect input");
        Pattern pattern = Pattern.compile("\\s"); //разбивка по пробелу
        String[] parts = pattern.split(userCommand);
        if (parts[1].equals("-r")) logicR = true;
        directory = parts[3];
        filename = parts[4];
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
