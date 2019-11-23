package com.guava.study;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Person implements Comparable<Person> {
    private Integer id;
    private String lastName;
    private String firstName;
    private int zipCode;

    @Override
    public int compareTo(Person that) {
        return ComparisonChain.start()
                .compare(this.lastName, that.lastName)
                .compare(this.firstName, that.firstName)
                .compare(this.zipCode, that.zipCode, Ordering.natural().nullsLast())
                .result();
    }
}