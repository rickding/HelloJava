package com.hello;

public class Inst5 {
    private static class Holder {
        private static Inst5 inst = new Inst5();
    }

    public static Inst5 getInst() {
        return Holder.inst;
    }

    private Inst5() {
        System.out.printf("Create: %s\n", this.getClass().getSimpleName());
    }
}
