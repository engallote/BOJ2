import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static int[][] dp;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        dp = new int[N][N];
        
        for(int i = 0; i < N; i++) {
        	arr[i] = sc.nextInt();
        	Arrays.fill(dp[i], -1);
        }
        
        int res = solve(0, N - 1, 1);
        System.out.println(res);
	}
	private static int solve( int l, int r, int cnt) {
		if(l > r) return 0;
		if(dp[l][r] != -1) return dp[l][r];
		int ret = 0;
		
		ret = Math.max(solve(l + 1, r, cnt + 1) + arr[l] * cnt, solve(l, r - 1, cnt + 1) + arr[r] * cnt);
		
		return dp[l][r] = ret;
	}
}