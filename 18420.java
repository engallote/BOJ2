import java.util.*;

public class Main {
	static int R = 4, C = 3, N, M;
	static int[][] arr = {{7, 8, 9}, {4, 5, 6}, {1, 2, 3}, {0, -1, -1}};
	static int[][][] chk = new int[4][3][100001];
	static int[] dx = {1, 0, -1, 0}, dy = {0, -1, 0, 1};
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	
    	for(int i = 0; i < R; i++)
    		for(int j = 0; j < C; j++)
    			Arrays.fill(chk[i][j], 1000000000);
    	
    	int res = solve(3, 0);
    	System.out.println(res);
    }
	private static int solve(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y, 0));
		chk[x][y][0] = 0;
		int size;
		
		while(!q.isEmpty()) {
			size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				if(p.mod == M) return chk[p.x][p.y][p.mod];
				
				int mod = (p.mod * 10 + arr[p.x][p.y]) % N;
				if(chk[p.x][p.y][mod] > chk[p.x][p.y][p.mod] + 1) {
					chk[p.x][p.y][mod] = chk[p.x][p.y][p.mod] + 1;
					q.offer(new Pair(p.x, p.y, mod));
				}
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= R || ny >= C || arr[nx][ny] == -1) continue;
					if(chk[nx][ny][p.mod] > chk[p.x][p.y][p.mod] + 1) {
						chk[nx][ny][p.mod] = chk[p.x][p.y][p.mod] + 1;
						q.offer(new Pair(nx, ny, p.mod));
					}
				}
			}
		}
		return -1;
	}
	static class Pair {
		int x, y, mod;
		Pair(int x, int y, int mod){
			this.x = x;
			this.y = y;
			this.mod = mod;
		}
	}
}