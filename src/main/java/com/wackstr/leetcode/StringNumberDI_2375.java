package com.wackstr.leetcode;

/*
2025-02-18
 */
public class StringNumberDI_2375 {
    public String smallestNumber(String pattern){
        int[] used = new int[10];
        for(int i = 1; i <= 9; i++){
            String seed = "" + i;
            String number = process(used, i, seed, 1, pattern);
            if (number != null) return number;
        }
        return null;
    }

    private String generateNumber(
            String current,
            int index,
            String pattern,
            int[] used) {
        if(index > pattern.length()) return current;

        boolean isIncrease = pattern.charAt(index - 1) == 'I';
        int currNumber = Integer.parseInt(current.substring(index - 1, index));

        if(isIncrease){
            for(int i = currNumber + 1; i <= 9; i++){
                String seq = process(used, i, current + i, index + 1, pattern);
                if (seq != null) return seq;
            }
        }else{
            for(int i = 1; i < currNumber; i++){
                String seq = process(used, i, current + i, index + 1, pattern);
                if (seq != null) return seq;
            }
        }
        return null;
    }

    private String process(int[] used, int i, String current, int index, String pattern) {
        if(used[i - 1] == 0){
            used[i - 1] = 1;
            String seq = generateNumber(
                    current,
                    index,
                    pattern,
                    used);
            if (seq != null) return seq;
            used[i - 1] = 0;
        }
        return null;
    }

    public static void main(String[] args) {
        String pattern = "IIIDIDDD";
        StringNumberDI_2375 sol = new StringNumberDI_2375();
        System.out.println(sol.smallestNumber(pattern));
    }
}
