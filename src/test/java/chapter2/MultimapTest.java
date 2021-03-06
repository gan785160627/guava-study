package chapter2;

import com.google.common.collect.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultimapTest {
    //Multimap对比基本的Map
    private static Map<String, List<Integer>> map = new HashMap<>();
    private static Multimap<String, Integer> multimap = ArrayListMultimap.create();

    static {
        //a -> 1 a -> 2 b -> 3 b -> 5 a ->4
        processMap("a", 1);
        processMap("a", 2);
        processMap("b", 3);
        processMap("b", 5);
        processMap("a", 4);
        System.out.println(map);
        processMultiMap("a", 1);
        processMultiMap("a", 2);
        processMultiMap("b", 3);
        processMultiMap("b", 5);
        processMultiMap("a", 4);
        System.out.println(multimap);
    }

    private static void processMap (String key, Integer value) {
        if (map.get(key) == null) {
            map.put(key, Lists.newArrayList(value));
        } else {
            List tmpList = map.get(key);
            tmpList.add(value);
            map.put(key, tmpList);
        }
    }

    private static void processMultiMap (String key, Integer value) {
        multimap.put(key, value);
    }
    @Test
    public void testGet() {
        //test get and .asMap().get
        System.out.println(multimap.asMap().get("c"));
        System.out.println(multimap.get("c"));
    }

    @Test
    public void testKeys() {
        //test keys and keySet
        System.out.println(multimap.keys());
        System.out.println(multimap.keySet());
    }

    @Test
    public void testValues() {
        //test values and asMap().values
        System.out.println(multimap.values());
        System.out.println(multimap.asMap().values());
    }
}
