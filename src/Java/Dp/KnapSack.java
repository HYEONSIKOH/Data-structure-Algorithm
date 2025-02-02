package Java.Dp;

// [프로그래머스] 12907 - 거스름돈
// https://school.programmers.co.kr/learn/courses/30/lessons/12907?language=java
public class KnapSack {
    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int c: money) {
            for (int i = c; i <= n; i++ ) {
                dp[i] += dp[i - c] % 1000000007;
            }
        }

        return dp[n];
    }
}
