import java.util.*;

public class Main {
	static int N, M, res;
	static int[][] arr, dp;
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M][2];
		dp = new int[N][6001];
		res = 0;
		chk = new boolean[M];
		for(int i = 0; i < M; i++)
		{
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		for(int i = 0; i < N; i++) Arrays.fill(dp[i], -1);
		
		solve(0, 0);
		System.out.println(res);
	}
	private static int solve(int day, int cnt) {
		res = Math.max(res, cnt);
		if(day == N) return cnt;
		if(dp[day][cnt] != -1) return dp[day][cnt];
		int ret = 0;
		for(int i = 0; i < M; i++)
			if(!chk[i] && day + arr[i][0] <= N)
			{
				chk[i] = true;
				ret = Math.max(ret, solve(day + arr[i][0], cnt + arr[i][1]));
				chk[i] = false;
			}
		
		return dp[day][cnt] = ret;
	}
}