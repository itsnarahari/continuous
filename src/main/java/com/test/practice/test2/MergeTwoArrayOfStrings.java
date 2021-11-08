package com.test.practice.test2;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoArrayOfStrings<T> {

    public List<T>  merge(T a,T b){
        List<T> mainList = new ArrayList<>();
        mainList.add(a);
        mainList.add(b);
        return mainList;
    }

    public static void main(String[] args) {

    }
}
