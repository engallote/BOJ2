import java.util.*;

public class Main {
	static int W, H, N, D, B;
	static int[][] map;
	static boolean[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	while(true) {
    		W = sc.nextInt();
    		H = sc.nextInt();
    		N = sc.nextInt();
    		D = sc.nextInt();
    		B = sc.nextInt();
    		
    		if(W == 0 && H == 0 && N == 0 && D == 0 && B == 0) break;
    		
    		map = new int[H][W];
    		chk = new boolean[H][W];
    		int sx = 0, sy = 0;
    		
    		for(int i = 0; i < N; i++) {
    			int y = sc.nextInt() - 1;
    			int x = sc.nextInt() - 1;
    			
    			map[x][y] = 1;
    			if(i == B - 1) {
    				sx = x;
    				sy = y;
    			}
    		}
    		
    		bfs(sx, sy);
    	}
	}
	private static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		chk[x][y] = true;
		int ret = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			ret += size;
			while(--size >= 0) {
				Pair p = q.poll();
				
				for(int i = 0; i < 4; i++)
					for(int j = 1; j <= D; j++) {
						int nx = p.x + dx[i] * j, ny = p.y + dy[i] * j;
						if(nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
						if(map[nx][ny] != 1 || chk[nx][ny]) continue;
						
						chk[nx][ny] = true;
						map[nx][ny] = -1;
						q.offer(new Pair(nx, ny));
					}
			}
		}
		
		System.out.println(ret);
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}