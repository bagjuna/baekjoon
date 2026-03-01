import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        // 1. N 입력 받기
        int N = Integer.parseInt(br.readLine());
        
        // 2. 배열 전부 입력 받기
        int[] arr = new int[N];
        int[] sorted = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < N; i++){
            arr[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sorted);
        
        // 3-1 map 형태로 우열 가지게 저장하기
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int cnt = 0;
        for(int i = 0; i < N; i++){
            if(!map.containsKey(sorted[i])){
                map.put(sorted[i], cnt++);
            }
            
        }
        
        // 3-1 원래 배열을 순회하여 우열의 가진 map에서 값 찾아서 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(map.get(arr[i])).append(" ");
        }
        
        System.out.println(sb.toString());
        
    }
}
