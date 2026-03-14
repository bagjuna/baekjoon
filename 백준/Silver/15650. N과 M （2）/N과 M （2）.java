
import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 // 1. N과M 입력받기
		 int N = sc.nextInt();
		 int M = sc.nextInt();
		 // 2. 수열을 담을 배열과 방문 여부를 담을 배열 만들기
		 int[] arr = new int[M];

		 boolean[] visited = new boolean[N + 1];
		 // 3. dfs로 수열 만들기
		 dfs(N, M, arr, visited, 0,1);
	 }


	 static void dfs(int N, int M, int[] arr, boolean[] visited, int depth,int start) {
		 // 4. 수열의 길이가 M이 되면 수열 출력하기
		 if (depth == M) {
			 for (int i : arr) {
				 System.out.print(i + " ");
			 }
			 System.out.println();
			 return;
		 }
		 // 5. 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열 만들기
		 for (int i = start; i <= N; i++) {
			 if (!visited[i]) {
				 visited[i] = true;
				 arr[depth] = i;
				 dfs(N, M, arr, visited, depth + 1,i+1);
				 visited[i] = false;
			 }
		 }
	 }

}
