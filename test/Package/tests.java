package Package;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;


class tests {

    @Test
    void launcher() throws IllegalArgumentException {
        Launcher launch1 = new Launcher(new String[]{"finddd", "-d", "/Users/Admin/files/forTestJava/", "picture.png", "-r"}); //find с ошибкой
        Launcher launch2 = new Launcher(new String[]{"find", "-d", "-r", "/Users/Admin/files/forTestJava/", "picture.png", "-r"}); //вообще все неправильно
        Launcher launch3 = new Launcher(new String[]{"find", "-r", "/Users/Admin/files/forTestJava/", "picture.png"}); //нет -d
        Launcher launch4 = new Launcher(new String[]{"find", "-r", "-d", "/Users/Admin/files/forTestJava/"}); //нет файла
        Launcher launch5 = new Launcher(new String[]{"find", "-d", "/Users/Admin/files/forTestJava/", "-r", "picture.png", "picture.png", "picture.png", "picture.png"}); //слишком много parts в строке

        assertThrows(IllegalArgumentException.class, launch1::launcher);
        assertThrows(IllegalArgumentException.class, launch2::launcher);
        assertThrows(IllegalArgumentException.class, launch3::launcher);
        assertThrows(IllegalArgumentException.class, launch4::launcher);
        assertThrows(IllegalArgumentException.class, launch5::launcher);
    }

    @Test
    void getLogicR() {
        Launcher launch1 = new Launcher(new String[]{"find", "-d", "/Users/Admin/files/forTestJava/", "picture.png"}); //false
        launch1.launcher();
        assertFalse(launch1.getLogicR());

        Launcher launch2 = new Launcher(new String[]{"find", "-d", "/Users/Admin/files/forTestJava/", "-r", "picture.png"});
        launch2.launcher();
        assertTrue(launch2.getLogicR());

        Launcher launch3 = new Launcher(new String[]{"find", "-r", "-d", "/Users/Admin/files/forTestJava/", "picture.png"});
        launch3.launcher();
        assertTrue(launch3.getLogicR());

        Launcher launch4 = new Launcher(new String[]{"find", "-d", "/Users/Admin/files/forTestJava/", "picture.png", "-r"});
        launch4.launcher();
        assertTrue(launch4.getLogicR());
    }

    @Test
    void getDirectory() {
        Launcher launch1 = new Launcher(new String[]{"find", "-d", "/Users/Admin/files/forTestJava/", "picture.png"});
        launch1.launcher();
        assertEquals("/Users/Admin/files/forTestJava/", launch1.getDirectory());

        Launcher launch2 = new Launcher(new String[]{"find", "-r", "-d", "/Admin/files/forTestJava/", "picture.png"});
        launch2.launcher();
        assertEquals("/Admin/files/forTestJava/", launch2.getDirectory());

        Launcher launch3 = new Launcher(new String[]{"find", "-d", "/files/forTestJava/", "-r", "picture.png"});
        launch3.launcher();
        assertEquals("/files/forTestJava/", launch3.getDirectory());

        Launcher launch4 = new Launcher(new String[]{"find", "-d", "/forTestJava/", "picture.png", "-r"});
        launch4.launcher();
        assertEquals("/forTestJava/", launch4.getDirectory());
    }

    @Test
    void getFilename() {
        Launcher launch1 = new Launcher(new String[]{"find", "-d", "/Users/Admin/files/forTestJava/", "picture.png"});
        launch1.launcher();
        assertEquals("picture.png", launch1.getFilename());

        Launcher launch2 = new Launcher(new String[]{"find", "-r", "-d", "/Admin/files/forTestJava/", "file.txt"});
        launch2.launcher();
        assertEquals("file.txt", launch2.getFilename());

        Launcher launch3 = new Launcher(new String[]{"find", "-d", "/files/forTestJava/", "-r", "hello.test"});
        launch3.launcher();
        assertEquals("hello.test", launch3.getFilename());

        Launcher launch4 = new Launcher(new String[]{"find", "-d", "/forTestJava/", "pic.gph", "-r"});
        launch4.launcher();
        assertEquals("pic.gph", launch4.getFilename());
    }

    @Test
    void find() {
        Launcher launch1 = new Launcher(new String[]{"find", "-d", "/Users/Admin/files/forTestJava/", "picture.png"});
        launch1.launcher();
        boolean logicR1 = launch1.getLogicR();
        String directory1 = launch1.getDirectory();
        String filename1 = launch1.getFilename();
        ArrayList<File> answer1 = new Finder(logicR1, directory1, filename1).find();
        ArrayList<File> list1 = new ArrayList<File>();
        list1.add(new File("/Users/Admin/files/forTestJava/picture.png"));
        assertEquals(list1, answer1);

        Launcher launch2 = new Launcher(new String[]{"find", "-d", "/Users/Admin/IdeaProjects/FinderProject/test/Folder/", "Hello.txt"});
        launch2.launcher();
        boolean logicR2 = launch2.getLogicR();
        String directory2 = launch2.getDirectory();
        String filename2 = launch2.getFilename();
        ArrayList<File> answer2 = new Finder(logicR2, directory2, filename2).find();
        ArrayList<File> list2 = new ArrayList<File>();
        list2.add(new File("/Users/Admin/IdeaProjects/FinderProject/test/Folder/Hello.txt"));
        assertEquals(list2, answer2); //without r

        Launcher launch3 = new Launcher(new String[]{"find", "-r", "-d", "/Users/Admin/IdeaProjects/FinderProject/test/Folder/", "Hello.txt"});
        launch3.launcher();
        boolean logicR3 = launch2.getLogicR();
        String directory3 = launch2.getDirectory();
        String filename3 = launch2.getFilename();
        ArrayList<File> answer3 = new Finder(logicR3, directory3, filename3).find();
        ArrayList<File> list3 = new ArrayList<File>();
        list3.add(new File("/Users/Admin/IdeaProjects/FinderProject/test/Folder/Folder2/Hello.txt"));
        list3.add(new File("/Users/Admin/IdeaProjects/FinderProject/test/Folder/Hello.txt"));
        assertEquals(list3, answer3); //with r
    }
}