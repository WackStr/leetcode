package com.wackstr.leetcode;

import java.util.ArrayDeque;

/*
2025-07-23
 */
public class RemoveSubstring_1717 {
    public int maximumGain(String s, int x, int y) {
        ArrayDeque<Character> queue = new ArrayDeque<>();
        int res = 0;
        int max = Math.max(x, y);
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == 'a' || c == 'b'){
                if(queue.isEmpty() || queue.peekLast() == c) queue.offer(c);
                else if((x >= y && c == 'b') || (x <= y && c == 'a')){
                    queue.pollLast();
                    res += max;
                }else queue.offer(c);
            }else if(!queue.isEmpty()){
                res += getScore(queue, x, y);
                queue.clear();
            }
        }
        if(!queue.isEmpty()) res += getScore(queue, x, y);
        return res;
    }

    private int getScore(ArrayDeque<Character> queue, int x, int y) {
        char c = queue.peek();
        int n = 0;
        while(!queue.isEmpty() && queue.peek() == c){
            queue.poll();
            n++;
        }
        return Math.min(n, queue.size()) * Math.min(x, y);
    }

    public static void main(String[] args) {
        String s = "aabbaaxybbaabb";
        int x = 5;
        int y = 4;
        RemoveSubstring_1717 sol = new RemoveSubstring_1717();
        System.out.println(sol.maximumGain(s, x, y));
    }
}
