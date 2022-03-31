package com.test.boot.config;

public class JacocoExample {

    public String check(String name){
        StringBuilder stringBuilder=new StringBuilder();
        if(name==null || name.trim().length()==0){
            stringBuilder.append("please provide a name");
        }else{
            stringBuilder.append("Hello "+name);
        }
        return stringBuilder.toString();
    }
}
