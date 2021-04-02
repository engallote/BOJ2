import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static int[][][] dp;
	static int[] dx = {1, 0}, dy = {0, 1};
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	map = new int[N][N];
    	dp = new int[N][N][3];
    	
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < N; j++) {
    			map[i][j] = sc.nextInt();
    			Arrays.fill(dp[i][j], -1);
    		}
    	
    	int res = solve(0, 0, 0);
    	System.out.println(res);
    }
	private static int solve(int x, int y, int k) {
		if(x == N - 1 && y == N - 1) {
			if(map[x][y] == k) return 1;
			else return 0;
		}
		if(dp[x][y][k] != -1) return dp[x][y][k];
		
		int ret = 0;
		
		if(map[x][y] == k) {
			if(x + 1 < N) ret = Math.max(solve(x + 1, y, (k + 1) % 3) + 1, ret);
			if(y + 1 < N) ret = Math.max(ret, solve(x, y + 1, (k + 1) % 3) + 1);
		}
		else {
			for(int i = 0; i < 2; i++) {
				int nx = x + dx[i], ny = y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				ret = Math.max(ret, solve(nx, ny, k));
				if(map[nx][ny] == k) ret = Math.max(ret, solve(nx, ny, (k + 1) % 3) + 1);
			}
		}
		
		return dp[x][y][k] = ret;
	}
}