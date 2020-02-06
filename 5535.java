import java.util.*;

public class Main {
	static int N, M;
	static int[] D;
	static int[][] arr, dp;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        D = new int[N];
        arr = new int[M + 1][3];
        dp = new int[N][M+1];
        
        for(int i = 0; i < N; i++){
        	D[i] = sc.nextInt();
        	Arrays.fill(dp[i], -1);
        }
        
        for(int i = 1; i <= M; i++){
        	arr[i][0] = sc.nextInt();
        	arr[i][1] = sc.nextInt();
        	arr[i][2] = sc.nextInt();
        }
        
        int res = solve(0, 0);
        System.out.println(res);
    }
	private static int solve(int d, int idx) {
		if(d == N) return 0;
		if(dp[d][idx] != -1) return dp[d][idx];
		int ret = 0;
		
		for(int i = 1; i <= M; i++)
			if(arr[i][0] <= D[d] && D[d] <= arr[i][1]){
				if(idx == 0) ret = Math.max(ret, solve(d + 1, i));
				else ret = Math.max(ret, solve(d + 1, i) + Math.abs(arr[i][2] - arr[idx][2]));
			}
			
		return dp[d][idx] = ret;
	}
}