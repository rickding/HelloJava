package com.hello;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MovieTitlesTest {
    @Test
    public void testMovieTitles() {
        final String[] ret = MovieTitles.getMovieTitles("spiderman");
        System.out.println(Arrays.asList(ret).toString());
        Assert.assertArrayEquals(new String[]{
                "Amazing Spiderman Syndrome",
                "Fighting, Flying and Driving: The Stunts of Spiderman 3",
                "Hollywood's Master Storytellers: Spiderman Live",
                "Italian Spiderman",
                "Spiderman",
                "Spiderman",
                "Spiderman 5",
                "Spiderman and Grandma",
                "Spiderman in Cannes",
                "Superman, Spiderman or Batman",
                "The Amazing Spiderman T4 Premiere Special",
                "The Death of Spiderman",
                "They Call Me Spiderman",
        }, ret);
    }
}
