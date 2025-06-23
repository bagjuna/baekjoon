
import java.util.*;

public class Main {
    static int N, M;
    // 부메랑 방향 (중심 기준)
    static int[] dx = {0, 1, 0, -1, 0}; // 아래, 오른쪽, 위, 왼쪽
    static int[] dy = {1, 0, -1, 0, 1}; // 아래, 오른쪽, 위, 왼쪽

    static int[][] map;
    static boolean[][] visited;
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dfs(0, 0, 0);

        System.out.println(max);

    }

    static void dfs(int x, int y, int sum) {
        if (y == M) {
            y = 0;
            x++;
        }

        if (x == N) {
            max = Math.max(max, sum);
            return;
        }

        int cx = x;
        int cy = y;

        if (!visited[x][y]) {
            for (int i = 0; i < 4; i++) {

                int ax = x + dx[i];
                int ay = y + dy[i];
                int bx = x + dx[i+1];
                int by = y + dy[i+1];


                if (valid(cx, cy) || valid(ax, ay) || valid(bx, by)) continue;
                if (visited[cx][cy] || visited[ax][ay] || visited[bx][by]) continue;


                visited[cx][cy] = visited[ax][ay] = visited[bx][by] = true;
                int power = map[cx][cy] * 2 + map[ax][ay] + map[bx][by];
                dfs(x, y + 1, sum + power);

                visited[cx][cy] = visited[ax][ay] = visited[bx][by] = false;
            }
        }

        dfs(x, y + 1, sum);

    }

    static boolean valid(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }

}