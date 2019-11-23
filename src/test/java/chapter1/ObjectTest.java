package chapter1;

import com.google.common.base.Objects;
import com.guava.study.Person;
import org.junit.Test;

public class ObjectTest {
    @Test
    public void test1() {
        System.out.println(Objects.equal("a", "a"));
        System.out.println(Objects.equal(null, "a"));
        System.out.println(Objects.equal("a", null));
        System.out.println(Objects.equal(null, null));
    }

    @Test
    public void test2() {
        System.out.println(Objects.toStringHelper(this).add("x", 1).toString());
        System.out.println(Objects.toStringHelper("MyObject").add("x", 1).toString());
    }


    @Test
    public void test3() {
        Person person1 = new Person(1, "a","b",1);
        Person person2 = new Person(2, "a","b",2);
        System.out.println(person1.compareTo(person2));
    }
}
