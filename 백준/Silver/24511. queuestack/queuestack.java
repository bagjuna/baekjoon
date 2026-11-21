
// queuestack

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 한가롭게 방학에 놀고 있던 도현이는 갑자기 재밌는 자료구조를 생각해냈다. 그 자료구조의 이름은 queuestack이다.

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N1 = Integer.parseInt(st.nextToken());
		boolean[] isStack = new boolean[N1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N1; i++) {
			isStack[i] = st.nextToken().equals("1");
		}

		Deque<Integer> queue = new ArrayDeque<>();
		st  = new StringTokenizer(br.readLine());

		for (int i = 0; i < N1; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (!isStack[i]) {
				queue.addLast(num);
			}
		}

		int N3 = Integer.parseInt(br.readLine());
		String line = br.readLine();
		st = new StringTokenizer(line);

		for (int i = 0; i < N3; i++) {
			int num = Integer.parseInt(st.nextToken());
			queue.addFirst(num);
			bw.write(String.valueOf(queue.pollLast()));
			if (i < N3 - 1) {
				bw.write(' ');
			}
		}
		bw.flush();
	}
}
