package com.guava.study;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

public class SkipNullAbstractIterator {
    public static Iterator<String> skipNulls(final Iterator<String> in) {
        return new AbstractIterator<String>() {
            @Override
            protected String computeNext() {
                while (in.hasNext()) {
                    String s = in.next();
                    if (s != null) {
                        return s;
                    }
                }
                return endOfData();
            }
        };
    }
}
