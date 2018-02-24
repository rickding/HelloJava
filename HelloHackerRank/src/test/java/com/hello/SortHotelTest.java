package com.hello;

import org.junit.Assert;
import org.junit.Test;

public class SortHotelTest {
    @Test
    public void testSortHotels() {
        int[] ret = SortHotel.sort_hotels(
                "breakfast beach citycenter location metro view staff price",
                new int[]{1, 2, 1, 1, 2},
                new String[]{
                        "This hotel has a nice view of the citycenter. The location is perfect.",
                        "The breakfast is ok. Regarding location, it is quite far from citycenter buth price is cheap so it is worth.",
                        "Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.",
                        "They said I couldn't take my dog and there were other guests with dogs! That is not fair.",
                        "Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter."
                });
        Assert.assertArrayEquals(new int[] {2, 1}, ret);
    }
}
