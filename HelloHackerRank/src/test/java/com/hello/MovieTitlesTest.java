package com.hello;

import org.junit.Test;

import java.util.Arrays;

public class MovieTitlesTest {
    @Test
    public void testMovieTitles() {
        final String[] ret = MovieTitles.getMovieTitles("spiderman");
        System.out.println(Arrays.asList(ret).toString());
    }
}
