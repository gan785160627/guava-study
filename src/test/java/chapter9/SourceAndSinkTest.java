package chapter9;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;

public class SourceAndSinkTest {
    String root = System.getProperty("user.dir");
    File file = new File(root + "/doc/test.txt");
    File writeFile = new File(root+"/doc/testCopy1.txt");
    CharSource charSource = Files.asCharSource(file, Charsets.UTF_8);
    CharSink charSink = Files.asCharSink(writeFile, Charsets.UTF_8);
    @Test
    public void test1() {
        try {
            ImmutableList<String> lines = charSource.readLines();
            System.out.println(lines);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try {
            String line = charSource.read();
            System.out.println(line);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        try {
            long res = charSource.copyTo(charSink);
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() {
        try {
            charSink.write("test");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test5() {
        try {
            charSink.writeLines(Lists.newArrayList("a", "b", "c"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
