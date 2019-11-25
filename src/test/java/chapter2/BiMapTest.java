package chapter2;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

public class BiMapTest {
    @Test
    public void testBiMap() {
        //test Map and BiMap
        Map<String, Integer> nameToId = Maps.newHashMap();
        Map<Integer, String> idToName = Maps.newHashMap();
        nameToId.put("Bob", 42);
        idToName.put(42, "Bob");
        BiMap<String, Integer> idName = HashBiMap.create();
        idName.put("Bob", 42);
        System.out.println(idName.inverse().get(42));
    }

    @Test
    public void testBiMapValue() {
        //BiMap不仅key不相同，value也不能相同
        BiMap<String, Integer> idName = HashBiMap.create();
        idName.put("Bob", 42);
        idName.put("Bob2", 42);
    }
}
