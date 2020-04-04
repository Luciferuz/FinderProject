package Package;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class tests {

    @Test
    void launcher() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> {
            new Launcher(new String[]{"finddd", "-d", "/Users/Admin/files/forTestJava/", "picture.png", "-r"}); //find с ошибкой
            new Launcher(new String[]{"find", "-d", "-r", "/Users/Admin/files/forTestJava/", "picture.png", "-r"}); //вообще все неправильно
            new Launcher(new String[]{"find", "-r", "/Users/Admin/files/forTestJava/", "picture.png"}); //нет -d
            new Launcher(new String[]{"find", "-r", "-d", "/Users/Admin/files/forTestJava/"}); //нет файла
            new Launcher(new String[]{"find", "-d", "/Users/Admin/files/forTestJava/", "-r", "picture.png", "picture.png", "picture.png", "picture.png"}); //слишком много parts в строке
        });
    }

    @Test
    void getLogicR() {
        Launcher launch1 = new Launcher(new String[]{"find", "-d", "/Users/Admin/files/forTestJava/", "picture.png"}); //false
        assertFalse(launch1.getLogicR());

        Launcher launch2 = new Launcher(new String[]{"find", "-d", "/Users/Admin/files/forTestJava/", "-r", "picture.png"});
        assertTrue(launch2.getLogicR());

        Launcher launch3 = new Launcher(new String[]{"find", "-r", "-d", "/Users/Admin/files/forTestJava/", "picture.png"});
        assertTrue(launch3.getLogicR());
    }

    @Test
    void getDirectory() {
        Launcher launch1 = new Launcher(new String[]{"find", "-d", "/Users/Admin/files/forTestJava/", "picture.png"});
        assertEquals("/Users/Admin/files/forTestJava/", launch1.getDirectory());

        Launcher launch2 = new Launcher(new String[]{"find", "-r", "-d", "/Admin/files/forTestJava/", "picture.png"});
        assertEquals("/Admin/files/forTestJava/", launch2.getDirectory());

        Launcher launch3 = new Launcher(new String[]{"find", "-d", "/files/forTestJava/", "-r", "picture.png"});
        assertEquals("/files/forTestJava/", launch3.getDirectory());
    }

    @Test
    void getFilename() {
        Launcher launch1 = new Launcher(new String[]{"find", "-d", "/Users/Admin/files/forTestJava/", "picture.png"});
        assertEquals("picture.png", launch1.getFilename());

        Launcher launch2 = new Launcher(new String[]{"find", "-r", "-d", "/Admin/files/forTestJava/", "file.txt"});
        assertEquals("file.txt", launch2.getFilename());

        Launcher launch3 = new Launcher(new String[]{"find", "-d", "/files/forTestJava/", "-r", "hello.test"});
        assertEquals("hello.test", launch3.getFilename());
    }

    @Test
    void find() {
        List<File> answer1 = new Finder(false, "/Users/Admin/files/forTestJava/", "picture.png").find();
        List<File> list1 = new ArrayList<>();
        list1.add(new File("/Users/Admin/files/forTestJava/picture.png"));
        assertEquals(list1, answer1);

        List<File> answer2 = new Finder(false, "/Users/Admin/IdeaProjects/FinderProject/test/Folder/", "Hello.txt").find();
        List<File> list2 = new ArrayList<>();
        list2.add(new File("/Users/Admin/IdeaProjects/FinderProject/test/Folder/Hello.txt"));
        assertEquals(list2, answer2); //without r

        List<File> answer3 = new Finder(true, "/Users/Admin/IdeaProjects/FinderProject/test/Folder/", "Hello.txt").find();
        List<File> list3 = new ArrayList<>();
        list3.add(new File("/Users/Admin/IdeaProjects/FinderProject/test/Folder/Folder2/Hello.txt"));
        list3.add(new File("/Users/Admin/IdeaProjects/FinderProject/test/Folder/Hello.txt"));
        assertEquals(list3, answer3); //with r
    }
}