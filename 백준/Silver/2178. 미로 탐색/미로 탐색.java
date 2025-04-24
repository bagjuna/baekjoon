import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 2178번
 * 미로 탐색
 */
public class Main {
    // 상하좌우 이동을 위한 방향 벡터
    static int[] dx = {0, 1, 0, -1}; // x 방향: 우, 하, 좌, 상
    static int[] dy = {1, 0, -1, 0}; // y 방향: 우, 하, 좌, 상
    static boolean[][] visited;
    static int[][] A;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                A[i][j] = temp.charAt(j) - '0'; 
            }
        }

        BFS(0, 0); 
        System.out.println(A[N - 1][M - 1]); 
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (A[x][y] == 1 && !visited[x][y]) {
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1; 
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }
}