package com.hello;

import org.junit.Test;

public class Inst5Test {
    @Test
    public void testGetInst() {
        Inst5 inst = Inst5.getInst();
        System.out.printf("%s, %s\n", inst.getClass().getSimpleName(), inst);
    }
}
