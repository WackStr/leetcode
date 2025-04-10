package com.wackstr.leetcode;

/*
2025-04-10
 */
public class PowerfulIntegers_2999 {
    public long numberOfPowerfulInt(
            long start,
            long finish,
            int limit,
            String s
    ) {
        String start_ = Long.toString(start - 1);
        String finish_ = Long.toString(finish);
        return calculate(finish_, s, limit) - calculate(start_, s, limit);
    }

    private long calculate(String x, String s, int limit) {
        if (x.length() < s.length()) {
            return 0;
        }
        if (x.length() == s.length()) {
            return x.compareTo(s) >= 0 ? 1 : 0;
        }

        String suffix = x.substring(x.length() - s.length());
        long count = 0;
        int preLen = x.length() - s.length();

        for (int i = 0; i < preLen; i++) {
            int digit = x.charAt(i) - '0';
            if (limit < digit) {
                count += (long) Math.pow(limit + 1, preLen - i);
                return count;
            }
            count +=
                    (long) (digit) * (long) Math.pow(limit + 1, preLen - 1 - i);
        }
        if (suffix.compareTo(s) >= 0) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        long start = 1000;
        long finish = 2000;
        int limit = 4;
        String s = "3000";
        PowerfulIntegers_2999 sol = new PowerfulIntegers_2999();
        System.out.println(sol.numberOfPowerfulInt(
                start, finish, limit, s
        ));
    }

}
