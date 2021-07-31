import java.util.*;

public class Main {
	static int N, M;
	static int[][] map;
	static int[][][] chk;
	static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	map = new int[N][M];
    	chk = new int[N][M][4];
    	
    	int sx = sc.nextInt() - 1;
    	int sy = sc.nextInt() - 1;
    	int ex = sc.nextInt() - 1;
    	int ey = sc.nextInt() - 1;
    	
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < M; j++) {
    			map[i][j] = sc.nextInt();
    			Arrays.fill(chk[i][j], Integer.MAX_VALUE);
    		}
    	
    	bfs(sx, sy, ex, ey);
	}
	private static void bfs(int sx, int sy, int ex, int ey) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(sx, sy, 1));
		chk[sx][sy][1] = 0;
		int res = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				if(p.x == ex && p.y == ey) {
					res = Math.min(res, chk[p.x][p.y][p.k]);
					continue;
				}
				
				if(p.k == 1) {
					for(int i = 0; i < 2; i++) {
						int nx = p.x + dx[i], ny = p.y + dy[i];
						int nk = p.k + 1 <= 3 ? p.k + 1 : 1;
						if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == -1 || chk[nx][ny][nk] <= chk[p.x][p.y][p.k] + map[nx][ny])continue;
						chk[nx][ny][nk] = chk[p.x][p.y][p.k] + map[nx][ny];
						q.offer(new Pair(nx, ny, nk));
					}
				}
				else if(p.k == 2) {
					for(int i = 2; i < 4; i++) {
						int nx = p.x + dx[i], ny = p.y + dy[i];
						int nk = p.k + 1 <= 3 ? p.k + 1 : 1;
						if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == -1 || chk[nx][ny][nk] <= chk[p.x][p.y][p.k] + map[nx][ny])continue;
						chk[nx][ny][nk] = chk[p.x][p.y][p.k] + map[nx][ny];
						q.offer(new Pair(nx, ny, nk));
					}
				}
				else {
					for(int i = 0; i < 4; i++) {
						int nx = p.x + dx[i], ny = p.y + dy[i];
						int nk = p.k + 1 <= 3 ? p.k + 1 : 1;
						if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == -1 || chk[nx][ny][nk] <= chk[p.x][p.y][p.k] + map[nx][ny])continue;
						chk[nx][ny][nk] = chk[p.x][p.y][p.k] + map[nx][ny];
						q.offer(new Pair(nx, ny, nk));
					}
				}
			}
		}
		
		if(res == Integer.MAX_VALUE) res = -1;
		System.out.println(res);
	}
}
class Pair {
	int x, y, k;
	Pair(int x, int y, int k) {
		this.x = x;
		this.y = y;
		this.k = k;
	}
}