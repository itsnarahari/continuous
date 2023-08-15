package com.test.practice.latest;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashSetExample {

    public static void main(String[] args) {

        Details details = new Details(1, "hero");
        Details details2 = new Details(1, "hero");
        Set<Details> detailsSet = new HashSet<>();
        detailsSet.add(details);
        detailsSet.add(details2);
        System.out.println(detailsSet.size());
    }
}

@AllArgsConstructor
class Details {
    int id;
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Details)) return false;
        Details details = (Details) o;
        return id == details.id && Objects.equals(name, details.name);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
