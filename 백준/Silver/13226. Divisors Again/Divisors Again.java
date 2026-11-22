
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int max = 0;
			for (int j = a; j <= b; j++) {
				int cnt = 0;
				for (int k = 1; k <= Math.sqrt(j); k++) {
					if (j % k == 0) {
						if (k * k == j) {
							cnt++;
						} else {
							cnt += 2;
						}
					}
				}
				max = Math.max(max, cnt);
			}
			System.out.println(max);
		}
	}
}
