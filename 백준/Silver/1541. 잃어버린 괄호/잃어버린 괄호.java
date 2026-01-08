import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        
        String[] split1 = input.split("-");
        
        String[] first = split1[0].split("\\+");
        
        int answer = 0;
        for(int i = 0; i< first.length; i++){
            answer += Integer.parseInt(first[i]);
        }
        
        for(int i = 1; i< split1.length;i++){
            String line = split1[i];
            String[] split2 = line.split("\\+");
            for(int j = 0; j<split2.length;j++){
                answer -= Integer.parseInt(split2[j]);
            }
        }
        
        System.out.println(answer);
        

    }
}