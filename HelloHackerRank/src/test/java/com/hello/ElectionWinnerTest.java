package com.hello;

import org.junit.Assert;
import org.junit.Test;

public class ElectionWinnerTest {
    @Test
    public void testElectionWinner() {
        String ret = ElectionWinner.electionWinner(new String[] {"Alex", "Michael", "harry", "Dave", "Michael", "Victor", "Harry", "Alex", "Mary", "Mary"});
        Assert.assertEquals("Michael", ret);
    }
}
