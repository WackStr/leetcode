package com.wackstr.leetcode;

/*
2025-01-05
 */
public class ShiftingLettersII_2381 {

    private static final int RANGE = 'z' - 'a' + 1;

    public String shiftingLetters(String s, int[][] shifts){
        int[] finalShifts = new int[s.length()];
        for(int[] shift : shifts){
            int delta = shift[2] == 0 ? -1 : 1;
            applyDelta(finalShifts, shift[0], delta);
            if(shift[1] + 1 < s.length()) applyDelta(finalShifts, shift[1] + 1, -delta);
        }

        int currSum = finalShifts[0];
        for(int i = 1; i < finalShifts.length; i++){
            currSum += finalShifts[i];
            if(currSum == RANGE || currSum == -RANGE) currSum = 0;
            finalShifts[i] = currSum % RANGE;
        }
        return transformStringByShift(s, finalShifts);
    }

    private void applyDelta(int[] finalShifts, int i, int delta) {
        finalShifts[i] += delta;
        if(finalShifts[i] == RANGE || finalShifts[i] == -RANGE) finalShifts[i] = 0;
    }

    private String transformStringByShift(String s, int[] finalShifts) {
        StringBuilder sb = new StringBuilder(s.length());
        for(int i = 0; i < s.length(); i++) {
            char newChar = (char) ((s.charAt(i) + finalShifts[i]));
            if(newChar < 'a') newChar += RANGE;
            else if(newChar > 'z') newChar -= RANGE;
            sb.append(newChar);
        }
        return sb.toString();
    }

    private void applyShift(int[] shift, int[] finalShifts) {
        int start = shift[0], end = shift[1], delta = shift[2] == 0 ? -1 : 1;
        for (int i = start; i <= end; i++) {
            finalShifts[i] += delta;
            if(finalShifts[i] == RANGE || finalShifts[i] == -RANGE) finalShifts[i] = 0;
        }
    }

    public static void main(String[] args) {
        String s = "dztz";
        int[][] shifts = {{0,0,0}, {1,1,1}};
        ShiftingLettersII_2381 sol = new ShiftingLettersII_2381();
        System.out.println(sol.shiftingLetters(s, shifts));
    }
}
