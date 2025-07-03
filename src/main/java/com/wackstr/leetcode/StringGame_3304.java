package com.wackstr.leetcode;

/*
2025-07-03
 */
public class StringGame_3304 {

    private static final String lookup = "abbcbccdbccdcddebccdcddecddedeefbccdcddecddedeefcddedeefdeefeffgbccdcddecddedeefcddedeefdeefeffgcddedeefdeefeffgdeefeffgeffgfgghbccdcddecddedeefcddedeefdeefeffgcddedeefdeefeffgdeefeffgeffgfgghcddedeefdeefeffgdeefeffgeffgfgghdeefeffgeffgfggheffgfgghfgghghhibccdcddecddedeefcddedeefdeefeffgcddedeefdeefeffgdeefeffgeffgfgghcddedeefdeefeffgdeefeffgeffgfgghdeefeffgeffgfggheffgfgghfgghghhicddedeefdeefeffgdeefeffgeffgfgghdeefeffgeffgfggheffgfgghfgghghhideefeffgeffgfggheffgfgghfgghghhieffgfgghfgghghhifgghg";

    public char kthCharacter(int k){
        return lookup.charAt(k-1);
    }

    public char kthCharacterCalculated(int k) {
        int ans = 0;
        int t;
        while (k != 1) {
            t = 31 - Integer.numberOfLeadingZeros(k);
            if ((1 << t) == k) {
                t--;
            }
            k = k - (1 << t);
            ans++;
        }
        return (char) ('a' + ans);
    }


    public String generateString(int k){
        int currLength = 1;
        char[] c = new char[k];
        c[0] = 'a';
        while(currLength < k){
            for(int i=0; i < currLength && i + currLength < k; i++){
                c[i+currLength] = (char)(c[i]+1);
            }
            currLength *= 2;
        }
        return new String(c);
    }
}
