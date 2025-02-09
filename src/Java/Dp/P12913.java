package Java.Dp;

// [프로그래머스] 12913 - 땅따먹기 Java
public class P12913 {
    int[][] dp;

    int getMaxGrade(int y, int x) {
        int maxGrade = 0;
        for (int i = 0; i < 4; i++) {
            if (x != i) {
                maxGrade = Math.max(maxGrade, dp[y-1][i]);
            }
        }

        return maxGrade;
    }

    int solution(int[][] land) {
        dp = land;

        for (int y = 1; y < land.length; y++) {
            for (int x = 0; x < 4; x++) {
                dp[y][x] += getMaxGrade(y, x);
            }
        }

        return getMaxGrade(land.length, 5);
    }
}
