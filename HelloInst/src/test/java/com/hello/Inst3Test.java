package com.hello;

import org.junit.Test;

public class Inst3Test {
    @Test
    public void testGetInst() {
        Inst3 inst = Inst3.getInst();
        System.out.printf("%s, %s\n", inst.getClass().getSimpleName(), inst);
    }
}
