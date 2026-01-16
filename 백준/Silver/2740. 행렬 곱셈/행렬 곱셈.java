import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int a[][] = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                a[i][j] = sc.nextInt();
            }
        }
        
        M = sc.nextInt();
        int K = sc.nextInt();
        
        int b[][] = new int[M][K];
        int c[][] = new int[N][K];
        for(int i = 0; i < M; i++){
            for(int j = 0; j < K; j++){
                b[i][j] = sc.nextInt();
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < K; j++){
                
                for(int k = 0; k < M; k++){
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < K; j++){
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }
    }
}
