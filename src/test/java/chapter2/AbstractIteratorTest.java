package chapter2;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static com.guava.study.SkipNullAbstractIterator.skipNulls;

public class AbstractIteratorTest {
    @Test
    public void testSkipNullAbstractIterator() {
        //test SkipNullAbstractIterator skipNulls
        List<String> list = Lists.newArrayList("a","b",null,"c");
        Iterator<String> iterator = list.iterator();
        Iterator<String> newIterator = skipNulls(iterator);
        while(newIterator.hasNext()) {
            System.out.println("next:"+newIterator.next());
        }
    }
}
