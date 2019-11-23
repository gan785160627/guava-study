package chapter2;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.junit.Test;

public class TableTest {
    @Test
    public void test1() {
        Table<Integer, Integer, String> weightedGraph = HashBasedTable.create();
        weightedGraph.put(1, 2, "a");
        weightedGraph.put(1, 3, "b");
        weightedGraph.put(2, 3, "c");

        System.out.println(weightedGraph.rowMap());
        System.out.println(weightedGraph.cellSet());
        System.out.println(weightedGraph.row(1));
        System.out.println(weightedGraph.column(3));
    }
}
