package com.hello;

import java.util.*;

/**
 * Hello world!
 */
public class BestHotel {
    public static void main(String[] args) {
        System.out.println("Hello Best Hotel!");
        best_hotels();
    }

    private static class Hotel {
        private long id = 0;
        private ArrayList<Integer> scoreList = new ArrayList<Integer>();
        private int totalScore = 0;

        public Hotel(long id) {
            this.id = id;
        }

        public long getId() {
            return id;
        }

        public void addScore(int score) {
            this.scoreList.add(score);
            this.totalScore += score;
        }

        public double getAverageScore() {
            if (scoreList.size() <= 0) {
                return 0;
            }
            return (double) totalScore / scoreList.size();
        }
    }

    public static class HotelComparator implements Comparator<Hotel> {
//        @Override
        public int compare(Hotel o1, Hotel o2) {
            int ret = ((Double)o2.getAverageScore()).compareTo(o1.getAverageScore());
            if (ret == 0) {
                ret = (int) (o1.getId() - o2.getId());
            }
            return ret;
        }
    }

    static void best_hotels() {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        HashMap<Long, Hotel> idScoresMap = new HashMap<Long, Hotel>();
        while (n-- > 0) {
            long id = sc.nextLong();
            int score = sc.nextInt();

            Hotel scores = idScoresMap.get(id);
            if (scores == null) {
                scores = new Hotel(id);
                idScoresMap.put(id, scores);
            }

            scores.addScore(score);
        }
        sc.close();

        Hotel[] hotels = new Hotel[idScoresMap.size()];
        idScoresMap.values().toArray(hotels);
        Arrays.sort(hotels, new HotelComparator());

        for (Hotel hotel : hotels) {
            System.out.println(hotel.getId());
        }
    }
}
