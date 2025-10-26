package com.codility.beans;

import org.springframework.stereotype.Component;

@Component
public class SomeUtil {

    public SomeUtil(){
        System.out.println("[SomeUtil]  Component Scan successful.");
    }

    public String getUtilityInfo(){
        return "Utility bean active.";
    }
}
