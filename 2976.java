import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+1];
		dp = new int[N+1][1001];
		
		for(int i = 1; i <= N; i++){
			arr[i] = sc.nextInt();
			Arrays.fill(dp[i], -1);
		}
		
		int res = solve(1, 1);
		System.out.println(res);
	}
	private static int solve(int idx, int jump) {
		if(idx == N) return 0;
		if(dp[idx][jump] != -1) return dp[idx][jump];
		int ret = 100000000;
		dp[idx][jump] = ret;
		
		if(idx + jump <= N)
			ret = Math.min(ret, solve(idx + jump, jump + 1) + arr[idx + jump]);
		if(idx - (jump - 1) >= 1)
			ret = Math.min(ret, solve(idx - (jump - 1), jump) + arr[idx - (jump - 1)]);
		
		return dp[idx][jump] = ret;
	}
}