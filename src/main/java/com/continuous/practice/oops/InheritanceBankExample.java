package com.continuous.practice.oops;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class Interest {
    public float interest;

    @Override
    public String toString() {
        return "Interest{" +
                "interest=" + interest +
                '}';
    }
}

class Bank {
    {
        System.out.println("Bank");
    }

    public Interest getInterest() {
        return new Interest(4.5f);
    }
}

class SbiInterest extends Bank {
    {
        System.out.println("SbiInterest");
    }

    public Interest getInterest() {
        return new Interest(6f);
    }
}

class IciciInterest extends Bank {
    {
        System.out.println("IciciInterest");
    }

    public Interest getInterest() {
        return new Interest(7f);
    }
}

class X {
    public X() {
        System.out.println(1);
    }
}

class Y extends X {
    public Y() {
        System.out.println(2);
    }
}

public class InheritanceBankExample {
    public static void main(String[] args) {
        Bank b = new SbiInterest();
        System.out.println(b.getInterest());
    }
}
