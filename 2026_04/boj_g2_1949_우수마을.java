import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_g2_1949_우수마을 {
    static int N;
    static int[] paper;
    // 트리구조로 이루어 져있고, 간선이 N-1 >> 최소 스패닝 트리 : 사이클 X
    static int[][] dp;

    static ArrayList<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 깊게 들어갔다가 나오면서 dp 저장하자
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        dp = new int[N + 1][2];
        paper = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            paper[i] = Integer.parseInt(st.nextToken());
        }

        adj = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        dfs(1);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    private static void dfs(int a) {
        visited[a] = true;

        dp[a][1] = paper[a];

        for (int next : adj[a]) {
            if (visited[next])
                continue;

            dfs(next);

            dp[a][0] += Math.max(dp[next][0], dp[next][1]);
            dp[a][1] += dp[next][0];
        }
    }
}
