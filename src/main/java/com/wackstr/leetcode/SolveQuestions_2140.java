package com.wackstr.leetcode;

/*
2025-04-01
 */
public class SolveQuestions_2140 {
    // this is a bottom up approach
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] times = new long[n];
        times[n - 1] = questions[n - 1][0];
        for(int i = n - 2; i >= 0; i--){
            int nextIndex = i + questions[i][1] + 1;
            long nextValue = nextIndex < n ? times[nextIndex] : 0;
            times[i] = Math.max(times[i + 1], questions[i][0] + nextValue);
        }
        return times[0];
    }

    private long topDown(int[][] questions) {
        long[] dp = new long[questions.length];
        int i = 0;
        return Math.max(
                questions[i][0] + points(i + questions[i][1] + 1, questions, dp),
                points(i + 1, questions, dp)
        );
    }

    private long points(int i, int[][] questions, long[] dp) {
        if(i >= questions.length) return 0;
        if(i == questions.length - 1) return questions[questions.length - 1][0];
        if(dp[i] != 0) return dp[i];

        long maxPoints = Math.max(
                questions[i][0] + points(i + questions[i][1] + 1, questions, dp),
                points(i + 1, questions, dp)
                );

        dp[i] = maxPoints;

        return maxPoints;
    }

    public static void main(String[] args) {
        int[][] questions = {{21,5},{92,3},{74,2},{39,4},{58,2},{5,5},{49,4},{65,3}};
        SolveQuestions_2140 sol = new SolveQuestions_2140();
        System.out.println(sol.mostPoints(questions));
    }
}
