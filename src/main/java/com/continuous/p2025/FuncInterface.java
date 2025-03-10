package com.continuous.p2025;

@FunctionalInterface
interface FuncInt1{
    public int add(int a, int b);
    default int def(int i){
        return i;
    }
}

interface FuncTest2 extends FuncInt1{
    public int sub(int a, int b);
    public int add(int a, int b);

    default int def(int i){
        pri();
        return i+i;
    }
    private void pri(){
        System.out.println("private method called from FuncTest2 ");
    }
    static void sta(){
        System.out.println("static method called from FuncTest2 ");
    }
}

class FuncTest implements FuncInt1, FuncTest2{

    @Override
    public int sub(int a, int b) {
        return 0;
    }

    @Override
    public int add(int a, int b) {
        return a+b;
    }

}
public class FuncInterface {

    public static void main(String[] args) {
        FuncTest funcTest = new FuncTest();
        int add = funcTest.add(2, 5);
        int def = funcTest.def(10);
        System.out.println(def);
        System.out.println(add);
    }
}
