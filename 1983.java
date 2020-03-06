import java.util.*;

public class Main {
	static int N, len1, len2;
	static int[] arr1, arr2;
	static int[][][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr1 = new int[N];
		arr2 = new int[N];
		dp = new int[N][N][N];
		Random rd = new Random();
		int idx = 0, num;
		for(int i = 0; i < N; i++){
			num = sc.nextInt();
			if(num != 0) arr1[idx++] = num;
			for(int j = 0; j < N; j++)
				Arrays.fill(dp[i][j], -1000000000);
		}
		len1 = idx;
		idx = 0;
		
		for(int i = 0; i < N; i++){
			num = sc.nextInt();
			if(num != 0) arr2[idx++] = num;
		}
		len2 = idx;
		
		int res = solve(0, 0, 0);
		System.out.println(res);
	}
	private static int solve(int cnt, int idx1, int idx2) {
        if(idx1 >= len1 || idx2 >= len2) return 0;
		if(cnt >= N) return -100000000;
		if(dp[cnt][idx1][idx2] != -1000000000) return dp[cnt][idx1][idx2];
		int ret = -100000000;
		
		ret = solve(cnt + 1, idx1 + 1, idx2 + 1) + (arr1[idx1] * arr2[idx2]);
		if(len1 - idx1 + cnt < N) ret = Math.max(ret, solve(cnt + 1, idx1, idx2 + 1));
		if(len2 - idx2 + cnt < N) ret = Math.max(ret, solve(cnt + 1, idx1 + 1, idx2));
		
		return dp[cnt][idx1][idx2] = ret;
	}
}