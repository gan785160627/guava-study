package com.guava.study;

import com.google.common.base.Preconditions;

import java.util.List;

public class TestPrecondition {
    public void getPerson(int age, String name, List<String> children) {
        Preconditions.checkNotNull(name, "name不能为null");
        Preconditions.checkArgument(name.length()>0, "neme不能为\'\'");
        Preconditions.checkArgument(age>0, "age 必须大于0");
        Preconditions.checkElementIndex(1, children.size(),"必须有至少两个孩子");
        System.out.println("a person age:"+age+",name:"+name+",two children are "+children.get(0) +" and "+children.get(1));
    }
}
