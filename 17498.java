import java.util.*;

public class Main {
	static int N, M, D;
	static long res;
	static long[][] arr, dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		res = Long.MIN_VALUE;
		arr = new long[N][M];
		dp = new long[N][M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
			{
				arr[i][j] = sc.nextLong();
				dp[i][j] = Long.MIN_VALUE;
			}
		
		for(int i = 0; i < M; i++)
			res = Math.max(res, solve(0, i));
		
		System.out.println(res);
	}
	private static long solve(int x, int y) {
		if(x >= N - 1) return 0;
		if(dp[x][y] != Long.MIN_VALUE) return dp[x][y];
		long ret = Long.MIN_VALUE;
		for(int i = x + 1; i <= Math.min(N-1, x + D); i++)
		{
			for(int j = Math.max(y - D, 0); j < Math.min(M, y + D + 1); j++)
				if((i - x) + Math.abs(y-j) <= D)
					ret = Math.max(ret, solve(i, j) + (arr[x][y] * arr[i][j]));	
		}
		return dp[x][y] = ret;
	}
}