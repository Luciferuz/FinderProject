package Package;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m"; //для цвета в консоли
    public static boolean logicR;
    public static String directory;
    public static String filename;

    public static void main(String[] args) {
        System.out.println("Введите команду по образцу " + ANSI_YELLOW + "find [-r] [-d directory] filename.txt" + ANSI_RESET);
        Scanner scanner = new Scanner(System.in);
        String userCommand = scanner.nextLine();
        if (!Pattern.matches("find(\\s-r)?\\s(-d)\\s([A-z](/)?)+\\s(.)+", userCommand)) System.out.println("Incorrect input");
        if (Pattern.matches("find(\\s-r)?\\s(-d)\\s([A-z](/)?)+\\s(.)+", userCommand)) logicR = true;
    }
}
