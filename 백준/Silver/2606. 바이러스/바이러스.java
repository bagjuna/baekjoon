
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 2606번 바이러스
 */
public class Main {
    static ArrayList<Integer>[] A;
    static boolean [] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        A = new ArrayList[M + 1];
        visited = new boolean[M + 1];
        for (int i = 0; i < M + 1; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());

            int num2 = Integer.parseInt(st.nextToken());
            A[num1].add(num2);
            A[num2].add(num1);
        }
        DFS(1);
        System.out.println(count-1);
    }

    static void DFS(int v){
        if(visited[v]) return;

        visited[v] = true;
        count++;
        for(int i : A[v]){
            if(!visited[i]){
                DFS(i); 
            }
        }
    }
}
