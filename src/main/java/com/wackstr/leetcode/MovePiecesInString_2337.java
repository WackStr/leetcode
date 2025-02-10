package com.wackstr.leetcode;

/*
2024-12-5
 */
public class MovePiecesInString_2337 {
    public boolean canChange(String start, String target) {
        int startPointer = 0;
        int targetPointer = 0;
        while(startPointer < start.length() || targetPointer < target.length()){
            while(startPointer < start.length() && start.charAt(startPointer) == '_') startPointer++;
            while(targetPointer < target.length() && target.charAt(targetPointer) == '_') targetPointer++;
            if(startPointer < start.length() && targetPointer < target.length() &&
                    !canRearrange(start, target, startPointer, targetPointer)) return false;
            startPointer++;
            targetPointer++;
        }
        return targetPointer >= target.length() &&
                startPointer >= start.length() &&
                targetPointer == startPointer;
    }

    private static boolean canRearrange(
            String start, String target,
            int startPointer, int targetPointer) {
        boolean sameChar = start.charAt(startPointer) == target.charAt(targetPointer);
        boolean canGoLeft = startPointer >= targetPointer && start.charAt(startPointer) == 'L';
        boolean canGoRight = startPointer <= targetPointer && start.charAt(startPointer) == 'R';
        return  sameChar && (canGoLeft || canGoRight);
    }

    public boolean canChangeParked(String start, String target) {
        int startPointer = 0;
        int targetPointer = 0;
        while(startPointer < start.length() && start.charAt(startPointer) == '_') startPointer++;
        while(targetPointer < target.length() && target.charAt(targetPointer) == '_') targetPointer++;


        while(startPointer < start.length() && targetPointer < target.length()){
            if(!canRearrange(start, target, startPointer, targetPointer)) return false;
            startPointer++;
            targetPointer++;
            while(startPointer < start.length() && start.charAt(startPointer) == '_') startPointer++;
            while(targetPointer < target.length() && target.charAt(targetPointer) == '_') targetPointer++;
        }
        return targetPointer == target.length() &&
                startPointer == start.length();
    }

    public static void main(String[] args) {
        String start = "_L__R__R_L";
        String target = "L______RR_";
        MovePiecesInString_2337 sol = new MovePiecesInString_2337();
        System.out.println(sol.canChange(start, target));
    }
}
