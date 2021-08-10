import java.util.*;

public class Main {
	static int N, res = 0;
	static long[] arr;
	static int[][] dp;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	arr = new long[N];
    	dp = new int[N][N];
    	
    	for(int i = 0; i < N; i++) {
    		arr[i] = sc.nextLong();
    		Arrays.fill(dp[i], -1);
    	}
    	
    	long l = 1, r = Long.MAX_VALUE - 1, mid, ans = r;
    	while(l <= r) {
    		mid = (l + r) / 2;
    		res = 0;
    		solve(0, 0, mid);
    		
    		if(res == 1) {
    			ans = Math.min(ans, mid);
    			r = mid - 1;
    		}
    		else l = mid + 1;
    		
    		for(int i = 0; i < N; i++)
        		Arrays.fill(dp[i], -1);
    	}
    	
    	System.out.println(ans);
	}
	private static void solve(int idx, int pre, long k) {
		if(res == 1) return;
		if(idx == N - 1) {
			res = 1;
			return;
		}
		if(dp[pre][idx] != -1) return;
		
		for(int i = idx + 1; i < N; i++) {
			long num = (i - idx) * (1 + Math.abs(arr[idx] - arr[i]));
			if(num <= k) solve(i, idx, k);
		}
		
		dp[pre][idx] = 1;
	}
}