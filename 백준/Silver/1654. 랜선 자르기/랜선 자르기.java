import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] arr = new int[K];
        long max = 0;

		for(int i = 0; i < K; i++){
            int temp = Integer.parseInt(br.readLine());
			arr[i] = temp;
            max = Math.max(max, temp);
		}


		long left = 1;
		long right = max;
		long ans = 0;
		while(left <= right){
			long mid = (left + right) / 2;
			long sum = 0;
			for(int i : arr){
				sum += i / mid;
			}
			if(sum >= N){
				ans = mid;
				left = mid + 1;
			}
			else{
				right = mid - 1;
			}

		}
		System.out.println(ans);

	}
}

