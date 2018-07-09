package com.hello;

import org.junit.Test;

public class Inst6Test {
    @Test
    public void testGetInst() {
        Inst6 inst = Inst6.INSTANCE;
        System.out.printf("%s, %s\n", inst.getClass().getSimpleName(), inst.getClass());
    }
}
