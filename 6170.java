import java.util.*;

public class Main {
	static int N;
	static long[][] dp;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	
    	for(int tc = 1; tc <= T; tc++) {
    		N = sc.nextInt();
    		dp = new long[N][2];
    		
    		for(int i = 0; i < N; i++)
    			Arrays.fill(dp[i], -1);
    		
    		System.out.println("Scenario #" + tc + ":");
    		System.out.println(dfs(0, 0));
    		System.out.println();
    	}
    }
	private static long dfs(int idx, int d) {
		if(idx == N) return 1;
		if(dp[idx][d] != -1) return dp[idx][d];
		long ret = 0;
		
		ret += dfs(idx + 1, 0);
		if(d == 0) ret += dfs(idx + 1, 1);
		
		return dp[idx][d] = ret;
	}
}