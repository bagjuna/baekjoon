import java.io.*;
import java.util.*;

public class Main {
    // 스택에 담을 객체: 키와 같은 키를 가진 사람 수
    static class Person {
        int height;
        int count; // 이 사람과 키가 같으면서 연속된 사람의 수 (자신 포함)

        public Person(int height, int count) {
            this.height = height;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Deque<Person> stack = new ArrayDeque<>();
        long answer = 0; // 쌍의 수는 int 범위를 넘을 수 있음

        for (int i = 0; i < N; i++) {
            int currentHeight = Integer.parseInt(br.readLine());
            
            // 현재 사람(currentHeight)과 스택에 있는 사람들을 비교
            
            // 1. 같은 키의 사람 수를 저장할 변수 (기본 1명: 나 자신)
            int pairCnt = 1; 

            // 2. 스택이 비어있지 않고, 현재 사람보다 키가 작은 사람이 있다면?
            // -> 그 사람들은 나를 볼 수 있고, 나 때문에 뒤는 못 봄. (처리 완료 후 제거)
            while (!stack.isEmpty() && stack.peek().height <= currentHeight) {
                Person p = stack.pop();
                
                // 일단 팝 된 사람만큼 쌍이 생성됨
                answer += p.count;
                
                // 만약 키가 같다면? 
                // 나(current)도 그 전 사람들과 합쳐져야 함.
                if (p.height == currentHeight) {
                    pairCnt += p.count;
                }
            }

            // 3. 스택에 아직 사람이 남아있다면?
            // -> 그 사람은 나보다 키가 큰 사람임 (위 while문에서 작거나 같은건 다 빠졌으니)
            // -> 나는 그 사람을 볼 수 있음 (쌍 +1)
            if (!stack.isEmpty()) {
                answer++;
            }

            // 4. 나를 스택에 넣음 (키, 뭉쳐진 사람 수)
            stack.push(new Person(currentHeight, pairCnt));
        }

        System.out.println(answer);
    }
}
