package chapter13;

import com.google.common.reflect.Reflection;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyTest {
    public static class MyInvocationHandler implements InvocationHandler {
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {
            System.out.println(method.getName()+" method with param"+args[0]);
            return null;
        }
    }

    public  interface IFoo {
        void doSomething(String string);
    }

    @Test
    public void test1() {
        InvocationHandler invocationHandler = new MyInvocationHandler();
        IFoo foo = Reflection.newProxy(IFoo.class, invocationHandler);
        foo.doSomething("test");
    }
}
