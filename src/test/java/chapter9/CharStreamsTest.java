package chapter9;

import com.google.common.io.CharStreams;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CharStreamsTest {
    String root = System.getProperty("user.dir");
    @Test
    public void test1() {

        try {
            BufferedReader buffered = new BufferedReader(new FileReader(root+"/doc/test.txt"));
            List<String> lines = new ArrayList<>();
            for (;;) {
                String line = buffered.readLine();
                if (line == null) {
                    break;
                }
                lines.add(line);
            }
            System.out.println(lines);
            List<String> guavaLines = CharStreams.readLines(new FileReader(root+"/doc/test.txt"));
            System.out.println(guavaLines);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test2() {
        try {
            String content = CharStreams.toString(new FileReader(root+"/doc/test.txt"));
            System.out.println(content);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test3() {
        try {
            FileWriter writer = new FileWriter(root+"/doc/testCopy.txt");
            long res = CharStreams.copy(new FileReader(root+"/doc/test.txt"), writer);
            writer.flush();
            System.out.println(res);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test4() {
        try {
            FileReader reader = new FileReader(root+"/doc/test.txt");
            CharStreams.skipFully(reader, 3);
            System.out.println(CharStreams.toString(reader));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
