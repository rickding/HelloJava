package com.hello;

import org.junit.Test;

public class Inst4Test {
    @Test
    public void testGetInst() {
        Inst4 inst = Inst4.getInst();
        System.out.printf("%s, %s\n", inst.getClass().getSimpleName(), inst);
    }
}
