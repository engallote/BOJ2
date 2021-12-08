import java.util.*;

public class Main {
	static int N, K;
	static long[][][] dp;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	K = sc.nextInt();
    	dp = new long[N + 1][N + 1][N + 1];
    	
    	for(int i = 0; i <= N; i++)
    		for(int j = 0; j <= N; j++)
    			Arrays.fill(dp[i][j], -1);
    	
    	long res = solve(0, 1, N);
    	System.out.println(res);
    }
	private static long solve(int idx, int pre, int num) {
		if(idx == K - 1) {
			if(pre <= num) return 1;
			else return 0;
		}
		if(dp[idx][pre][num] != -1) return dp[idx][pre][num];
		
		long ret = 0;
		
		for(int i = pre; i <= N; i++)
			if(num - i >= 0) ret += solve(idx + 1, i, num - i);
		
		return dp[idx][pre][num] = ret;
	}
}