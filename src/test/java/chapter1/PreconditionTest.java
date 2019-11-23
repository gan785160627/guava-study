package chapter1;

import com.google.common.collect.Lists;
import com.guava.study.PersonPrecondition;
import org.junit.Test;

public class PreconditionTest {
    PersonPrecondition preconditionTest = new PersonPrecondition();
    @Test
    public void test1() {
        preconditionTest.getPerson(50, "zhangsan", Lists.newArrayList("zhangyi","zhanger"));
        preconditionTest.getPerson(50, "zhangsan", Lists.newArrayList("zhangyi"));
    }

    @Test
    public void test2() {
        preconditionTest.getPerson(-10, "zhangsan", Lists.newArrayList("zhangyi"));
    }

    @Test
    public void test3() {
        preconditionTest.getPerson(50, "", Lists.newArrayList("zhangyi"));
    }
}
