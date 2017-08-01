package com.hello;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by user on 2017/8/1.
 */
public class StringDecoderTest {
    @Test
    public void testFrequency() {
        String input = "1226#24#";
        int[] output = StringDecoder.frequency(input);
        Assert.assertEquals(1, output[0]);
        Assert.assertEquals(1, output[1]);
    }
}
