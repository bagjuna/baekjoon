
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[] arr;
    static int N, M;          // N: 최대 숫자, M: 수열의 길이
    static StringBuilder sb;  // 출력을 위한 StringBuilder
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1. 입력 변수로 N 과 M 받기
        N = sc.nextInt();  // 1부터 N까지 자연수
        M = sc.nextInt();   // 길이가 M인 수열
        sb = new StringBuilder();

        // 2. 배열 크기 초기화
        arr = new int[M];
        visited = new boolean[N + 1];
        dfs(0);
        System.out.print(sb);
    }

    static void dfs(int currNum) {
        // 4. 종료 조건: 현재 깊이가 M과 같으면 수열 완성
        if (currNum == M) {
            for(int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        // 5. 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열 만들기
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;  // 방문 처리
                arr[currNum] = i;   // 현재 수열 위치에 숫자 저장
                dfs(currNum + 1);   // 다음 깊이로 이동
                visited[i] = false; // 백트래킹: 방문 해제
            }
        }
    }
}


