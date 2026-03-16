
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int[] arr = new int[4];
			int temp = sc.nextInt();
			while (temp != 0) {
				if (temp >= 25) {
					arr[0] += temp / 25;
					temp = temp % 25;
				} else if (temp >= 10) {
					arr[1] += temp / 10;
					temp = temp % 10;
				} else if (temp >= 5) {
					arr[2] += temp / 5;
					temp = temp % 5;
				} else {
					arr[3] += temp;
					temp = 0;
				}
			}
			for (int i1 : arr) {
				System.out.print(i1 + " ");
			}
			System.out.println();
		}
	}
}