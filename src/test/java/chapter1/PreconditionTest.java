package chapter1;

import com.google.common.collect.Lists;
import com.guava.study.TestPrecondition;
import org.junit.Test;

public class PreconditionTest {
    TestPrecondition preconditionTest = new TestPrecondition();
    @Test
    public void testCheckElementIndex() {
        //test checkElementIndex
        preconditionTest.getPerson(50, "zhangsan", Lists.newArrayList("zhangyi","zhanger"));
        preconditionTest.getPerson(50, "zhangsan", Lists.newArrayList("zhangyi"));
    }

    @Test
    public void testCheckArgument() {
        //test checkArgument
        preconditionTest.getPerson(-10, "zhangsan", Lists.newArrayList("zhangyi"));
    }

    @Test
    public void testCheckNotNull() {
        //test checkNotNull
        preconditionTest.getPerson(50, null, Lists.newArrayList("zhangyi"));
    }
}
