package chapter2;

import com.google.common.base.Function;
import com.google.common.collect.*;
import com.google.common.primitives.Ints;
import com.guava.study.Person;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionUtilTest {
    @Test
    public void test1() {
        List<String> list = Lists.newArrayList("a", "b", "c", "a", "c", "d");
        System.out.println(Iterables.frequency(list, "a"));
        System.out.println(Iterables.getLast(list));
        System.out.println(Lists.reverse(list));
        System.out.println(Iterables.getOnlyElement(list));
    }

    @Test
    public void test2() {
        Set<String> set1 = Sets.newHashSet("a", "b", "c", "d");
        Set<String> set2 = Sets.newHashSet("c", "d", "e", "f");
        Sets.SetView<String> intersection = Sets.intersection(set1, set2);
        System.out.println(intersection);
        Sets.SetView<String> union = Sets.union(set1, set2);
        System.out.println(union);
        Sets.SetView<String> difference = Sets.difference(set1, set2);
        System.out.println(difference);
        Sets.SetView<String> symmetricDifference = Sets.symmetricDifference(set1, set2);
        System.out.println(symmetricDifference);
        Set<List<String>> cartesianProduct = Sets.cartesianProduct(set1, set2);
        System.out.println(cartesianProduct);
        Set<Set<String>> powerSet = Sets.powerSet(set1);
        System.out.println(powerSet);
    }


    @Test
    public void test3() {
        Person person1 = new Person(1,"a","b", 1000);
        Person person2 = new Person(2,"c","d", 1000);
        Person person3 = new Person(3,"e","f", 1000);
        List<Person> people = Lists.newArrayList(person1, person2, person3);
        ImmutableMap<Integer, Person> stringsByIndex = Maps.uniqueIndex(people,
                new Function<Person, Integer>() {
                    public Integer apply(Person person) {
                        return person.getId();
                    }
                });
        System.out.println(stringsByIndex);
    }

    @Test
    public void test4() {
        Map<String, Integer> left = ImmutableMap.of("a", 1, "b", 2, "c", 3);
        Map<String, Integer> right = ImmutableMap.of( "b", 2, "c", 4, "d", 5);
        MapDifference<String, Integer> diff = Maps.difference(left, right);

        System.out.println(diff.entriesInCommon());
        System.out.println(diff.entriesDiffering());
        System.out.println(diff.entriesOnlyOnLeft());
        System.out.println(diff.entriesOnlyOnRight());
    }

    @Test
    public void test5() {
        ImmutableSet digits = ImmutableSet.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        Function<String, Integer> lengthFunction = new Function<String, Integer>() {
            public Integer apply(String string) {
                return string.length();
            }
        };

        ImmutableListMultimap<Integer, String> digitsByLength= Multimaps.index(digits, lengthFunction);
        System.out.println(digitsByLength);
    }

    @Test
    public void test6() {
        ArrayListMultimap<String, Integer> multimap = ArrayListMultimap.create();
        multimap.putAll("b", Ints.asList(2, 4, 6));
        multimap.putAll("a", Ints.asList(4, 2, 1));
        multimap.putAll("c", Ints.asList(2, 5, 3));

        TreeMultimap<Integer, String> inverse = Multimaps.invertFrom(multimap, TreeMultimap.<Integer, String>create());
        System.out.println(inverse);
    }

}
