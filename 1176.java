import java.util.*;

public class Main {
	static int N, K;
	static int[] arr;
	static long[][] dp;
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N+1];
		chk = new boolean[N+1];
		dp = new long[N+1][1<<(N+1)];
		
		arr[0] = Integer.MAX_VALUE;
		for(int i = 0; i <= N; i++)
				Arrays.fill(dp[i], -1);
		
		for(int i = 1; i <= N; i++)
			arr[i] = sc.nextInt();
		
		long res = solve(1, 0, 0);
		System.out.println(res);
	}
	private static long solve(int cnt, int idx, int visit) {
		if(cnt > N) return 1;
		if(dp[idx][visit] != -1) return dp[idx][visit];
		long ret = 0;
		
		for(int i = 1; i <= N; i++)
			if(!chk[i] && Math.abs(arr[idx] - arr[i]) > K){
				chk[i] = true;
				ret += solve(cnt + 1, i, visit|(1<<i));
				chk[i] = false;
			}
		
		return dp[idx][visit] = ret;
	}
}