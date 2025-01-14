package Java.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bfs {
    List<List<Integer>> v = new ArrayList<>();
    List<Boolean> visited = new ArrayList<>();
    Queue<Integer> q = new LinkedList<>();

    public Bfs(int n) {
        for (int i = 0; i <= n; i++) {
            v.add(new ArrayList<>());
            visited.add(false);
        }
    }

    public void addEdge(int x, int y) {
        v.get(x).add(y);
        v.get(y).add(x);
    }


    public void search(int x) {
        for (List<Integer> integers : v) {
            integers.sort(null);
        }
        q.add (x);

        // Queue가 비어있을 때까지 반복
        while(!q.isEmpty()) {
            int node = q.poll();

            if (!visited.get(node)) {
                visited.set(node, true);
                System.out.print(node + " ");
            }

            for (int i = 0; i < v.get(node).size(); i++) {
                int nextNode = v.get(node).get(i);

                if (!visited.get(nextNode)) { q.add(nextNode); }
            }
        }
    }

}
