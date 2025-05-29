
import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {

        Queue<Word> q = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();
        q.add(new Word(begin, 0));
        
        while(!q.isEmpty()){
            Word curr = q.poll();
            // System.out.println(curr.word + curr.count);
            // if 현재 노드 == target: return count;
            if(curr.word.equals(target)) return curr.count;


            for(int i = 0; i< words.length; i++){
                String next = words[i];
                if(getDiffCount(curr.word, next) == 1){
                    if(!visited.contains(next)){
                        q.offer(new Word(next,curr.count+1));
                        visited.add(next);
                    
                    }
                }
            }
        }
        return 0;
    }
    
    static int getDiffCount(String word1, String word2){
        int cnt = 0;
        
        // 알파벳 다른 갯수 word1 != word2
        for(int i = 0; i < word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)){
                cnt++;
            }
        }
        return cnt;
    }
    
    static class Word{
        String word;
        int count;
        Word(String word, int count){
            this.word = word;
            this.count = count;
            
        }
    }
}