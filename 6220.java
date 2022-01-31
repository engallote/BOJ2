import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	static int[][] dp;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	arr = new int[M];
    	dp = new int[M][N];
    	
    	for(int i = 0; i < M; i++) {
    		arr[i] = sc.nextInt();
    		Arrays.fill(dp[i], -1);
    	}
    	
    	Arrays.sort(arr);
    	
    	int res = solve(0, 0);
    	System.out.println(res);
    }
	private static int solve(int idx, int n) {
		if(n == N) return 0;
		if(idx == M) return 100000000;
		if(dp[idx][n] != -1) return dp[idx][n];
		int ret = 100000000;
		
		ret = Math.min(ret, solve(idx + 1, n));
		for(int i = idx; i < M; i++) {
			int div = (N - n) / arr[i];
			for(int j = div; j >= 1; j--)
				ret = Math.min(ret, solve(i + 1, n + (j * arr[i])) + j);
		}
		
		return dp[idx][n] = ret;
	}
}