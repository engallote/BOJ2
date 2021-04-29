import java.util.*;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] chk;
	static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1}, dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	static Queue<Pair> cloud = new LinkedList<>();
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	map = new int[N][N];
    	chk = new boolean[N][N];
    	
    	cloud.offer(new Pair(N - 1, 0));
    	cloud.offer(new Pair(N - 1, 1));
    	cloud.offer(new Pair(N - 2, 0));
    	cloud.offer(new Pair(N - 2, 1));
    	
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < N; j++)
    			map[i][j] = sc.nextInt();
    	
    	while(--M >= 0) {
    		int d = sc.nextInt();
    		int s = sc.nextInt();
    		
    		//구름 이동
    		move(d, s);
    		
    		//물복사버그
    		copy();
    		
    		//구름 생기기
    		makeClouds();
    	}
    	
    	int res = 0;
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < N; j++)
    			res += map[i][j];
    	
    	System.out.println(res);
	}
	private static void makeClouds() {
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++) {
				if(chk[i][j]) {
					chk[i][j] = false;
					continue;
				}
				if(map[i][j] < 2) continue;
				map[i][j] -= 2;
				cloud.offer(new Pair(i, j));
			}
	}
	private static void copy() {
		while(!cloud.isEmpty()) {
			Pair p = cloud.poll();
			
			int cnt = 0;
			for(int d = 1; d <= 8; d++) {
				if(d % 2 != 0) continue;
				int nx = p.x + dx[d], ny = p.y + dy[d];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 0) continue;
				++cnt;
			}
			
			map[p.x][p.y] += cnt;
		}
	}
	private static void move(int d, int s) {
		int size = cloud.size();
		while(--size >= 0) {
			Pair p = cloud.poll();
			
			int nx = p.x + dx[d] * s, ny = p.y + dy[d] * s;
			
			while(nx < 0) nx = N + nx;
			while(ny < 0) ny = N + ny;
			if(nx >= N || ny >= N) {
				nx %= N;
				ny %= N;
			}
			
			cloud.offer(new Pair(nx, ny));
			chk[nx][ny] = true;
			map[nx][ny] += 1;
		}
	}
}
class Pair{
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}