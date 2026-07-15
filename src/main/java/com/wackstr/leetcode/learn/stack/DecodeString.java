package com.wackstr.leetcode.learn.stack;

import java.util.ArrayDeque;

/*
2026-07-15
 */
public class DecodeString {

    public String decodeString(String s) {
        int n = s.length();
        StringBuilder str = new StringBuilder();
        StringBuilder num = new StringBuilder();
        ArrayDeque<String> commands = new ArrayDeque<>();
        int left = 0;
        while(left < n){
            char c = s.charAt(left);
            if(c <= '9'){
                if(!str.isEmpty()){
                    commands.offerLast(str.toString());
                    str = new StringBuilder();
                }
                num.append(c);
            }else if(c >= 'a'){
                str.append(c);
            }else if(c == '['){
                commands.offerLast(num.toString());
                num = new StringBuilder();
            }else {
                // we reached ']' this adds a string
                if (!str.isEmpty()) {
                    commands.offerLast(str.toString());
                    str = new StringBuilder();
                }
                StringBuilder curr = new StringBuilder(commands.pollLast());
                String nextCommand = commands.peekLast();
                // concatenate all character commands at top
                while (nextCommand.charAt(0) >= 'a') {
                    nextCommand = commands.pollLast();
                    curr.insert(0, nextCommand);
                    nextCommand = commands.peekLast();
                }
                nextCommand = commands.pollLast();
                // we will have a number repeater here
                int repeat = 0;
                for (int i = 0; i < nextCommand.length(); i++) {
                    repeat *= 10;
                    repeat += nextCommand.charAt(i) - '0';
                }
                StringBuilder builder = new StringBuilder();
                while (repeat > 0) {
                    builder.append(curr);
                    repeat--;
                }
                commands.offerLast(builder.toString());
            }
            left++;
        }
        // handle any trailing string
        if(!str.isEmpty()) commands.offerLast(str.toString());
        // only left with string commands that should be concatenated
        StringBuilder res = new StringBuilder();
        while(!commands.isEmpty()) res.append(commands.pollFirst());
        return res.toString();
    }



    public static void main(String[] args) {
        String[][] testCases ={
                {"3[a]2[bc]", "aaabcbc"},
                {"3[a2[c]]", "accaccacc"},
                {"2[abc]3[cd]ef", "abcabccdcdcdef"},
                {"abc3[cd]xyz", "abccdcdcdxyz"},
                {"3[z]2[2[y]pq4[2[jk]e1[f]]]ef", "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef"}
        };
        //System.out.println("0 = " + ((int)'0')+"; 9 = " + ((int)'9')  + "; a = " + ((int) 'a') + "; [ = " + ((int)'[') + "; ] = " + ((int)']') + ";");
        DecodeString sol = new DecodeString();
        int passed = 0;
        for (String[] testCase : testCases) {
            String decoded =sol.decodeString(testCase[0]);
            if(decoded.equals(testCase[1])){
                System.out.println("PASSED " + testCase[0] + ". Expected output of " + testCase[1]);
                passed++;
            }else{
                System.out.println("FAILED " + testCase[0] + ". Expected = " + testCase[1] + ". Actual = " + decoded);
            }
        }
        System.out.println("==========");
        System.out.println("Passed = " + passed + "; FAILED = " + (testCases.length - passed)+ ".");
    }
}
