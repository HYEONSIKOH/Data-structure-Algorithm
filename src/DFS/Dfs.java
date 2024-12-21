package DFS;


import java.util.ArrayList;
import java.util.List;

public class Dfs {
    List<List<Integer>> v = new ArrayList<>();
    List<Boolean> visited = new ArrayList<>();

    public Dfs(int n) {
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
        visited.set(x, true);
        System.out.print(x + " ");

        for (int i = 0; i < v.get(x).size(); i++) {
            int next_node = v.get(x).get(i);
            if (!visited.get(next_node)) {
                search(next_node);
            }
        }
    }
}
