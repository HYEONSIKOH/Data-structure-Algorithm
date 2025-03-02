package Java.Dp;

// [프로그래머스] 43105 - 정수 삼각형
public class P43105 {
    final static int SIZE = 500;

    public int solution(int[][] triangle) {
        int[] dp = {triangle[0][0]};
        int height = triangle.length;

        for (int i = 1; i < height; i++) {
            int length = triangle[i].length;
            int[] temp = new int[length];

            for (int j = 0; j < length; j++) {
                int n = triangle[i][j];

                if (j == 0) { temp[j] = dp[j] + n; }
                else if (j == length - 1) {temp[j] = dp[j - 1] + n; }
                else {temp[j] = Math.max(dp[j - 1], dp[j]) + n; }
            }

            dp = temp;
            // dp 출력
            for (int n : dp) { System.out.print(n + " "); }
            System.out.println();
        }

        int max = -1;
        for (int n : dp) { max = Math.max(max, n); }

        return max;
    }

    public static void main(String[] args) {
        P43105 p = new P43105();
        int[][] triangle = {
            {7},
            {3, 8},
            {8, 1, 0},
            {2, 7, 4, 4},
            {4, 5, 2, 6, 5}
        };
        System.out.println(p.solution(triangle));
    }
}
