package chapter9;

import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;

public class FileTest {
    @Test
    public void test1() {
        try {
            String root = System.getProperty("user.dir");
            System.out.println(Files.getNameWithoutExtension(root + "/doc/file.txt"));
            System.out.println(Files.getFileExtension(root + "/doc/file.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try {
            String root = System.getProperty("user.dir");
            File file = new File(root+"/doc/file/file.txt");
            Files.createParentDirs(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
