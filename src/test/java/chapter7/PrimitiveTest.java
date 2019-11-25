package chapter7;

import com.google.common.primitives.Ints;
import org.junit.Test;

public class PrimitiveTest {
    @Test
    public void testPrimitive() {
        int[] array = { 1, 2, 3, 4, 5 };
        int[] array2 = { 6, 7, 8, 9, 10 };
        int a = 4;
        System.out.println("contains:"+Ints.contains(array, a));
        System.out.println("index:"+Ints.indexOf(array, a));
        System.out.println("max:"+Ints.max(array));
        System.out.println("min:"+Ints.min(array));
        System.out.println("concat:"+Ints.concat(array, array2));
        System.out.println("join:"+Ints.join(",", Ints.concat(array, array2)));
        System.out.println("compare:"+Ints.compare(3,6));
        System.out.println("BYTES:"+Ints.BYTES);
    }
}
