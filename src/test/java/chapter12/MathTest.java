package chapter12;

import com.google.common.math.BigIntegerMath;
import com.google.common.math.IntMath;
import org.junit.Test;

import java.math.BigInteger;
import java.math.RoundingMode;

public class MathTest {
    @Test
    public void test1() {
        System.out.println(Integer.MAX_VALUE+Integer.MAX_VALUE);
        IntMath.checkedAdd(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Test
    public void test2() {
        System.out.println(BigInteger.TEN.pow(99));
        System.out.println(BigIntegerMath.sqrt(BigInteger.TEN.pow(99), RoundingMode.DOWN));
        System.out.println(BigIntegerMath.sqrt(BigInteger.TEN.pow(99), RoundingMode.UP));
    }

    @Test
    public void test3() {
        System.out.println("最大公约数："+IntMath.gcd(12,8));
        System.out.println("阶乘："+IntMath.factorial(5));
    }
}
