import java.util.*;

public class Main {
	static int N, K;
	static ArrayList<Integer>[] arr;
	static int[][][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new ArrayList[N+1];
		dp = new int[N+1][21][K+1];
		
		for(int i = 0; i <= N; i++)
			for(int j = 0; j <= 20; j++)
				Arrays.fill(dp[i][j], -1);
		
		for(int i = 1; i <= N; i++){
			arr[i] = new ArrayList<>();
			int M = sc.nextInt();
			for(int j = 0; j < M; j++)
				arr[i].add(sc.nextInt());
		}
		
		int res = solve(1, 1, 0);
		if(res == 1000000) res = -1;
		System.out.println(res);
	}
	private static int solve(int idx, int h, int k) {
		if(idx > N) return 0;
		if(dp[idx][h][k] != -1) return dp[idx][h][k];
		int ret = 1000000;
		
		for(int next : arr[idx]){
			if(next == h + 1 || next == h - 1 || (h < 10 && next == h * 2) || next == h)
				ret = Math.min(ret, solve(idx + 1, next, k));
			if(next == 20 && h >= 10)
				ret = Math.min(ret, solve(idx + 1, next, k));
			if(k + 1 <= K) ret = Math.min(ret, solve(idx + 1, next, k + 1) + 1);
		}
		return dp[idx][h][k] = ret;
	}
}