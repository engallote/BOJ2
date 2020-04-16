import java.util.*;

public class Main {
	static int N, M, L;
	static char[][] arr;
	static long[][][] dp;
	static char[] ch;
	static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1}, dy = {0, 1, 0, -1, 1, -1, 1, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();
		dp = new long[N][M][L];
		arr = new char[N][M];
		
		for(int i = 0; i < N; i++){
			arr[i] = sc.next().toCharArray();
			for(int j = 0; j < M; j++)
				Arrays.fill(dp[i][j], -1);
		}
		
		ch = sc.next().toCharArray();
		
		long res = 0;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(arr[i][j] == ch[0])
					res += solve(i, j, 1);
		
		System.out.println(res);
	}
	private static long solve(int x, int y, int idx) {
		if(idx == L) return 1;
		if(dp[x][y][idx] != -1) return dp[x][y][idx];
		long ret = 0;
		
		for(int i = 0; i < 8; i++){
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] != ch[idx]) continue;
			ret += solve(nx, ny, idx + 1);
		}
		return dp[x][y][idx] = ret;
	}
}