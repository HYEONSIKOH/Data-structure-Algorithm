package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer cmd = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(cmd.nextToken());
        int N = Integer.parseInt(cmd.nextToken());
        int V = Integer.parseInt(cmd.nextToken());

        Dfs dfs = new Dfs(M);

        for (int i = 0; i < N; i++) {
            StringTokenizer nodes = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(nodes.nextToken());
            int y = Integer.parseInt(nodes.nextToken());

            dfs.addEdge(x, y);
        }

        dfs.search(V);
    }
}
