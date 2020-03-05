import java.util.*;

public class Main {
	static int N, M, A, B;
	static int[][] arr;
	static int[][][] dp;
	static int[] dx = {1, 0}, dy = {0, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		A = sc.nextInt();
		B = sc.nextInt();
		arr = new int[N][M];
		dp = new int[N][M][A+1];
		
		for(int i = 0; i < A; i++){
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			arr[x][y] = 2;
		}
		
		for(int i = 0; i < B; i++){
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			arr[x][y] = 1;
		}
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				Arrays.fill(dp[i][j], -1);
		
		int res = solve(0, 0, 0);
		System.out.println(res);
	}
	private static int solve(int x, int y, int cnt) {
		if(x == N - 1 && y == M - 1){
			if(cnt == A) return 1;
			return 0;
		}
		if(dp[x][y][cnt] != -1) return dp[x][y][cnt];
		int ret = 0;
		
		for(int i = 0; i < 2; i++){
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 1) continue;
			if(arr[nx][ny] == 2) ret += solve(nx, ny, cnt + 1);
			else ret += solve(nx, ny, cnt);
		}
		
		return dp[x][y][cnt] = ret;
	}
}