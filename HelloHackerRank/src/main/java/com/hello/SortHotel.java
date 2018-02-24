package com.hello;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SortHotel {
    static int[] sort_hotels(String keywords, int[] hotel_ids, String[] reviews) {
        if (keywords == null || keywords.trim().length() <= 0
                || hotel_ids == null || hotel_ids.length <= 0
                || reviews == null || reviews.length <= 0
                || hotel_ids.length != reviews.length) {
            return null;
        }

        // Split the keywords
        final String[] keywordArr = keywords.trim().toLowerCase()
                .replace("-", "")
                .split(" ");
        if (keywordArr == null || keywordArr.length <= 0) {
            return null;
        }
        Set<String> keywordSet = new HashSet<String>(keywordArr.length){{
            addAll(Arrays.asList(keywordArr));
        }};

        // Loop to check the hotels and reviews
        Map<Integer, Hotel> hotelMap = new HashMap<Integer, Hotel>();
        for (int i = 0; i < hotel_ids.length; i++) {
            int id = hotel_ids[i];

            // Find hotel or create a new one
            Hotel hotel = hotelMap.get(id);
            if (hotel == null) {
                hotel = new Hotel(id);
                hotelMap.put(id, hotel);
            }

            // Check review
            String review = reviews[i];
            if (review == null || review.trim().length() <= 0) {
                continue;
            }

            // Format review
            review = review.trim().toLowerCase()
                    .replace(",", " ")
                    .replace(".", " ")
                    .replace("!", " ")
                    .replace("-", "");
            String[] reviewArr = review.split(" ");
            if (reviewArr == null || reviewArr.length <= 0) {
                continue;
            }

            // Loop the review
            for (String tmp : reviewArr) {
                if (tmp != null && tmp.trim().length() > 0 && keywordSet.contains(tmp.trim())) {
                    hotel.reviewCount++;
                }
            }
        }

        // Sort hotels
        Hotel[] hotelArr = new Hotel[hotelMap.size()];
        hotelMap.values().toArray(hotelArr);
        Arrays.sort(hotelArr);

        // Return the ids
        int[] idArr = new int[hotelArr.length];
        for (int i = 0; i < hotelArr.length; i++) {
            idArr[i] = hotelArr[i].id;
        }
        return idArr;
    }

    public static class Hotel implements Comparable {
        int id;
        int reviewCount;

        public Hotel(int id) {
            this.id = id;
            this.reviewCount = 0;
        }

        public int compareTo(Object o) {
            if (o instanceof Hotel) {
                Hotel obj = (Hotel) o;
                int diff = obj.reviewCount - this.reviewCount;
                if (diff == 0) {
                    diff = this.id - obj.id;
                }
                return diff == 0 ? 0 : (diff > 0 ? 1 : -1);
            }
            return 0;
        }
    }
}
