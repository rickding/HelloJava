package com.hello;

import org.junit.Assert;
import org.junit.Test;

public class ElectionWinnerTest {
    @Test
    public void testElectionWinner() {
        String ret = ElectionWinner.electionWinner(null);
        Assert.assertEquals(null, ret);
    }
}
