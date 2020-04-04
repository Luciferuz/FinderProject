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
            new Launcher(new String[]{"-d", "-r", "test/fold/", "document.txt", "-r"}); //вообще все неправильно
            new Launcher(new String[]{"-r", "-d", "test/folder"}); //нет файла
            new Launcher(new String[]{"-d", "test/folder/folder2", "-r", "document.txt", "hello.txt", "document.txt", "hello.txt"}); //слишком много parts в строке
        });
    }

    @Test
    void getLogicR() {
        Launcher launch1 = new Launcher(new String[]{"-d", "test/fold/", "document.txt"}); //false
        assertFalse(launch1.getLogicR());

        Launcher launch2 = new Launcher(new String[]{"-d", "test/folder", "-r", "hello.txt"});
        assertTrue(launch2.getLogicR());

        Launcher launch3 = new Launcher(new String[]{"-r", "-d", "test/folder/folder2", "hello.txt"});
        assertTrue(launch3.getLogicR());
    }

    @Test
    void getDirectory() {
        Launcher launch1 = new Launcher(new String[]{"-d", "test/fold/", "document.txt"});
        assertEquals("test/fold/", launch1.getDirectory());

        Launcher launch2 = new Launcher(new String[]{"-r", "-d", "test/folder", "hello.txt"});
        assertEquals("test/folder", launch2.getDirectory());

        Launcher launch3 = new Launcher(new String[]{"-d", "test/folder/folder2", "-r", "hello.txt"});
        assertEquals("test/folder/folder2", launch3.getDirectory());
    }

    @Test
    void getFilename() {
        Launcher launch1 = new Launcher(new String[]{"-d", "test/fold/", "document.txt"});
        assertEquals("document.txt", launch1.getFilename());

        Launcher launch2 = new Launcher(new String[]{"-r", "-d", "test/folder", "hello.txt"});
        assertEquals("hello.txt", launch2.getFilename());

        Launcher launch3 = new Launcher(new String[]{"-d", "test/folder/folder2", "-r", "hello.txt"});
        assertEquals("hello.txt", launch3.getFilename());
    }

    @Test
    void find() {
        List<File> answer1 = new Finder(false, "test/fold/", "document.txt").find();
        List<File> list1 = new ArrayList<>();
        list1.add(new File("test/fold/document.txt"));
        assertEquals(list1, answer1);

        List<File> answer2 = new Finder(false, "test/Folder/", "Hello.txt").find();
        List<File> list2 = new ArrayList<>();
        list2.add(new File("test/Folder/Hello.txt"));
        assertEquals(list2, answer2); //without r

        List<File> answer3 = new Finder(true, "test/Folder/", "Hello.txt").find();
        List<File> list3 = new ArrayList<>();
        list3.add(new File("test/Folder/Folder2/Hello.txt"));
        list3.add(new File("test/Folder/Hello.txt"));
        assertEquals(list3, answer3); //with r
    }
}