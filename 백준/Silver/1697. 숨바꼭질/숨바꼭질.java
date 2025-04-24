
import java.util.*;

public class Main {
    static int start;
    static int end;
    static boolean[] visited = new boolean[100_001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        start = sc.nextInt();
        end = sc.nextInt();
        bfs(start, 0);
    }

    public static void bfs(int position, int cnt) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{position, cnt});
        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            int pos = polled[0];
            int time = polled[1];
            if (pos == end) {
                System.out.println(time);
                return;
            }
            int[] nextMoves = {pos - 1, pos + 1, pos * 2};
            for (int next : nextMoves) {
                if (next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, time + 1});
                }
            }

        }


    }

}