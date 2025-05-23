
import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        // new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        new_id = new_id.toLowerCase();
  

        // ew_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        Queue<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if (c >= 'a' && c <= 'z') {
                queue.add(c);
            } else if (c >= '0' && c <= '9') {
                queue.add(c);
            } else if (c == '-' || c == '_' || c == '.') {
                queue.add(c);
            }
        }
    
       
        Deque<Character> tempQueue = new ArrayDeque<>();
        // new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (c == '.') {
                if (tempQueue.isEmpty() || tempQueue.getLast() != '.') {
                    tempQueue.add(c);
                }
            } else {
                tempQueue.add(c);
            }
        }
       
        // new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if (!tempQueue.isEmpty() && tempQueue.getFirst() == '.') {
            tempQueue.poll();
        }
        if (!tempQueue.isEmpty() && tempQueue.getLast() == '.') {
            tempQueue.pollLast();
        }
        // new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if (tempQueue.isEmpty()) {
            tempQueue.add('a');
        }
          for (Character c : tempQueue) {
            System.out.print(c);
        }
        // 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        // 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        StringBuilder sb = new StringBuilder();
        while (!tempQueue.isEmpty() && sb.length() < 15) {
            char c = tempQueue.poll();
            sb.append(c);
        }
     
    
        if(sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }
        
        
        if (sb.length() < 3) {
            while (sb.length() < 3) {
                sb.append(sb.charAt(sb.length() - 1));
            }
        }
        
        return sb.toString();

    }
}