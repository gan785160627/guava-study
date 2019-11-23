package chapter13;

import com.google.common.reflect.Invokable;
import com.google.common.reflect.TypeToken;
import com.sun.istack.internal.Nullable;
import org.junit.Test;

import java.util.List;

public class InvokableTest {
    @Test
    public void test1() {
        try {
            Invokable<List<String>, ?> invokable = new TypeToken<List<String>>(){}.method(List.class.getMethod("add", Object.class));
            System.out.println(invokable.getReturnType());
            System.out.println(invokable.isOverridable());
            System.out.println(invokable.isPublic());
            System.out.println(invokable.getParameters().get(0).isAnnotationPresent(Nullable.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
