import java.util.*;

public class Main {
	static int N, K, res = 0;
	static int[] arr;
	static int[][] dp;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	K = sc.nextInt();
    	arr = new int[N];
    	dp = new int[N][N];
    	
    	for(int i = 0; i < N; i++) {
    		arr[i] = sc.nextInt();
    		Arrays.fill(dp[i], -1);
    	}
    	
    	solve(0, 0);
    	
    	if(res == 0) System.out.println("NO");
    	else System.out.println("YES");
	}
	private static void solve(int idx, int pre) {
		if(res == 1) return;
		if(idx == N - 1) {
			res = 1;
			return;
		}
		if(dp[pre][idx] != -1) return;
		
		for(int i = idx + 1; i < N; i++) {
			int num = (i - idx) * (1 + Math.abs(arr[idx] - arr[i]));
			if(num <= K) solve(i, idx);
		}
		
		dp[pre][idx] = 1;
	}
}