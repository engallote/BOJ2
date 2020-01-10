import java.util.*;

public class Main {
	static int N, M, K;
	static int[][] arr;
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		arr = new int[M][K];
		dp = new int[1<<21];
		Arrays.fill(dp, -1);
		
		for(int i = 0 ; i < M; i++)
			for(int j = 0; j < K; j++)
				arr[i][j] = sc.nextInt() - 1;
		
		int res = solve(0, 0, 0);
		System.out.println(res);
	}
	private static int solve(int cnt, int idx, int chk) {
		if(cnt == N){
			int sum = 0;
			boolean flag;
			for(int i = 0; i < M; i++){
				flag = true;
				for(int j = 0; j < K; j++)
					if((chk&(1<<arr[i][j])) == 0) {
						flag = false;
						break;
					}
				if(flag) ++sum;
			}
				
			return sum;
		}
		if(idx >= 2*N) return Integer.MIN_VALUE;
		if(dp[chk] != -1) return dp[chk];
		int ret = 0;
		
		ret = Math.max(ret, solve(cnt, idx + 1, chk));
		ret = Math.max(ret, solve(cnt + 1, idx + 1, chk|(1<<idx)));
		
		return dp[chk] = ret;
	}
}