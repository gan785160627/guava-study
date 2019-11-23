package com.guava.study;

import com.google.common.collect.ForwardingList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author ganying
 * @date 19/10/31
 */
public class AddLoggingList<E> extends ForwardingList<E> {
    final List<E> delegate;

    public AddLoggingList(List<E> delegate) {
        this.delegate = delegate;
    }

    @Override
    protected List<E> delegate() {
        return delegate;
    }

    @Override
    public void add(int index, E elem) {
        System.out.println(index + ":" + elem);
        super.add(index, elem);
    }

    @Override
    public boolean add(E elem) {
        return standardAdd(elem);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return standardAddAll(c);
    }
}


