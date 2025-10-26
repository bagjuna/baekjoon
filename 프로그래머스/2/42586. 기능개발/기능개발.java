
import java.util.*;

class Solution {
    
public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            // 1. 한 개의 기능을 개발하는데 필요한 날짜 게산
            double days = (100 - progresses[i])/ (double) speeds[i];
            int dayUp = (int) Math.ceil(days);

            // 2. 함께 배포할 기능의 index 찾기
            int j = i + 1;
            for(; j < progresses.length; j++){
                if (progresses[j] + dayUp * speeds[j] < 100) 
                    break;
                
            }
            // 3. 이번에 배포할 기능의 개수 추가하기
            answer.add(j - i);
            i = j - 1;
        }
        return answer.stream().mapToInt(i -> i.intValue()).toArray();
    }
    
}