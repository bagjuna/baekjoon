import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t =0; t< T;t++){
            int startx = sc.nextInt();
            int starty = sc.nextInt();
            int endx = sc.nextInt();
            int endy = sc.nextInt();
            
            int n = sc.nextInt();
            int cnt = 0;
            for(int i = 0; i < n; i++){
                int cx = sc.nextInt();
                int cy = sc.nextInt();
                int r = sc.nextInt();
                
                // (x-cx)^2 + (y-cy)^2 < r^2 공식을 사용
                
                boolean isStartInside = (Math.pow(startx - cx, 2) + Math.pow(starty - cy, 2)) < Math.pow(r, 2);
                
                boolean isEndInside = (Math.pow(endx - cx, 2) + Math.pow(endy - cy, 2)) < Math.pow(r, 2);
                
                if(isStartInside != isEndInside)
                    cnt++;
                
                
            }
            System.out.println(cnt);
            
            
            
            
        }
    }
}
