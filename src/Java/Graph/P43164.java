package Java.Graph;

import java.util.*;

// [프로그래머스] 43164 - 여행경로
public class P43164 {
    int n;
    boolean[] visited;
    ArrayList<String> arr = new ArrayList<>();

    public void dfs(int cnt, String start, String dist, String[][] tickets) {
        if(cnt == n) {
            arr.add(dist);
            return;
        }

        for(int i = 0; i < n; i++) {
            if (!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                dfs(cnt + 1, tickets[i][1], dist + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }

    public String[] solution(String[][] tickets) {
        n = tickets.length;
        visited = new boolean[n + 1];

        dfs(0, "ICN", "ICN", tickets);

        Collections.sort(arr);

        return arr.get(0).split(" ");
    }

    public static void main(String[] args) {
        String[][] A1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        //String[][] A2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ICN"}, {"ATL", "ICN"}, {"ATL", "SFO"}};

        System.out.println(Arrays.toString(new P43164().solution(A1)));
        //System.out.println(Arrays.toString(new P43164().solution(A2)));
    }
}
