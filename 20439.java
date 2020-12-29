import java.util.*;

public class Main {
	static int N, K;
	static int[] arr, time;
	static int[][][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[K];
		dp = new int[N + 2][1441][1<<K+2];
		time = new int[N + 2];
		
		int s = sc.nextInt();
		int e = sc.nextInt();
		int idx = 0;
		
		if(s > 0) time[idx++] = s;
		
		for(int i = 1; i < N; i++) {
			int ns = sc.nextInt();
			int ne = sc.nextInt();
			
			if(ns > e) time[idx++] = ns - e;
			s = ns;
			e = ne;
		}
		
		if(e < 1440) time[idx++] = 1440 - e;
		for(int i = 0; i < N + 2; i++)
			for(int j = 0; j <= 1440; j++)
				Arrays.fill(dp[i][j], -1);
		
		for(int i = 0; i < K; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		Arrays.sort(time);
		
		int res = solve(0, 0, 0, 0);
		
		if(res > 0) System.out.println("GOOD");
		else System.out.println("BAD");
	}
	private static int solve(int idx, int chk, int tIdx, int s) {
		if(idx == K) {
			return 1;
		}
		if(dp[tIdx][s][chk] != -1) return dp[tIdx][s][chk];
		
		int ret = 0;
		for(int i = 0; i < time.length; i++) {
			if(time[i]>= arr[idx]) {
				int tmp = time[i];
				int space = tmp - arr[idx];
				time[i] = space;
				
				ret = Math.max(ret, solve(idx + 1, chk|(1<<idx), i, space));
				
				time[i] = tmp;
			}
		}
		return dp[tIdx][s][chk] = ret; 
	}
}