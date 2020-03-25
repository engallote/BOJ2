import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	static int[][] dp = new int[10001][200];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1];
		
		for(int i = 0; i < M; i++)
			arr[sc.nextInt()] = -1;
		
		for(int i = 1; i <= N; i++)
			Arrays.fill(dp[i], -1);
		
		int res = solve(2, 1);
		
		if(res == 1000000000) System.out.println(-1);
		else System.out.println(res+1);
	}
	private static int solve(int idx, int x) {
		if(idx == N) return 0;
		if(idx > N) return 1000000000;
		if(arr[idx] == -1) return 1000000000;
		if(dp[idx][x] != -1) return dp[idx][x];
		int ret = 1000000000;
		
		ret = Math.min(ret, solve(idx + x, x) + 1);
		ret = Math.min(ret, solve(idx + x + 1, x + 1) + 1);
		if(x - 1 > 0) ret = Math.min(ret, solve(idx + (x - 1), x - 1) + 1);
		
		return dp[idx][x] = ret;
	}
}