import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		dp = new int[N][1005];
		
		for(int i = 0; i < N; i++){
			arr[i] = sc.nextInt();
			Arrays.fill(dp[i], -1);
		}
		
		int res = solve(1, arr[0] + 2);
		System.out.println(res);
	}
	private static int solve(int idx, int c) {
		if(idx == N) return 0;
		if(dp[idx][c] != -1) return dp[idx][c];
		int ret = 1000000000;
		
		//이어쓰기
		if(c + arr[idx] - 1 <= M)
			ret = Math.min(ret, solve(idx + 1, c + arr[idx] + 1));
		
		//줄 바꿈
		int nc = M - c + 2;
		ret = Math.min(ret, solve(idx + 1, arr[idx] + 2) + (nc * nc));
		
		return dp[idx][c] = ret;
	}
}