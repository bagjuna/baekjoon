
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		int M = sc.nextInt();

		for (int i = 0; i < M; i++) {
			boolean find = false;
			int target = sc.nextInt();
			int start = 0;
			int end = N - 1;
			while (start <= end) {
				int midI = (start + end) / 2;
				int midV = a[midI];
				if (midV > target) {
					end = midI - 1;
				} else if (midV < target) {
					start = midI + 1;
				} else {
					find = true;
					break;
				}
			}
			if (find)
				System.out.println(1);
			else
				System.out.println(0);

		}
	}
}
