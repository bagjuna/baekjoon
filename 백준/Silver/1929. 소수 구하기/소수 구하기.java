import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int[] a = new int[end+1];
        a[1] = 0;
        for(int i = 2; i < end+1; i++){
            a[i] = i;
        }
        for(int i = 2; i <= Math.sqrt(end); i++){
            int temp = a[i];
            if(temp == 0){
                continue;
            }
            
            for(int j = i * i; j <= end; j = j + i){
                a[j] = 0;
            }
            
        }
        

        for(int i = start; i < end+1; i++){
            if(a[i] != 0){
                System.out.println(a[i]);
            }
        }
        
        
    }
}
