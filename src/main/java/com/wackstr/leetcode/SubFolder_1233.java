package com.wackstr.leetcode;

import java.util.*;

/*
2025-07-19
 */
public class SubFolder_1233 {
    public List<String> removeSubfolders(String[] folder) {
        Set<String> dirSet = new HashSet<>();
        List<String> res = new ArrayList<>();

        Collections.addAll(dirSet, folder);

        for (String dir : folder) {
            res.add(dir);
            for (int i = 0; i < dir.length(); i++) {
                if (dir.charAt(i) == '/' && dirSet.contains(dir.substring(0, i))) {
                    res.remove(res.size() - 1);
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[] folder ={"/a/b/c","/a/b/ca","/a/b/d"};
        SubFolder_1233 sol = new SubFolder_1233();
        System.out.println(sol.removeSubfolders(folder));
    }
}
