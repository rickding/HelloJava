package com.hello;

import org.junit.Test;

public class Inst2Test {
    @Test
    public void testGetInst() {
        Inst2 inst = Inst2.getInst();
        System.out.printf("%s, %s\n", inst.getClass().getSimpleName(), inst);
    }
}
