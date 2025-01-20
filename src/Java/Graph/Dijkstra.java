package Java.Graph;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12978?language=java
 * [프로그래머스] 12978 - 배달
 */
public class Dijkstra {

    private class Pair implements Comparable<Pair> {
        int node;
        int cost;

        public Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    private static final Integer INF = 1000000000;
    List<List<Pair>> vec = new ArrayList<>();
    List<Integer> dist = new ArrayList<>();

    private final int V;

    public Dijkstra(int V) {
        this.V = V;

        for (int i = 0; i <= V; i++) {
            vec.add(new ArrayList<>());
            dist.add(INF);
        }
    }

    public void addEdge(int u, int v, int k) {
        vec.get(u).add(new Pair(v, k));
        vec.get(v).add(new Pair(u, k));
    }

    public void dijkstra() {
        int startNode = 1;
        dist.set(startNode, 0);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(startNode, dist.get(startNode)));

        /*
          PriorityQueue<Pair> priorityQueueLowest = new PriorityQueue<>(
              (a, b) -> Integer.compare(a.cost, b.cost)
          );
          이렇게 람다로 사용해도 되는 듯...
         */

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            for (Pair nextP : vec.get(p.node)) {
                int nextNode = nextP.node;
                int nextDist = p.cost + nextP.cost; // p.cost: 현재 노드까지의 비용, nextP.cost:현재 노드에서 다음 노드까지의 비용

                if (nextDist < dist.get(nextNode)) {
                    dist.set(nextNode, nextDist);
                    pq.add(new Pair(nextNode, nextDist));
                }
            }
        }
    }

    public int result(int K) {
        int res = 0;
        for (Integer i : dist) {
            if (i <= K) res++;
        }

        return res;
    }

    private void showDist(int startNode) {
        for (int i = 0; i < V; i++) {
            if (i == startNode) System.out.println("0");
            else if (dist.get(i).equals(INF)) System.out.println("INF");
            else System.out.println(dist.get(i));
        }
    }
}

class Solution {
    public int solution(int N, int[][] road, int K) {

        Dijkstra d = new Dijkstra(N);

        for (int[] r : road) { d.addEdge(r[0], r[1], r[2]); }

        d.dijkstra();

        return d.result(K);
    }
}
