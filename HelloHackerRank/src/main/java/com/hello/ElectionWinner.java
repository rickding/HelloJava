package com.hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElectionWinner {
    public static String electionWinner(String[] votes) {
        if (votes == null || votes.length <= 0) {
            return null;
        }

        // Count the vote
        Map<String, Integer> voteCountMap = new HashMap<String, Integer>();
        int maxCount = 0;
        for (String vote : votes) {
            String tmp = vote.trim();
            int count = 1 + (voteCountMap.containsKey(tmp) ? voteCountMap.get(tmp) : 0);
            voteCountMap.put(tmp, count);

            // Remember the max count
            if (maxCount < count) {
                maxCount = count;
            }
        }

        // Get the candidates with max count votes
        List<String> candidateList = new ArrayList<String>();
        for (Map.Entry<String, Integer> voteCount : voteCountMap.entrySet()) {
            if (voteCount.getValue() == maxCount) {
                candidateList.add(voteCount.getKey());
            }
        }

        if (candidateList.size() <= 0) {
            return null;
        } else if (candidateList.size() == 1) {
            return candidateList.get(0);
        }

        // Sort alphabetically and get the last one
        String[] candidatesArr = new String[candidateList.size()];
        candidateList.toArray(candidatesArr);
        Arrays.sort(candidatesArr);
        return candidatesArr[candidatesArr.length - 1];
    }
}
