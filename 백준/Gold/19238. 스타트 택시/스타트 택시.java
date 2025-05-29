import java.util.*;
import java.io.*;

public class Main {
    static int N, M, fuel;
    static int[][] map;
    static Taxi taxi;
    static List<Passenger> passengers = new ArrayList<>();

    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        // 1. 기본 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        // 2. 지도 입력
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 3. 택시 시작 위치
        st = new StringTokenizer(br.readLine());
        int taxiX = Integer.parseInt(st.nextToken()) - 1;
        int taxiY = Integer.parseInt(st.nextToken()) - 1;
        taxi = new Taxi(taxiX, taxiY);

        // 4. 승객 정보
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken()) - 1;
            int sy = Integer.parseInt(st.nextToken()) - 1;
            int dx = Integer.parseInt(st.nextToken()) - 1;
            int dy = Integer.parseInt(st.nextToken()) - 1;
            passengers.add(new Passenger(sx, sy, dx, dy));
        }


        while (!passengers.isEmpty()) {
            // 1. 가장 가까운 승객 찾기
            Passenger p = findNearestPassenger();
            if (p == null) {
                System.out.println(-1);
                return;
            }

            // 2. 승객 태우러 이동
            int[][] toPassenger = bfs(taxi.x, taxi.y);
            int distToPassenger = toPassenger[p.startX][p.startY];
            if (distToPassenger == -1 || fuel < distToPassenger) {
                System.out.println(-1);
                return;
            }

            fuel -= distToPassenger;
            taxi.x = p.startX;
            taxi.y = p.startY;

            // 3. 목적지로 이동
            if (!moveToDestination(p)) {
                System.out.println(-1);
                return;
            }

            // 4. 성공적으로 태운 승객 제거
            passengers.remove(p);
        }

        System.out.println(fuel); // 남은 연료 출력

    }

    // 두개의 거리 찾기
    static int[][] bfs(int startX, int startY) {
        int[][] dist = new int[N][N];
        for (int[] row : dist) Arrays.fill(row, -1);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});
        dist[startX][startY] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (map[nx][ny] == 1 || dist[nx][ny] != -1) continue;

                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
        return dist;
    }

    // 가장 가까운 승객 찾기
    static Passenger findNearestPassenger() {
        int[][] dist = bfs(taxi.x, taxi.y); // 거리 계산

        Passenger selected = null;
        int minDist = Integer.MAX_VALUE;

        for (Passenger p : passengers) {
            int d = dist[p.startX][p.startY];
            if (d == -1) continue; // 도달 불가능

            if (d < minDist) {
                minDist = d;
                selected = p;
            } else if (d == minDist) {
                // 거리 같으면 행, 열 우선순위 비교
                if (p.startX < selected.startX ||
                        (p.startX == selected.startX && p.startY < selected.startY)) {
                    selected = p;
                }
            }
        }

        if (selected == null) return null;
        return selected;
    }


    static boolean moveToDestination(Passenger p) {
        int[][] dist = bfs(p.startX, p.startY);
        int d = dist[p.endX][p.endY];

        // 도달 불가 or 연료 부족
        if (d == -1 || fuel < d) return false;

        // 연료 차감 후 이동
        fuel -= d;
        taxi.x = p.endX;
        taxi.y = p.endY;

        // 연료 충전 (이동 거리 * 2)
        fuel += d * 2;

        return true;
    }

    // 택시 위치 클래스
    static class Taxi {
        int x, y;

        Taxi(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 승객 클래스
    static class Passenger {
        int startX, startY, endX, endY;

        Passenger(int startX, int startY, int endX, int endY) {
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }
    }
}