package com.hello;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieTitles {
    public static String[] getMovieTitles(String substr) {
        if (substr == null || substr.trim().length() <= 0) {
            return null;
        }

        // Initialize
        int page = 1;
        final String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=%s&page=%d";
        Gson gson = new Gson();
        List<String> movies = new ArrayList<String>();

        while (true) {
            // Get response
            String response = null;
            try {
                response = httpGet(String.format(url, substr, page));
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Check
            if (response == null || response.trim().length() <= 0) {
                break;
            }

            // Parse json
            MoviePage moviePage = gson.fromJson(response, MoviePage.class);
            if (moviePage == null || moviePage.data == null || moviePage.data.size() <= 0) {
                break;
            }

            // Read the data
            for (Movie movie : moviePage.data) {
                movies.add(movie.Title);
            }

            if (page < moviePage.total_pages) {
                page++;
            } else {
                break;
            }
        }

        // Return the titles
        String[] titles = new String[movies.size()];
        movies.toArray(titles);
        Arrays.sort(titles);
        return titles;
    }


    /**
     * Request the http url
     * @param url
     * @return
     * @throws Exception
     */
    public static String httpGet(String url) throws Exception {
        if (url == null || url.length() <= 0) {
            return null;
        }

        URL localURL = new URL(url);
        URLConnection connection = localURL.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) connection;

        // Fail
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode >= 300) {
            throw new Exception(String.format("HTTP Request is not success, code: %d", responseCode));
        }

        // Read
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();

        try {
            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);

            String tempLine = null;
            while ((tempLine = reader.readLine()) != null) {
                resultBuffer.append(tempLine);
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return resultBuffer.toString();
    }

    public class MoviePage {
        int total_pages;
        List<Movie> data;

        public int getTotal_pages() {
            return total_pages;
        }

        public void setTotal_pages(int total_pages) {
            this.total_pages = total_pages;
        }

        public List<Movie> getData() {
            return data;
        }

        public void setData(List<Movie> data) {
            this.data = data;
        }
    }

    public class Movie {
        String Title;
        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            this.Title = title;
        }
    }
}
