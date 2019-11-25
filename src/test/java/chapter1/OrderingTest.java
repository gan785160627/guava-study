package chapter1;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.sun.istack.internal.Nullable;
import org.junit.Test;

import java.util.List;


public class OrderingTest {
    class Foo {
        @Nullable
        String sortedBy;
        int notSortedBy;

        public Foo(String sortedBy,int notSortedBy) {
            this.sortedBy = sortedBy;
            this.notSortedBy = notSortedBy;
        }
        @Override
        public String toString() {
            return "("+sortedBy+","+notSortedBy+")";
        }
    }

    @Test
    public void testOrdering() {
        //test ordering .natural() .reverse() .nullsFirst() .onResultOf .sortedCopy .greatestOf
        Foo f1 = new Foo("a", 4);
        Foo f2 = new Foo("b", 3);
        Foo f3 = new Foo(null, 2);
        Foo f4 = new Foo("c", 1);
        List<Foo> list = Lists.newArrayList(f1, f2, f3, f4);
        Ordering<Foo> ordering = Ordering.natural().reverse().nullsFirst().onResultOf(new Function<Foo, String>() {
            public String apply(Foo foo) {
                return foo.sortedBy;
            }
        });
        List<Foo> sortedList = ordering.sortedCopy(list);
        System.out.println(sortedList);
        System.out.println(ordering.greatestOf(list, 2));
    }
}
