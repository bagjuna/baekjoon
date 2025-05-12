
import java.util.*;

public class Main {
    static boolean[][] map;
    static boolean[][] visited;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;
    static int cnt = 0;
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new boolean[N][M];
        visited = new boolean[N][M];
        int Num = sc.nextInt();
        for (int i = 0; i < Num; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            map[r - 1][c - 1] = true;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] && !visited[i][j]) {

                    bfs(i, j);
                }
            }
        }

        System.out.println(max);
    }

    static void bfs(int i, int j) {
        cnt = 1;
        Queue<Edge> q = new ArrayDeque();

        q.add(new Edge(i, j));
        visited[i][j] = true;
        while (!q.isEmpty()) {
            Edge temp = q.poll();
            for (int k = 0; k < 4; k++) {
                int xx = temp.numX + dx[k];
                int yy = temp.numY + dy[k];
                if (xx < 0 || yy < 0 || xx >= N || yy >= M) continue;
                if (!visited[xx][yy] && map[xx][yy]) {
                    q.add(new Edge(xx, yy));
                    visited[xx][yy] = true;
                    cnt++;
                }

            }

        }
        max = Math.max(max, cnt);


    }


    static class Edge {
        int numX;
        int numY;


        Edge(int numX, int numY) {
            this.numX = numX;
            this.numY = numY;
        }
    }
}