package chapter13;

import com.google.common.collect.Lists;
import com.google.common.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;

public class TypeTokenTest {
    @Test
    public void test1() {
        ArrayList<String> stringList = Lists.newArrayList();
        ArrayList<Integer> intList = Lists.newArrayList();
        System.out.println("intList type is " + intList.getClass());
        System.out.println("stringList type is " + stringList.getClass());
        System.out.println(stringList.getClass().isAssignableFrom(intList.getClass()));
    }

    @Test
    public void test2() {
        TypeToken<ArrayList<String>> typeToken = new TypeToken<ArrayList<String>>() {};
        System.out.println(typeToken.getType());
        TypeToken<?> genericTypeToken = typeToken.resolveType(ArrayList.class.getTypeParameters()[0]);
        System.out.println(genericTypeToken.getType());
        System.out.println(genericTypeToken.getRawType());
    }
}
