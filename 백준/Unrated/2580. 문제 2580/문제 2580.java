
import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static List<Point> list;
	static BufferedWriter bw;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		StringTokenizer st;
		map = new int[9][9];
		list = new ArrayList<>();
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
		    for(int j = 0; j < 9; j++){
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 0)
					list.add(new Point(i, j));
				else
					map[i][j] = temp;
		    }
		}

		dfs(0);
	}

	static void dfs(int idx) throws IOException {
		if(idx == list.size()) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++){
					sb.append(map[i][j]).append(' ');
				}
				sb.append('\n');
			}
			bw.write(sb.toString());
			bw.flush();
			bw.close();
			System.exit(0);
		}

		Point p = list.get(idx);
		boolean[] used = new boolean[10];
		for(int i = 0; i < 9; i++) {
			used[map[p.x][i]] = true;
			used[map[i][p.y]] = true;
		}

		int x = (p.x / 3) * 3;
		int y = (p.y / 3) * 3;
		for(int i = x; i < x + 3; i++) {
			for(int j = y; j < y + 3; j++) {
				used[map[i][j]] = true;
			}
		}

		for(int i = 1; i <= 9; i++) {
			if(!used[i]) {
				map[p.x][p.y] = i;
				dfs(idx + 1);
				map[p.x][p.y] = 0;
			}
		}
	}

	static class Point{
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

