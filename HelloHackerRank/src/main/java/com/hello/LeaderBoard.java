package com.hello;

import java.util.Arrays;

public class LeaderBoard {
    public static class Player implements Comparable<Player> {
        private int score;
        private int rank;

        public Player(int score, int rank) {
            this.score = score;
            this.rank = rank;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

//        @Override
        public int compareTo(Player player) {
            return player.score - this.score;
        }
    }

    public static int[] getRanks(int[] scores, int[] alice) {
        // Create items
        Player[] players = new Player[scores.length];
        for (int i = 0; i < scores.length; i++) {
            players[i] = new Player(scores[i], 0);
        }

        // Sort
        Arrays.sort(players);

        // Walk through to decide the rank
        for (int i = 0; i < scores.length; i++) {
            if (i == 0) {
                players[i].setRank(1);
            } else if (players[i].getScore() == players[i - 1].getScore()) {
                players[i].setRank(players[i - 1].getRank());
            } else if (players[i].getScore() < players[i - 1].getScore()) {
                players[i].setRank(players[i - 1].getRank() + 1);
            }
        }

        int[] ranks = new int[alice.length];

        // Check the new player
        int j = players.length - 1;
        for (int i = 0; i < alice.length; i++) {
            int score = alice[i];
            for (; j >= 0; j--) {
                if (score < players[j].getScore()) {
                    ranks[i] = players[j].getRank() + 1;
                    break;
                } else if (score == players[j].getScore()) {
                    ranks[i] = players[j].getRank();
                    break;
                }
            }

            if (j < 0) {
                ranks[i] = 1;
            }
        }

        return ranks;
    }

    public static void main(String[] args) {
        int[] scores = {100, 100, 50, 40, 40, 20, 10};
        int[] alice = {5, 25, 50, 120};

        int[] ranks = LeaderBoard.getRanks(scores, alice);
        System.out.println(ranks);
    }
}
