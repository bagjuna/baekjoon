
import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	static int plus, minus, multi, div;
	static int maxVal, minVal;

	public static void main(String[] args) {
		maxVal = Integer.MIN_VALUE;
		minVal = Integer.MAX_VALUE;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		plus = sc.nextInt();
		minus = sc.nextInt();
		multi = sc.nextInt();
		div = sc.nextInt();

		dfs(1, arr[0]);
		System.out.println(maxVal);
		System.out.println(minVal);
	}

	static void dfs(int idx, int sum){
		if(idx == N){
			maxVal = Math.max(sum, maxVal);
			minVal = Math.min(sum, minVal);
			return;
		}
		if(plus > 0) {
			plus--;
			dfs(idx + 1, sum + arr[idx]);
			plus++;
		}
		if(minus > 0){
			minus--;
			dfs(idx + 1, sum - arr[idx]);
			minus++;
		}
		if(multi > 0){
			multi--;
			dfs(idx + 1, sum * arr[idx]);
			multi++;
		}	

		if(div > 0){
			div--;
			dfs(idx + 1, sum / arr[idx]);
			div++;
		}
	}	
}
