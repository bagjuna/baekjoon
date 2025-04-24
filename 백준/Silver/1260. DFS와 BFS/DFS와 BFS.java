
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1260 DFS와 BFS
 */
public class Main {
    static int N;
    static ArrayList<Integer>[] numList;
    static boolean[] visited ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());
        numList = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            numList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            numList[v1].add(v2);
            numList[v2].add(v1);
        }
        for (int i = 1; i < N + 1; i++) {
            Collections.sort(numList[i]);
        }

        dfs(startNode);
        System.out.println();
        visited = new boolean[N + 1];
        bfs(startNode);
        System.out.println();
    }

    private static void dfs(int node) {
        System.out.print(node + " ");
        visited[node] = true;
        for (int i : numList[node]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int Node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(Node);
        visited[Node] = true;

        while (!queue.isEmpty()) {
            Integer now_node = queue.poll();
            System.out.print(now_node + " ");
            for(int i : numList[now_node]){
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }


}
