import java.util.*;

public class Main {
	static int N, mod = 10007;
	static int[][][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new int[N][N][N];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				Arrays.fill(dp[i][j], -1);
		
		int res = solve(0, 0, 0) % mod;
		System.out.println(res);
	}
	private static int solve(int idx, int g, int m) {
		if(idx != 0 && g == m) return 0;
		if(idx == N - 1) return 1;	
		if(dp[idx][g][m] != -1) return dp[idx][g][m] % mod;
		int ret = 0;
		
		ret += solve(idx + 1, g, m) % mod;//기웅이 아래, 민수 아래
		ret += solve(idx + 1, g, m + 1) % mod;//기웅이 아래, 민수 대각선
		ret += solve(idx + 1, g + 1, m) % mod;//기웅이 대각선, 민수 아래
		ret += solve(idx + 1, g + 1, m + 1) % mod;//기웅이 대각선, 민수 대각선
		
		return dp[idx][g][m] = ret % mod;
	}
}