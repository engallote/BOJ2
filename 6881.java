import java.util.*;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	M = sc.nextInt();
    	N = sc.nextInt();
    	map = new int[N][M];
    	
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < M; j++)
    			map[i][j] = sc.nextInt();
    	
    	for(int i = 0; i <= 9; i++)
    		for(int j = i; j <= 9; j++)
    			for(int k = j; k <= 9; k++) {
    				if(bfs(i, j, k)) {
    					System.out.println(i + " " + j + " " + k);
    					return;
    				}
    			}
    	System.out.println(-1 + " " + -1 + " " + -1);
    }
	private static boolean bfs(int a, int b, int c) {
		chk = new boolean[N][M];
		Queue<Pair> q = new LinkedList<>();
		
		for(int i = 0; i < M; i++)
			if(map[0][i] == a || map[0][i] == b || map[0][i] == c) {
				chk[0][i] = true;
				q.offer(new Pair(0, i));
			}
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				if(p.x == N - 1) return true;
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny]) continue;
					if(map[nx][ny] == a || map[nx][ny] == b || map[nx][ny] == c) {
						chk[nx][ny] = true;
						q.offer(new Pair(nx, ny));
					}
				}
			}
		}
		
		return false;
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}