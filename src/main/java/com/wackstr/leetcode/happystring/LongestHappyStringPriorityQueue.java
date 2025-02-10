package com.wackstr.leetcode.happystring;

import java.util.PriorityQueue;
import java.util.Stack;

public class LongestHappyStringPriorityQueue extends LongestHappyString {

    @Override
    public String longestDiverseString(int a, int b, int c) {

        StringBuilder ans = new StringBuilder();
        PriorityQueue<StringRepresentation> queue =
                initializePriorityQueue(a, b, c);

        Stack<StringRepresentation> runningSet = new Stack<>();

        String lastChar = "";
        String lastTwoChar = "";
        while(!queue.isEmpty()){
            StringRepresentation curr = queue.poll();
            if(curr.cnt() > 0) {
                boolean canAddTwo = curr.cnt() >= 2 && !lastChar.equals(curr.str());
                boolean canAddOne = curr.cnt() >= 1 &&
                        !lastTwoChar.equals(String.format("%s%s", curr.str(), curr.str()));
                if (canAddTwo) {
                    String add = String.format("%s%s", curr.str(), curr.str());
                    ans.append(add);
                    queue.add(new StringRepresentation(curr.str(), curr.cnt() - 2));
                    while(!runningSet.isEmpty()){
                        queue.add(runningSet.pop());
                    }
                    lastTwoChar = add;
                    lastChar = curr.str();
                }else if(canAddOne){
                    String add = curr.str();
                    ans.append(add);
                    queue.add(new StringRepresentation(curr.str(), curr.cnt() - 1));
                    while(!runningSet.isEmpty()){
                        queue.add(runningSet.pop());
                    }
                    lastChar = add;
                    if(lastTwoChar.isEmpty()){
                        lastTwoChar = add;
                    }else if (lastTwoChar.length() == 1){
                        lastTwoChar = lastTwoChar + add;
                    }else{
                        lastTwoChar = lastTwoChar.substring(1) + add;
                    }
                }else{
                    runningSet.add(curr);
                }
            }else{
                break;
            }
        }
        return ans.toString();
    }

}
