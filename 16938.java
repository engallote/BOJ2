import java.util.*;

public class Main {
	static int N, L, R, X;
	static int[] arr;
	static long[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		X = sc.nextInt();
		
		arr = new int[N];
		dp = new long[1<<N];
		Arrays.fill(dp, -1);
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		long res = solve(0, 0, 0, Integer.MAX_VALUE, -1);
		System.out.println(res);
	}
	private static long solve(int idx, int chk, int sum, int min, int max) {
		if(idx >= N) {
			if(chk == 0 || max - min < X || sum < L) return 0;
			return 1;
		}
		if(dp[chk] != -1) return dp[chk];
		long ret = 0;
		if(max - min >= X && sum >= L && sum <= R) ret += 1;
		
		for(int i = idx; i < N; i++)
			if((chk&(1<<i))==0)
				if(sum + arr[i] <= R)
					ret += solve(i + 1, chk|(1<<i), arr[i]+sum, Math.min(arr[i], min), Math.max(arr[i], max));
		
		return dp[chk] = ret;
	}
}