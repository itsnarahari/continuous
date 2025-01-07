package com.test;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.DoubleStream;

public class Empty {
    
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    static {
        System.out.println("Static block");
    }
    {
        System.out.println("Anonymous block");
    }
    public Empty(){
        System.out.println("Constructor called");
    }
    public static void main(String[] args) {


        Empty empty=new Empty();
        Empty empty2=new Empty();


        double random = 2 + (Math.random() * 2);
        System.out.println(random);

        int min = 1000;
        int max = 10000;
//Generate random double value from 200 to 400
        System.out.println("Random value of type double between "+min+" to "+max+ ":");
        System.out.println(Math.round(Math.random()*(10000-1000+1)+min * 100.d) / 100.0d );

        Date d1= new Date(new Date().getTime() - 10000);
        Date d2=new Date();

        Date randomDate = new Date(ThreadLocalRandom.current()
                .nextLong(d1.getTime(), d2.getTime()));
        System.out.println(randomDate);
    }

    public static DoubleStream doubles(int dimension, double minValue, double maxValue )
    {
        return new Random().doubles( dimension, minValue, maxValue );
    }
}
