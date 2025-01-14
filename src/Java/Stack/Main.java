package Java.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack st = new Stack(N);

        for (int i = 0; i < N; i++) {
            String command  = br.readLine();

            // 문자열안에 push가 포함되어 있는지 확인하는 람다식
            Predicate<String> isPush = s -> s.contains("push");
            Predicate<String> isPop = s -> s.contains("pop");
            Predicate<String> isSize = s -> s.contains("size");
            Predicate<String> isEmpty = s -> s.contains("empty");
            Predicate<String> isTop = s -> s.contains("top");

            if (isPush.test(command)) {
                StringTokenizer tokenizer = new StringTokenizer(command);
                tokenizer.nextToken();
                int num = Integer.parseInt(tokenizer.nextToken());
                st.push(num);
            } if (isPop.test(command)) {
                System.out.println(st.peak());
                st.pop();
            } if (isSize.test(command)) {
                System.out.println(st.size());
            } if (isEmpty.test(command)) {
                System.out.println(st.isEmpty() ? 1 : 0);
            } if (isTop.test(command)) {
                System.out.println(st.peak());
            }
        }


    }
}