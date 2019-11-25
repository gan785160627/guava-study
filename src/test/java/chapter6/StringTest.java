package chapter6;

import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StringTest {
    @Test
    public void testJoint() {
        String key = Joiner.on("#").skipNulls().join("druid", null, "monitor", "data");
        System.out.println(key);
    }

    @Test
    public void testJointWithJava8() {
        List<String> list = Lists.newArrayList("druid", null, "monitor", "data");
        String key = list.stream().filter(Objects::nonNull).collect(Collectors.joining("#"));
        System.out.println(key);
    }

    @Test
    public void testSplitter() {
        Iterable<String> iterable = Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("   foo,bar,,   qux");
        System.out.println(iterable);
    }

    @Test
    public void testSplitterFixedLength() {
        Iterable<String> iterable = Splitter.fixedLength(3).split("abcdefghijklmn");
        System.out.println(iterable);
    }

    @Test
    public void testCharMatcher() {
        String string1 = "a12sdfe21";
        System.out.println(CharMatcher.DIGIT.retainFrom(string1));
        System.out.println(CharMatcher.JAVA_LETTER.retainFrom(string1));
        System.out.println("=============");
        String string2 = "     asdet          dsd fd   ";
        System.out.println(CharMatcher.WHITESPACE.trimAndCollapseFrom(string2, ' '));
        System.out.println("=============");
        String string3 = "asd234fgh456dfg";
        System.out.println(CharMatcher.JAVA_DIGIT.replaceFrom(string3, "*"));
        System.out.println("=============");
        String string4 = "ASsd243#$%sd WD";
        System.out.println(CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom(string4));
    }

    @Test
    public void testCaseFormat() {
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "CONSTANT_NAME"));
    }

}
