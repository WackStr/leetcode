package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-07-13
 */
public class PlayersTrainers_2410 {
    public int matchPlayersAndTrainers(int[] players, int[] trainers){
        int i = 0;
        int j = 0;
        int cnt = 0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        while(i < players.length && j < trainers.length){
            while(j < trainers.length && trainers[j] < players[i]) j++;
            if(j < trainers.length){
                j++;
                i++;
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] players = {4,7,9};
        int[] trainers = {8,2,5,8};
        PlayersTrainers_2410 sol = new PlayersTrainers_2410();
        System.out.println(sol.matchPlayersAndTrainers(players, trainers));
    }
}
