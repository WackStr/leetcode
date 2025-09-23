package com.wackstr.leetcode;

/*
2025-09-23
 */
public class CompareVersion_165 {
    public int compareVersion(String version1, String version2){
        int l = 0;
        int r = 0;
        int leftVersion;
        int rightVersion;
        while(l < version1.length() || r < version2.length()) {
            leftVersion = 0;
            rightVersion = 0;
            while (l < version1.length() && version1.charAt(l) != '.') {
                leftVersion *= 10;
                leftVersion += version1.charAt(l) - '0';
                l++;
            }
            while (r < version2.length() && version2.charAt(r) != '.') {
                rightVersion *= 10;
                rightVersion += version2.charAt(r) - '0';
                r++;
            }
            if (leftVersion < rightVersion) return -1;
            else if (leftVersion > rightVersion) return 1;
            r++;
            l++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String version1 = "1.01";
        String version2 = "1.001";
        CompareVersion_165 sol = new CompareVersion_165();
        System.out.println(sol.compareVersion(version1, version2));
    }
}
