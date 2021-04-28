import java.util.*;

public class Main {
	static int N, M, mu;
	static int[][] map;
	static boolean[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	map = new int[N][N];
    	chk = new boolean[N][N];
    	
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < N; j++)
    			map[i][j] = sc.nextInt();
    	
    	boolean flag = true;
    	long res = 0;
    	while(flag) {
    		flag = false;
    		for(int i = 0; i < N; i++)
    			Arrays.fill(chk[i], false);
    		
    		int max = 0, x = Integer.MAX_VALUE, y = Integer.MAX_VALUE, m = 0;
    		
    		for(int i = 0; i < N; i++)
    			for(int j = 0; j < N; j++)
    				if(map[i][j] > 0) {
    					mu = 0;
    					int cnt = find(i, j);
    					if(cnt == 1) continue;
    					
    					flag = true;
    					clear();
    					if(cnt > max) {
    						max = cnt;
    						m = mu;
    						x = i;
    						y = j;
    					}
    					else if(cnt == max && m < mu) {
    						max = cnt;
    						m = mu;
    						x = i;
    						y = j;
    					}
    					else if(cnt == max && m == mu && i > x) {
    						max = cnt;
    						m = mu;
    						x = i;
    						y = j;
    					}
    					else if(cnt == max && m == mu && x == i && j > y) {
    						max = cnt;
    						m = mu;
    						x = i;
    						y = j;
    					}
    				}
    		if(!flag) break;
    		
    		res += max * max;
    		
    		get(x, y);
    		down();
    		
    		rotate();
    		down();
    	}
    	
    	System.out.println(res);
	}
	private static void rotate() {
		int[][] tmp = new int[N][N];
		int r = 0, c = 0;
		
		for(int i = 0; i < N; i++) {
			r = N - 1;
			for(int j = 0; j < N; j++) {
				tmp[r][c] = map[i][j];
				--r;
			}
			++c;
		}
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				map[i][j] = tmp[i][j];
	}
	private static void down() {
		for(int i = N - 1; i >= 0; i--)
			for(int j = 0; j < N; j++) {
				if(map[i][j] != -2) continue;
				int nx = i - 1;
				while(nx >= 0) {
					if(map[nx][j] != -2) {
						if(map[nx][j] == -1) break;
						else {
							map[i][j] = map[nx][j];
							map[nx][j] = -2;
							break;
						}
					}
					--nx;
				}
			}
	}
	private static void clear() {
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				if(map[i][j] == 0) chk[i][j] = false;
	}
	private static void get(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		int num = map[x][y];
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] <= -1) continue;
					if(map[nx][ny] == num) {
						map[nx][ny] = -2;
						q.offer(new Pair(nx, ny));
					}
					else if(map[nx][ny] == 0) {
						map[nx][ny] = -2;
						q.offer(new Pair(nx, ny));
					}
				}
			}
		}
	}
	private static int find(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		int num = map[x][y], cnt = 0;
		chk[x][y] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				++cnt;
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N || chk[nx][ny] || map[nx][ny] <= -1) continue;
					if(map[nx][ny] == num) {
						chk[nx][ny] = true;
						q.offer(new Pair(nx, ny));
					}
					else if(map[nx][ny] == 0) {
						chk[nx][ny] = true;
						++mu;
						q.offer(new Pair(nx, ny));
					}
				}
			}
		}
		
		return cnt;
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}