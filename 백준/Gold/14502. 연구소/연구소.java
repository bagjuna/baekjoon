
import java.util.*;
import java.io.*;


public class Main {
    static final int dx[] = {0, 0, 1, -1};  
    static final int dy[] = {1, -1, 0, 0};  
    static int originMap[][];
    static int N, M;
    static int maxVal = Integer.MIN_VALUE; 

    public static void main(String[] args) throws IOException {
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        originMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                originMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(maxVal);
    }

    static void dfs(int wallCnt) {
        if (wallCnt == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (originMap[i][j] == 0) {
                    originMap[i][j] = 1;
                    dfs(wallCnt + 1);
                    originMap[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (originMap[i][j] == 2) {
                    q.add(new Node(i, j));
                }
            }
        }

        int copyMap[][] = new int[N][M];

        for (int i = 0; i < N; i++) {
            copyMap[i] = originMap[i].clone();
        }

        // BFS 탐색 시작
        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (copyMap[nx][ny] == 0) {
                        q.add(new Node(nx, ny));
                        copyMap[nx][ny] = 2;
                    }
                }

            }
        }

        funcSafe(copyMap);

    }

    static void funcSafe(int[][] copyMap) {
        int safeZone = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    safeZone++;
                }
            }
        }

        if (maxVal < safeZone) {
            maxVal = safeZone;
        }

    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }

}