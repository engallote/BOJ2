import java.util.*;

public class Main {
	static int K, N, M;
	static ArrayList<Pair>[] arr;
	static int[][] dp;
	static int[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		N = sc.nextInt();
		M = sc.nextInt();
		chk = new int[N+1];
		arr = new ArrayList[N+1];
		dp = new int[N+1][10001];
		Arrays.fill(chk, Integer.MAX_VALUE);
		for(int i = 0; i <= N; i++){
			Arrays.fill(dp[i], -1);
			arr[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++)
			arr[sc.nextInt()].add(new Pair(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		
		int res = solve(1, 0);
		if(res == 1000000) res = -1;
		System.out.println(res);
	}
	private static int solve(int idx, int sum) {
		if(idx == N) return 0;
		if(dp[idx][sum] != -1) return dp[idx][sum];
		dp[idx][sum] = 1000000;
		
		for(Pair next : arr[idx])
			if(sum + next.t <= K && next.v != idx)
				dp[idx][sum] = Math.min(dp[idx][sum], solve(next.v, sum + next.t) + next.l);
		
		return dp[idx][sum];
	}
}
class Pair{
	int v, l, t;
	Pair(int v, int l, int t){
		this.v = v;
		this.l = l;
		this.t = t;
	}
}