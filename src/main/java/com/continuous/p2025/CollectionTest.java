package com.continuous.p2025;

import com.continuous.practice.Employee;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

@Setter
@Getter
@AllArgsConstructor
class Emp{
    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
        return true;
//        if (!(o instanceof Emp emp)) return false;
//        return id == emp.id && Objects.equals(name, emp.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

public class CollectionTest {

    public static void main(String[] args) {
        Set<Emp> set= new HashSet<>();
        set.add(new Emp(1,"babu"));
        set.add(new Emp(1,"babu"));
        set.add(new Emp(1,"babu"));
        System.out.println(set.size());
    }
}
