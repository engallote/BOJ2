import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N + 1];
		dp = new int[N + 1][N + 1];
		arr[0] = 1000000;
		Arrays.fill(dp[0], -1);
		for(int i = 1; i <= N; i++){
			arr[i] = sc.nextInt();
			Arrays.fill(dp[i], -1);
		}
		
		int res = solve(1, 0);
		System.out.println(res);
	}
	private static int solve(int idx, int cnt) {
		if(idx > N) return 0;
		if(dp[idx][cnt] != -1) return dp[idx][cnt];
		int ret = 0;
		
		for(int i = idx; i <= N; i++)
			if(arr[idx-1] > arr[i]) ret = Math.max(ret, solve(i + 1, cnt + 1) + arr[i]);
		
		return dp[idx][cnt] = ret;
	}
}