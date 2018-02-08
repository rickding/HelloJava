package com.hello;

import org.junit.Test;

import java.util.Arrays;

public class MovieTtitlesTest {
    @Test
    public void testMovieTtitles() {
        final String[] ret = MovieTtitles.getMovieTitles("spiderman");
        System.out.println(Arrays.asList(ret).toString());
    }
}
