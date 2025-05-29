import java.util.*;

public class Main {
    static int n, m;
    static char[][] grid;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int rx , ry , bx , by ;
    public static void main(String[] args) {
       // 백준 입력값 처리
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                if (line.charAt(j) == 'R') {
                    rx = i; // 빨간 구슬의 행 위치
                    ry = j; // 빨간 구슬의 열 위치
                } else if (line.charAt(j) == 'B') {
                    bx = i; // 파란 구슬의 행 위치
                    by = j; // 파란 구슬의 열 위치
                }
                grid[i][j] = line.charAt(j);
            }

        }

        System.out.println(bfs());
        
    }

    static int bfs() {

        // queue에 시작점 예약 (red좌표, blue좌표, cnt)
        Queue<State> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        State start = new State(rx, ry, bx, by, 0);
        q.add(start);
        visited.add(start.forKey());

        // while queue
        while (!q.isEmpty()) {
            // 현재 상태 방문
            State cur = q.poll();
            // if cnt > 10 이면 return 0
            if (cur.cnt > 10) return 0;
            // red가 구멍에 빠졌으면 return 1
            if (grid[cur.rx][cur.ry] == 'O') return 1;

            // 다음 상태 예약
            for (int dir = 0; dir < 4; dir++) {
                // move() 함수를 통해 다음 위치 계산
                int[] nextRed = move(cur.rx, cur.ry, dir);
                int[] nextBlue = move(cur.bx, cur.by, dir);

                // if blue가 구멍에 빠지면 continue
                if (grid[nextBlue[0]][nextBlue[1]] == 'O') continue;

                // 만약 red, blue 위치가 같으면 조정
                if (nextRed[0] == nextBlue[0] && nextRed[1] == nextBlue[1]) {
                    int redDist = Math.abs(nextRed[0] - cur.rx) + Math.abs(nextRed[1] - cur.ry);
                    int blueDist = Math.abs(nextBlue[0] - cur.bx) + Math.abs(nextBlue[1] - cur.by);
                    if (redDist > blueDist) {
                        nextRed[0] -= dx[dir];
                        nextRed[1] -= dy[dir];
                    } else {
                        nextBlue[0] -= dx[dir];
                        nextBlue[1] -= dy[dir];
                    }
                }

                // 방문 여부 확인 후 예약과 방문 표시
                State nextState = new State(nextRed[0], nextRed[1], nextBlue[0], nextBlue[1], cur.cnt + 1);
                if (!visited.contains(nextState.forKey())) {
                    visited.add(nextState.forKey());
                    q.add(nextState);
                }
            }
        }

        return 0;
    }



   static int[] move(int x, int y, int dir) {
        int nx = x, ny = y;
        while (true) {
            nx += dx[dir];
            ny += dy[dir];
            if (grid[nx][ny] == '#') {
                nx -= dx[dir];
                ny -= dy[dir];
                break;
            }
            if (grid[nx][ny] == 'O') {
                break;
            }
        }
        return new int[]{nx, ny};
    }

    static class State {
        int rx, ry, bx, by, cnt;

        State(int rx, int ry, int bx, int by, int cnt) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }

        public String forKey() {
            return rx + "-" + ry + "-" + bx + "-" + by;
        }
    }
}