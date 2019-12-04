import java.util.*;

public class Main {
	static int N, M, K;
	static int[][] arr;
	static long[][] dp;
	static int[] cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N][2];
		dp = new long[N][M+1];
		cnt = new int[N];
		for(int i = 0; i < N; i++)
		{
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			Arrays.fill(dp[i], -1);
		}
		
		long res = solve(0, M);
		System.out.println(res);
	}
	private static long solve(int idx, int m) {
		if(m == 0) return 0;
		if(idx >= N) return Integer.MAX_VALUE;
		if(dp[idx][m] != -1) return dp[idx][m];
		long ret = Integer.MAX_VALUE;
		
		ret = Math.min(ret, solve(idx + 1, m));
		
		for(int i = 1; i <= 100; i++)
			if(arr[idx][1] * i <= m)
			{
				cnt[idx] = i;
				int tmp = 0;
				for(int j = 0; j < i; j++) tmp += arr[idx][0] + (j * K);
				ret = Math.min(ret, solve(idx + 1, m - (arr[idx][1] * i)) + tmp);
				cnt[idx] = 0;
			}
		
		return dp[idx][m] = ret;
	}
}