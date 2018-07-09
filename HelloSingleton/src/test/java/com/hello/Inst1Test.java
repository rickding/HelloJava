package com.hello;

import org.junit.Test;

public class Inst1Test {
    @Test
    public void testGetInst() {
        Inst1 inst = Inst1.getInst();
        System.out.printf("%s, %s\n", inst.getClass().getSimpleName(), inst);
    }
}
