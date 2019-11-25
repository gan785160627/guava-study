package chapter8;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Range;
import org.junit.Test;

import static com.google.common.collect.BoundType.CLOSED;
import static com.google.common.collect.BoundType.OPEN;

public class RangeTest {
    @Test
    public void testRange() {
        System.out.println(Range.closed(1, 3));
        System.out.println(Range.closedOpen(1, 3));
        System.out.println(Range.lessThan(3));
        System.out.println(Range.atMost(3));
        System.out.println(Range.range(1, CLOSED, 4, OPEN));
        System.out.println(Range.closed(1, 5).encloses(Range.closed(2, 3)));
        System.out.println(Range.closed(3, 5).isConnected(Range.open(5, 10)));
        System.out.println(Range.closed(3, 5).intersection(Range.open(4, 10)));
        System.out.println(Range.closed(1, 5).span(Range.closed(6, 10)));
        ImmutableSortedSet set = ContiguousSet.create(Range.open(1, 5), DiscreteDomain.integers());
        System.out.println(set);
    }
}
