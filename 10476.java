import java.util.*;

public class Main {
	static int N, K, sum;
	static int[][] arr;
	static int[][][] dp;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
        	N = sc.nextInt();
            K = sc.nextInt();
            
            if(N == 0 && K == 0) break;
            
            arr = new int[N][2];
            dp = new int[N][3][K + 1];
            sum = 0;
            
            for(int i = 0; i < N; i++) {
            	arr[i][0] = sc.nextInt();
            	arr[i][1] = sc.nextInt();
            	sum += arr[i][0] + arr[i][1];
            	
            	for(int j = 0; j < 3; j++)
            		Arrays.fill(dp[i][j], -1);
            }
            
            int res = Math.min(solve(0, 0, 0), Math.min(solve(0, 1, 0), solve(0, 2, 0)));
            System.out.println(sum - res);
        }
        
	}
	private static int solve(int idx, int d, int k) {
		if(k == K) return 0;
		if(idx == N) return 1000000000;
		if(dp[idx][d][k] != -1) return dp[idx][d][k];
		int ret = 1000000000;
		
		if(d == 0) {
			ret = Math.min(solve(idx + 1, 0, k), solve(idx + 1, 1, k + 1) + arr[idx][0]);
			ret = Math.min(ret, solve(idx + 1, 2, k + 1) + arr[idx][1]);
		}
		else if(d == 1)
			ret = Math.min(solve(idx + 1, 0, k), solve(idx + 1, 1, k + 1) + arr[idx][0]);
		else 
			ret = Math.min(solve(idx + 1, 0, k), solve(idx + 1, 2, k + 1) + arr[idx][1]);
		return dp[idx][d][k] = ret;
	}
}