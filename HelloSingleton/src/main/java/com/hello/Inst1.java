package com.hello;

public class Inst1 {
    private static Inst1 inst = new Inst1();

    public static Inst1 getInst() {
        return inst;
    }

    private Inst1() {
        System.out.printf("Create: %s\n", this.getClass().getSimpleName());
    }
}
