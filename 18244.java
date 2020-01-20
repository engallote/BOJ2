import java.util.*;

public class Main {
	static int N;
	static long mod = 1000000007;
	static int[] arr;
	static long[][][][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		dp = new long[N][3][3][11];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < 3; j++)
				for(int k = 0; k < 3; k++)
					Arrays.fill(dp[i][j][k], -1);
			
		long res = solve(0, 0, 0, 10);
		System.out.println(res);
	}
	private static long solve(int cnt, int up, int down, int idx) {
		if(cnt == N) return 1;
		if(dp[cnt][up][down][idx] != -1) return dp[cnt][up][down][idx] % mod;
		
		long ret = 0;
		if(idx == 10){
			for(int i = 0; i < 10; i++)
				ret += solve(cnt + 1, up, down, i) % mod;
		}
		else{
			if(idx - 1 >= 0 && down + 1 < 3) ret += solve(cnt + 1, 0, down + 1, idx - 1) % mod;
			if(idx + 1 < 10 && up + 1 < 3) ret += solve(cnt + 1, up + 1, 0, idx + 1) % mod;
		}
		
		return dp[cnt][up][down][idx] = ret % mod;
	}
}