import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long number = sc.nextLong();
        int B = sc.nextInt();
        
        StringBuilder sb = new StringBuilder();
        while(number > 0){
            int temp = (int) (number % B);
            if(temp >= 10){
                sb.append((char)(temp - 10 + 'A'));
            }else{
                sb.append(temp);
            }
            
            number /= B;
        }
        if(sb.length() == 0){
            System.out.println(0);
        }else{
            System.out.println(sb.reverse().toString());
          }

    }
}
