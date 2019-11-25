package chapter2;

import com.google.common.collect.Lists;
import com.guava.study.AddLoggingList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AddLoggingListTest {
    @Test
    public void testForwardingList() {
        //test ForwardingList
        AddLoggingList<String> addLoggingList = new AddLoggingList<>(new ArrayList<>());
        List<String> list = Lists.newArrayList("d", "e", "f");
        addLoggingList.add("a");
        addLoggingList.add(0,"b");
        addLoggingList.add("c");
        addLoggingList.addAll(list);
    }
}
