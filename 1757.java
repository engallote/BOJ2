import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	static int[][] dp;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        dp = new int[N][M + 1];
        
        for(int i = 0; i < N; i++) {
        	arr[i] = sc.nextInt();
        	Arrays.fill(dp[i], -1);
        }
        
        int res = solve(0, 0);
        System.out.println(res);
    }
	private static int solve(int idx, int m) {
		if(idx == N - m) return 0;
		if(idx > N - m) return -100000000;
		if(dp[idx][m] != -1) return dp[idx][m];
		
		int ret = 0;
		
		if(m < M) {
			if(m > 0)
				ret = Math.max(solve(idx + m, 0), solve(idx + 1, m + 1) + arr[idx]);
			else if(m == 0)
				ret = Math.max(solve(idx + 1, 0), solve(idx + 1, m + 1) + arr[idx]);
		}
		else if(m == M) ret = Math.max(ret, solve(idx + m, 0));
		
		return dp[idx][m] = ret;
	}
}