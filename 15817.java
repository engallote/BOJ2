import java.util.*;

public class Main {
	static int N, X;
	static int[][] arr, dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		X = sc.nextInt();
		arr = new int[N][2];
		dp = new int[N][X];
		
		for(int i = 0; i < N; i++)
		{
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			Arrays.fill(dp[i], -1);
		}
		
		int res = solve(0, 0);
		System.out.println(res);
	}
	private static int solve(int x, int idx) {
		if(x == X) return 1;
		if(x > X || idx >= N) return 0;
		if(dp[idx][x] != -1) return dp[idx][x];
		int ret = 0;
		
		for(int k = 0; k <= arr[idx][1]; k++)
				ret += solve(x + (arr[idx][0]) * k, idx + 1);
		
		return dp[idx][x] = ret;
	}
}