
import java.io.*;
import java.util.*;

public class Main {
	static int[] A;
	static int[] tmp;
	static int K;
	static int cnt = 0;
	static int result = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N  = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new int[N];
		tmp = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		mergeSort(0, N -1);
		System.out.println(result);
	}

	static void mergeSort(int p, int r){
		if(cnt >= K){
			return;
		}
		if(p < r){
			int q = (p + r) / 2;
			mergeSort(p, q);
			mergeSort(q + 1, r);
			merge(p, q, r);
		}
	}

	static void merge(int p, int q, int r){
		if(cnt >= K) {
			return;
		}

		int i = p;
		int j = q + 1;
		int t = 0;

		while(i <= q && j <= r){
			if(A[i] <= A[j]){
				tmp[t++] = A[i++];
			} else{
				tmp[t++] = A[j++];
			}
		}

		while(i <= q){
			tmp[t++] = A[i++];
		}

		while(j <= r){
			tmp[t++] = A[j++];
		}

		i = p;
		t = 0;
		while(i <= r){
			A[i] = tmp[t];
			if(++cnt == K){
				result = A[i];
				return;
			}
			i++;
			t++;
		}

	}
}
