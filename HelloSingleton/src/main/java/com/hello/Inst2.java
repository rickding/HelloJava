package com.hello;

public class Inst2 {
    private static Inst2 inst = null;

    public static Inst2 getInst() {
        if (inst == null) {
            inst = new Inst2();
        }
        return inst;
    }

    private Inst2() {
        System.out.printf("Create: %s\n", this.getClass().getSimpleName());
    }
}
