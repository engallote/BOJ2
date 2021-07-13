import java.util.*;

public class Main {
	static int N, K;
	static int[] arr;
	static int[][] dp;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	K = sc.nextInt();
    	arr = new int[N];
    	dp = new int[N][K + 1];
    	
    	for(int i = 0; i < N; i++) {
    		arr[i] = sc.nextInt();
    		Arrays.fill(dp[i], -1);
    	}
    	
    	int res = solve(0, 0);
    	if(res > N) res = -1;
    	System.out.println(res);
	}
	private static int solve(int idx, int k) {
		if(k == K) return 0;
		if(idx == N) return 100000;
		if(dp[idx][k] != -1) return dp[idx][k];
		
		int ret = 100000;
		ret = Math.min(ret, solve(idx + 1, k));
		
		for(int i = idx; i < N; i++)
			if(k + arr[i] <= K)
				ret = Math.min(ret, solve(i + 1, k + arr[i]) + 1);
		
		return dp[idx][k] = ret;
	}
}