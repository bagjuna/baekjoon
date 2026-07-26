import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int n = message.length();
        boolean[] isSpoiler = new boolean[n];
        
        // 1. 스포일러 구간 표시
        for(int[] range :spoiler_ranges){
            int start = range[0];
            int end = range[1];
            for(int i = start; i <= end; i++){
                isSpoiler[i] = true;
            }
            
        }
        
        // 2, 단어별로 스포일러 포함 여부, 비 스포일러 등장 여부 체크        
        String[] words = message.split(" ");
        int idx = 0;
        
        Set<String> nonSpoilerWords = new HashSet<String>();
        Set<String> spoilerWords = new HashSet<String>();
        Set<Integer> spoilerWordsIdx = new HashSet<Integer>();
        
        for(String word :words){
            boolean hasSpiler = false;
            
            for(int i = 0;i < word.length(); i++){
                if(idx < n && isSpoiler[idx + i]){
                    hasSpiler = true;
                    break;
                }
            }
            if(hasSpiler){
                spoilerWords.add(word);
                spoilerWordsIdx.add(idx);
            }else{
                nonSpoilerWords.add(word);
            }
            idx += word.length() + 1;
        }
        
        // 3. 중요한 단어 세기
        Set<String> counted = new HashSet<>();
        
        int answer = 0;
        for (String word: spoilerWords){
            if(!nonSpoilerWords.contains(word) && !counted.contains(word)){
                counted.add(word);
                answer++;
            }
        }
        
        return answer;
    }
}

// "my phone number is 01012345678 and may i have your phone number"