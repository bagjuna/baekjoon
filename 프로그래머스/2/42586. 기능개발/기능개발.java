
import java.util.*;

class Solution {
    
    public int[] solution(int[] progresses, int[] speeds) {
        int N = progresses.length;
        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            int progres = progresses[i];
            int time = 0;
            while (progres < 100) {
                time++;
                progres += speeds[i];
            }
            answer[i] = time;
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i : answer) {
            q.add(i);
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            int cnt_temp = 0;
            int temp = q.peek();
            if (temp <= cnt) {
                while (temp <= cnt && !q.isEmpty() && q.peek() <= cnt) {
                    cnt_temp++;
                    q.poll();
                }
            }
            if (cnt_temp > 0) {
                list2.add(cnt_temp);
            }

            cnt++;

        }
        
        
        int [] result = new int[list2.size()];
        if (list2.isEmpty()) {
            return result;
        }
        for (int i = 0; i < list2.size(); i++) {
            result[i] = list2.get(i);
        }
        
        return result;
    }
}