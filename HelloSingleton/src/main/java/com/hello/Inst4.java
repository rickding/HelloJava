package com.hello;

public class Inst4 {
    private static volatile Inst4 inst = null;

    public static Inst4 getInst() {
        if (inst == null) {
            synchronized (Inst4.class) {
                if (inst == null) {
                    inst = new Inst4();
                }
            }
        }
        return inst;
    }

    private Inst4() {
        System.out.printf("Create: %s\n", this.getClass().getSimpleName());
    }
}
