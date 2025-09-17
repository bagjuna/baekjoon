import java.util.*;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		map = new int[N][N];
		int maxHeight = 0; // 지도에서 가장 높은 지점을 찾기 위한 변수

		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] > maxHeight) {
					maxHeight = map[i][j];
				}
			}
		}
		int maxSafeAreaCount = 0; // 최종 정답이 될, 안전 영역의 최대 개수

		for (int h = 0; h < maxHeight; h++) {
			visited = new boolean[N][N]; // 각 높이 시뮬레이션마다 visited 배열 초기화
			int currentSafeAreaCount = 0; // 현재 높이 h에서의 안전 영역 개수
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > h && !visited[i][j]) {
						bfs(i, j, h);
						currentSafeAreaCount++; // 새로운 안전 영역 발견, 개수 증가
					}

				}
			}
			maxSafeAreaCount = Math.max(maxSafeAreaCount, currentSafeAreaCount);

		}

		if (maxSafeAreaCount == 0) {
			System.out.println(1);
		} else {
			System.out.println(maxSafeAreaCount);
		}

	}

	static void bfs(int n, int m, int height) {
		visited[n][m] = true;

		for (int i = 0; i < 4; i++) {
			int nextN = n + dx[i];
			int nextM = m + dy[i];
			if (check(nextN, nextM) && !visited[nextN][nextM] && map[nextN][nextM] > height)
				bfs(nextN, nextM, height);

		}

	}

	static boolean check(int n, int m) {
		return n < N && m < N && n >= 0 && m >= 0;
	}
}
