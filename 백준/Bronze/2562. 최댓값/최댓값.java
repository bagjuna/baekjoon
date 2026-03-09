import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index = 0;
        int max = 0;
        for(int i = 1; i <= 9; i++){
            int temp = sc.nextInt();
            if(max < temp){
                max = temp;
                index = i;
            }
        }
        System.out.println(max);
        System.out.println(index);
    }
}
