package chapter2;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultisetTest {
    @Test
    public void testWordCount() {
        //  单词计数的三种方式
        List<String> words = Lists.newArrayList("a","b","c","b","d","d");
        //原始方式
        Map<String, Integer> counts = new HashMap<String, Integer>();
        for (String word : words) {
            Integer count = counts.get(word);
            if (count == null) {
                counts.put(word, 1);
            } else {
                counts.put(word, count + 1);
            }
        }
        System.out.println(counts);
        //multiset方式
        Multiset multiset = HashMultiset.create(words);
        System.out.println(multiset);
        System.out.println(multiset.count("b"));
        System.out.println(multiset.elementSet());
        System.out.println(multiset.entrySet());
        System.out.println(multiset.size());
        System.out.println(multiset.elementSet().size());
        //merge方式
        Map<String, Integer> counts2 = new HashMap<String, Integer>();
        for (String word : words) {
            counts2.merge(word, 1, (prev, one) -> prev + one);
        }
        System.out.println(counts2);
    }

}
