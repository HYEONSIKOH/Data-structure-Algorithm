package Java.Dp;

import java.util.*;

// [프로그래머스] 42895 - N으로 표현
public class P42895 {
    public int solution(int N, int number) {
        int result = -1;
        List<Set<Integer>> dp = new ArrayList<>();

        for (int i = 0; i < 9; i++) { dp.add(new HashSet<>()); }

        dp.get(1).add(N);

        for (int idx = 2; idx <= 8; idx++) {
            for (int i = 1; i < idx; i++) {
                for (int A: dp.get(i)) {
                    for (int B: dp.get(idx - i)) {
                        dp.get(idx).add(A + B);
                        dp.get(idx).add(A - B);
                        dp.get(idx).add(A * B);
                        if (B != 0) {
                            dp.get(idx).add(A / B);
                        }
                    }
                }
            }
            dp.get(idx).add(Integer.parseInt(String.valueOf(N).repeat(idx)));
        }

        for (int i = 1; i < 9; i++) {
            if (dp.get(i).contains(number)) {
                result = i;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        P42895 p = new P42895();
        int N = 6;
        int number = 5;
        System.out.println(p.solution(N, number));
    }
}
