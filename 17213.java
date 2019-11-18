import java.util.*;

public class Main {
	static int N, M;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		dp = new int[M][N];
		if(N == M || N == 1)
		{
			System.out.println(1);
			return;
		}
		for(int i = 0; i < M; i++)
			Arrays.fill(dp[i], -1);
		
		M -= N;
		
		int res = solve(M, 0);
		System.out.println(res);
	}
	private static int solve(int cnt, int idx) {
		if(cnt == 0) return 1;
		if(idx == N) return 0;
		if(dp[cnt][idx] != -1) return dp[cnt][idx];
		int ret = 0;
		
		for(int i = 0; i <= cnt; i++)
			ret += solve(cnt - i, idx + 1);
		return dp[cnt][idx] = ret;
	}
}