package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
2025-03-30
 */
public class PartitionLabels_763 {

    /*
        We can use an array because of constraints
        If we were using more characters, we could use  Map<Char, int[]> for
        min/max and rest of the code will remain same
     */
    private static final int CHARS = 26;
    private static final int NULL = -1;
    private static final char ROOT = 'a';

    public List<Integer> partitionLabels(String s){

        int n = s.length(); // for convenience

        // track min and max index of each char
        int[] min = new int[CHARS];
        int[] max = new int[CHARS];
        // we will track if a char is updated in min array
        Arrays.fill(min, NULL);
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            int index = c - ROOT;
            // only update min on first encounter
            if(min[index] == NULL) min[index] = i;
            // update max on ever encounter
            max[index] = i;
        }
        /*
            A char is "open" at an index if we encountered it at an index less
            than or equal to current index and will still encounter it at a
            later index.

            Sweep denotes total chars open at the current index
            Consider "abac". Then sweep = {1,1,0,0}.

            So if sweep is 0 at an index, we can put an inclusive partition
            at that index
         */

        // first denote all the min and max occurrences
        int[] sweep = new int[n];
        for(int i = 0; i < CHARS; i++){
            if(min[i] != -1){
                sweep[min[i]]++;
                sweep[max[i]]--;
            }
        }
        // create a prefix sum to denote the sweep
        for(int i = 1; i < n; i++){
            sweep[i] += sweep[i-1];
        }

        /*
            At this point getting partition is trivial.
            Add a partition at every index ending where sweep[i] is 0
            Track a running variable to capture the length of each partition.
         */
        List<Integer> partitionSizes = new ArrayList<>();
        int currStart = -1;
        for(int i = 0; i < n; i++){
            if(sweep[i] == 0) {
                partitionSizes.add(i - currStart);
                currStart = i;
            }
        }
        return partitionSizes;
    }

    public static void main(String[] args) {
        String s = "eccbbbbdec";
        PartitionLabels_763 sol = new PartitionLabels_763();
        System.out.println(sol.partitionLabels(s));
    }
}
