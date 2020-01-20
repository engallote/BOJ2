import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr, dp;
	static int[] res;
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M][N];
		dp = new int[M+1][N];
		Arrays.fill(dp[M], -1);
		
		for(int i = 0; i < M; i++){
			Arrays.fill(dp[i], -1);
			for(int j = 0; j < N; j++)
				arr[i][j] = sc.nextInt();
		}
		
		int res = solve(M, 0);
		System.out.println(res);
	}
	private static int solve(int p, int idx) {
		if(idx == N) return 0;
		if(dp[p][idx] != -1) return dp[p][idx];
		int ret = 0;
		
		for(int i = 0; i < M; i++){
			if(p == i) ret = Math.max(ret, solve(p, idx + 1) + (arr[p][idx] / 2));
			else ret = Math.max(ret, solve(i, idx + 1) + arr[i][idx]);
		}
		return dp[p][idx] = ret;
	}
}