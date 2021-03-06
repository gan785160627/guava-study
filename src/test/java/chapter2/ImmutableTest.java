package chapter2;

import com.google.common.collect.*;
import org.junit.Test;

import java.util.List;
import java.util.Set;

public class ImmutableTest {
    @Test
    public void testOf() {
        //test immutableMap of
        ImmutableMap<String, String> immutableMap = ImmutableMap.of("a","1","b","2");
        System.out.println(immutableMap);
    }

    @Test
    public void testCopyOf() {
        //ImmutableList copyOf
        List<String> list = Lists.newArrayList("a", "b", "c");
        ImmutableList<String> immutableList = ImmutableList.copyOf(list);
        System.out.println(immutableList);
        list.add("d");
        System.out.println(immutableList);
    }

    @Test
    public void testBuilder() {
        //test ImmutableSet builder
        Set<String> set = Sets.newHashSet("a","b");
        ImmutableSet<String> immutableSet =
                ImmutableSet.<String>builder()
                        .addAll(set)
                        .add("c", "d")
                        .build();
        System.out.println(immutableSet);
    }
}
