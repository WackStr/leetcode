package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-05-27 3121
 */
public class SpecialCharacters_3121 {
    public int numberOfSpecialChars(String word) {

        int lowercase[]=new int[26];
        int uppercase[]=new int[26];
        Arrays.fill(lowercase,-1);
        Arrays.fill(uppercase,-1);
        int count=0;
        for(int i=0;i<word.length();i++)
        {
            char ch=word.charAt(i);
            if(ch>='a' && ch<='z')
            {
                lowercase[ch-'a']=i;
            }
            else{
                int index= ch-'A';
                if(uppercase[index]==-1)
                {
                    uppercase[index]=i;
                }
            }
        }
        for(int i=0;i<26;i++)
        {
            if(lowercase[i]!=-1 && uppercase[i]!=-1 && lowercase[i]<uppercase[i])
            {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String word = "dcbCC";
        SpecialCharacters_3121 sol = new SpecialCharacters_3121();
        System.out.println(sol.numberOfSpecialChars(word));
    }
}
