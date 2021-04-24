import java.util.*;

public class Main {
	static int N, M;
	static char[][] map;
	static int[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static Queue<Pair> q = new LinkedList();
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	map = new char[N][M];
    	chk = new int[N][M];
    	
    	for(int i = 0; i < N; i++)
    		map[i] = sc.next().toCharArray();
    	
    	int idx = 1;
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < M; j++)
    			if(map[i][j] == 'X' && chk[i][j] == 0) {
    				dfs(i, j, idx);
    				++idx;
    			}
    	
    	int time = 0;
    	while(!q.isEmpty()) {
    		int size = q.size();
    		while(--size >= 0){
    			Pair p = q.poll();
    			
    			for(int i = 0; i < 4; i++) {
    				int nx = p.x + dx[i], ny = p.y + dy[i];
    				if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] == 1) continue;
    				if(chk[nx][ny] == 2) {
    					System.out.println(time);
    					return;
    				}
    				chk[nx][ny] = 1;
    				q.offer(new Pair(nx, ny));
    			}
    		}
    		++time;
    	}
	}
	private static void dfs(int x, int y, int idx) {
		if(idx == 1) q.offer(new Pair(x, y));
		chk[x][y] = idx;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] != 0 || map[nx][ny] == '.')
				continue;
			dfs(nx, ny, idx);
		}
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}