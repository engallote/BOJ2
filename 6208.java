import java.util.*;

public class Main {
	static int L, N, B;
	static Pair[] arr;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		N = sc.nextInt();
		B = sc.nextInt();
		arr = new Pair[N];
		dp = new int[L+1][B+1];
		
		for(int i = 0; i < N; i++)
			arr[i] = new Pair(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
		
		Arrays.sort(arr);
		
		for(int i = 0; i <= L; i++)
			Arrays.fill(dp[i], -1);
		
		int res = solve(0, 0, B);
		System.out.println(res <= 0 ? -1 : res);
	}
	private static int solve(int idx, int s, int b) {
		if(s == L) return 0;
		if(idx == N) return -100000000;
		if(dp[s][b] != -1) return dp[s][b];
		int ret = -100000000;
		
		for(int i = idx; i < N; i++)
			if(arr[i].x == s && b - arr[i].cost >= 0)
				ret = Math.max(ret, solve(i + 1, arr[i].x + arr[i].w, b - arr[i].cost) + arr[i].f);
		
		return dp[s][b] = ret;
	}
}
class Pair implements Comparable<Pair>{
	int x, w, f, cost;
	Pair(int x, int w, int f, int cost){
		this.x = x;
		this.w = w;
		this.f = f;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return o.x > this.x ? -1 : (o.x == this.x ? 0 : 1);
	}
}