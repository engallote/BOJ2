import java.util.*;

public class Main {
	static int N, M, K, mod = 1000000007;
	static int[][] arr, dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N][M];
		dp = new int[N][M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++){
				arr[i][j] = sc.nextInt();
				dp[i][j] = -1;
			}
		
		int res = solve(0, 0);
		System.out.println(res);
	}
	private static int solve(int x, int y) {
		if(x == N - 1 && y == M - 1) return 1;
		if(dp[x][y] != -1) return dp[x][y] % mod;
		int ret = 0;
		
		for(int i = x + 1; i < N; i++)
			for(int j = y + 1; j < M; j++)
				if(arr[i][j] != arr[x][y]){
					ret += solve(i, j);
					ret %= mod;
				}
		
		return dp[x][y] = ret;
	}
}