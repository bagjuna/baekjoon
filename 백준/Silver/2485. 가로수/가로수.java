import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int[] arr = new int[N];
        
        
        for(int i = 0; i < N; i++){
            arr[i] =  sc.nextInt();
        
        }
        
        int g = 0;
        
        for(int i = 0; i < N - 1; i++){
            int gap = arr[i + 1] - arr[i];
            
            if(i == 0)
                g = gap;
            else{
                g = gcd(g, gap);
            }
        }
        
        
      long number = (arr[N - 1] - arr[0]) / g + 1;
      System.out.println(number - N);
        
    }
    
    static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
