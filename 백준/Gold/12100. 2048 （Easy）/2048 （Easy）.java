import java.util.*;



public class Main {
    static int[][] board;
    static int n;
    static int mxN = 0;
    public static void main(String[] args) {
        board = new int[21][21];
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 1;i <= n; i++){
            for(int j = 1;j <= n; j++){
                board[i][j] = sc.nextInt();
            }
        }
        
        dfs(0);
        System.out.println(mxN);
    }
    
    static void dfs(int depth){
        if (depth == 5){
            return;
        }
        int[][] newBoard = new int[21][21];
        
        for(int i=1; i<=n; i++) {
		  for(int j=1; j<=n; j++) {
        	newBoard[i][j] = board[i][j];
		  }
	   }
    
        for(int i=0;i<4;i++) {
		shift(i);
		for(int j=1; j<=n; j++) {
			for(int k=1; k<=n;k++) {
				if(board[j][k] > mxN) {
					mxN = board[j][k];
				}
			}
		}

		dfs(depth + 1);

		for(int j=1;j<=n;j++) {
			for(int k=1;k<=n;k++) {
				board[j][k] = newBoard[j][k];
			}
		}
	}
        
    }
    
  static void shift(int num) {
	Queue<Integer> q = new LinkedList<>();

	switch(num) {
		// left
		case 0:
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(board[i][j] != 0) {
						q.add(board[i][j]);
					}
					board[i][j] = 0;
				}
				int idx = 1;

				while(!q.isEmpty()) {
					int data = q.poll();
                    
					if(board[i][idx] == 0) {
						board[i][idx] = data;
					} else if(board[i][idx] == data) {
						board[i][idx] *= 2;
						idx++;
					} else {
						idx++;
						board[i][idx] = data;
					}
				}
			}
			break;

		// right
		case 1:
			for(int i=1;i<=n;i++) {
				for(int j=n;j>=1;j--) {
					if(board[i][j] != 0) {
						q.add(board[i][j]);
					}
					board[i][j] = 0;
				}
				int idx = n;

				while(!q.isEmpty()) {
					int data = q.poll();

					if(board[i][idx] == 0) {
						board[i][idx] = data;
					} else if(board[i][idx] == data) {
						board[i][idx] *= 2;
						idx--;
					} else {
						idx--;
						board[i][idx] = data;
					}
				}
			}
			break;

		// up
		case 2:
			for(int j=1;j<=n;j++) {
				for(int i=1;i<=n;i++) {
					if(board[i][j] != 0) {
						q.add(board[i][j]);
					}
					board[i][j] = 0;
				}
				int idx = 1;

				while(!q.isEmpty()) {
					int data = q.poll();

					if(board[idx][j] == 0) {
						board[idx][j] = data;
					} else if(board[idx][j] == data) {
						board[idx][j] *= 2;
						idx++;
					} else {
						idx++;
						board[idx][j] = data;
					}
				}
			}
			break;

		// down
		case 3:
			for(int j=1;j<=n;j++) {
				for(int i=n;i>=1;i--) {
					if(board[i][j] != 0) {
						q.add(board[i][j]);
					}
					board[i][j] = 0;
				}
				int idx = n;

				while(!q.isEmpty()) {
					int data = q.poll();

					if(board[idx][j] == 0) {
						board[idx][j] = data;
					} else if(board[idx][j] == data) {
						board[idx][j] *= 2;
						idx--;
					} else {
						idx--;
						board[idx][j] = data;
					}
				}
			}
	}
}
}
