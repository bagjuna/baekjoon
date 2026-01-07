import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 강의 수
        int M = sc.nextInt();
		int[] times = new int[N];
		int start = 0; // 블루레이 최소 크기 (가장 긴 강의 시간)
		int end = 0;   // 블루레이 최대 크기 (모든 강의 시간 합)
		for (int i = 0; i < N; i++) {
			int temp = sc.nextInt(); // 각 강의 시간
			times[i] = temp;
			end += temp;
			if (start < temp) {
				start = temp;
			}
		}
		
	
		while(start <= end) {
			int mid = (start + end) / 2;
            int count = 0;
            int sum = 0;
            for(int i = 0; i < N; i++){
                if(sum + times[i] > mid){
                    count++;
                    sum = 0;
                }
                sum = sum + times[i];
            }
            if(sum != 0)
                count++;
            if(count > M)
                start = mid + 1;
            else
                end = mid - 1;
		}
		System.out.println(start);
	}
}
