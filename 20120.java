import java.util.*;

public class Main {
	static int N;
	static long[] arr;
	static long[][][] dp;
	static boolean[][][] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new long[N];
		dp = new long[N][N + 1][3];
		chk = new boolean[N][N + 1][3];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextLong();
		
		long res = 0;
		
		res = Math.max(0l, solve(0, 1, 0));
		System.out.println(res);
	}
	private static long solve(int idx, int num, int miss) {
		if(idx == N) return 0;
		if(chk[idx][num][miss]) return dp[idx][num][miss];
		chk[idx][num][miss] = true;
		long ret = 0;
		
		ret = solve(idx + 1, num + 1, 0) + arr[idx] * num;
		if(miss < 2)
			ret = Math.max(ret, solve(idx + 1, 1, miss + 1));
		
		return dp[idx][num][miss] = ret;
	}
}