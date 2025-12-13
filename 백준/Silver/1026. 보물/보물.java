import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        // 1. 갯수(N) 입력 받기
        int N = sc.nextInt();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        // 2. 배열 1 입력받기
        for(int i = 0; i< N;i++){
            list1.add(sc.nextInt());
        }
        // 3. 배열 2 입력받기
        for(int i = 0; i< N;i++){
            list2.add(sc.nextInt());
        }        
        
        list1.sort((a,b) -> a - b);
        list2.sort((a,b) -> b - a);
        int sum = 0;
        for(int i = 0; i< N; i++){
            sum = sum + (list1.get(i) * list2.get(i));
        }
        System.out.println(sum);
        
    
    }
}