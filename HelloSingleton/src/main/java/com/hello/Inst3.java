package com.hello;

public class Inst3 {
    private static volatile Inst3 inst = null;

    public static Inst3 getInst() {
        synchronized (Inst3.class) {
            if (inst == null) {
                inst = new Inst3();
            }
        }
        return inst;
    }

    private Inst3() {
        System.out.printf("Create: %s\n", this.getClass().getSimpleName());
    }
}
