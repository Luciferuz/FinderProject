package Package;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Launcher {

    private static boolean logicR = false;
    private static String directory;
    private static String filename;
    private static String[] args;

    public Launcher(String[] arguments) {
        args = arguments;
    }

    public Launcher() {

    }

    public void launcher() {
        ArrayList<String> userCommand = new ArrayList<>(Arrays.asList(args));
        String userCommandString = Arrays.toString(args).replaceAll(",", "").replaceAll("\\[", "").replaceAll("]", "");
        System.out.println(userCommand);
        System.out.println(userCommand.size());
        System.out.println(userCommandString);
        if (!Pattern.matches("find(\\s-r)?\\s(-d)\\s/([A-z]+/)+(\\s-r)?\\s(.)+", userCommandString)) throw new IllegalArgumentException();
        if (userCommand.size() != 4 && userCommand.size() != 5) throw new IllegalArgumentException();

        for (int index = 1; index < userCommand.size(); index++) {
            if (userCommand.get(index).equals("-r")) {
                logicR = true;
                System.out.println("yes r true");
                continue;
            }
            if (userCommand.get(index).equals("-d")) {
                directory = userCommand.get(index + 1);
                index++;
                continue;
            }
            filename = userCommand.get(index);
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
