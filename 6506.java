import java.util.*;

public class Main {
	static int N, K;
	static int[] arr;
	static long[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			N = sc.nextInt();
			K = sc.nextInt();
			
			if(N == 0 && K == 0) break;
			
			arr = new int[N];
			dp = new long[K][N];
			
			for(int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			
			for(int i = 0; i < K; i++)
				Arrays.fill(dp[i], -1);
			
			long res = solve(0, 0, -1000000);
			System.out.println(res);
		}
	}
	private static long solve(int cnt, int idx, int num) {
		if(idx >= N){
			if(cnt == K) return 1;
			else return 0;
		}
		if(cnt >= K) return 1;
		if(dp[cnt][idx] != -1) return dp[cnt][idx];
		long ret = 0;
		
		for(int i = idx; i < N; i++)
			if(arr[i] > num)
				ret += solve(cnt + 1, i + 1, arr[i]);
		
		return dp[cnt][idx] = ret;
	}
}