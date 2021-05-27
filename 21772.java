import java.util.*;

public class Main {
	static int R, C, T;
	static char[][] map;
	static boolean[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	R = sc.nextInt();
    	C = sc.nextInt();
    	T = sc.nextInt();
    	map = new char[R][C];
    	chk = new boolean[R][C];
    	
    	int x = 0, y = 0;
    	for(int i = 0; i < R; i++) {
    		map[i] = sc.next().toCharArray();
    		for(int j = 0; j < C; j++)
    			if(map[i][j] == 'G') {
    				x = i;
    				y = j;
    			}
    	}
    	
    	int res = dfs(x, y, T);
    	System.out.println(res);
	}
	private static int dfs(int x, int y, int time) {
		if(time == 0) return 0;
		
		int ret = 0;
		
		ret = Math.max(ret, dfs(x, y, time - 1));
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == '#') continue;
			if(map[nx][ny] == 'S') {
				if(chk[nx][ny]) ret = Math.max(ret, dfs(nx, ny, time - 1));
				else {
					chk[nx][ny] = true;
					ret = Math.max(ret, dfs(nx, ny, time - 1) + 1);
					chk[nx][ny] = false;
				}
			}
			else ret = Math.max(ret, dfs(nx, ny, time - 1));
		}
		
		return ret;
	}
}