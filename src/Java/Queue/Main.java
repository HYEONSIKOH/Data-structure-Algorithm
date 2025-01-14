package Java.Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue q = new Queue();

        for (int i = 0; i < N; i++) {
            String cmd  = br.readLine();

            // 문자열안에 어떤 명령이 포함되어 있는지 확인하는 람다식
            Predicate<String> isPush = s -> s.contains("push");
            Predicate<String> isPop = s -> s.contains("pop");
            Predicate<String> isSize = s -> s.contains("size");
            Predicate<String> isEmpty = s -> s.contains("empty");
            Predicate<String> isFront = s -> s.contains("front");
            Predicate<String> isBack = s -> s.contains("back");

            if (isPush.test(cmd)) {
                StringTokenizer tokenizer = new StringTokenizer(cmd);
                tokenizer.nextToken();
                q.enqueue(Integer.parseInt(tokenizer.nextToken()));
            } else if (isPop.test(cmd)) {
                System.out.println(q.dequeue());
            } else if (isSize.test(cmd)) {
                System.out.println(q.size());
            } else if (isEmpty.test(cmd)) {
                System.out.println(q.isEmpty() ? 1 : 0);
            } else if (isFront.test(cmd)) {
                System.out.println(q.peek());
            } else if (isBack.test(cmd)) {
                System.out.println(q.back());
            }
        }
    }
}

/*
    push X: 정수 X를 큐에 넣는 연산이다.
    pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    size: 큐에 들어있는 정수의 개수를 출력한다.
    empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
    front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
