package chapter10;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.hash.*;
import com.guava.study.Person;
import org.junit.Test;

import java.util.List;

public class HashTest {
    Funnel<Person> personFunnel = new Funnel<Person>() {
        @Override
        public void funnel(Person person, PrimitiveSink into) {
            into
                    .putInt(person.getId())
                    .putString(person.getFirstName(), Charsets.UTF_8)
                    .putString(person.getLastName(), Charsets.UTF_8)
                    .putInt(person.getZipCode());
        }
    };
    @Test
    public void test1() {
        Person person = new Person(1, "san", "zhang", 1);
        HashFunction hf = Hashing.md5();
        HashCode hc = hf.newHasher()
                .putObject(person, personFunnel)
                .hash();
        System.out.println(hc);
    }

    @Test
    public void test2() {
        HashCode hashCode = Hashing.sha256().hashString("test", Charsets.UTF_8);
        System.out.println(hashCode);
    }

    @Test
    public void test3() {
        Person person1 = new Person(1, "a","b",1);
        Person person2 = new Person(2, "a","b",2);
        Person person3 = new Person(3, "c","d",3);
        Person person4 = new Person(4, "e","f",4);
        Person person5 = new Person(5, "e","f",5);
        List<Person> friendsList = Lists.newArrayList(person1, person2, person3, person4);
        BloomFilter<Person> friends = BloomFilter.create(personFunnel, 5, 0.5);
        for(Person friend : friendsList) {
            friends.put(friend);
        }
        for (int i = 0;i<10;i++) {
            if (friends.mightContain(person5)) {
                System.out.println(person5.toString());
            } else {
                System.out.println("不存在person5");
            }
            if (friends.mightContain(person4)) {
                System.out.println(person4.toString());
            } else {
                System.out.println("不存在person4");
            }
        }
    }
}
