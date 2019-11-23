package chapter1;

import com.google.common.base.Optional;
import org.junit.Test;

import static com.google.common.base.Strings.nullToEmpty;

public class OptionTest {
    @Test
    public void test1() {
        Optional<Integer> possible = Optional.of(5);
        System.out.println(possible.isPresent());
        System.out.println(possible.get());
    }

    @Test
    public void test2() {
        Optional<Integer> possible = Optional.absent();
        System.out.println(possible.isPresent());
        System.out.println(possible.get());
    }

    @Test
    public void test3() {
        String string1 = null;
        String string2 = nullToEmpty(string1);
        System.out.println("res:"+string2.length());
    }
}
