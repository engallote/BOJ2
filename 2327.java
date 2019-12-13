import java.util.*;

public class Main {
	static int N, H;
	static int[][] dp;
	static Pair[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		H = sc.nextInt();
		N = sc.nextInt();
		arr = new Pair[N];
		dp = new int[H+1][N];
		
		for(int i = 0; i < N; i++)
			arr[i] = new Pair(sc.nextInt(), sc.nextInt());
		
		Arrays.sort(arr);
		
		for(int i = 0; i <= H; i++)
			Arrays.fill(dp[i], -1);
		
		int res = solve(0, 0, 1000000);
		System.out.println(res);
	}
	private static int solve(int h, int idx, int min) {
		if(h == H) return min;
		if(idx == N) return 0;
		if(dp[h][idx] != -1) return dp[h][idx];
		int ret = 0;
		if(h + arr[idx].h <= H)
			ret = Math.max(ret, solve(h + arr[idx].h, idx + 1, Math.min(min, arr[idx].s)));
		ret = Math.max(ret, solve(h, idx + 1, min));
		return dp[h][idx] = ret;
	}
}
class Pair implements Comparable<Pair>{
	int h, s;
	Pair(int h, int s)
	{
		this.h = h;
		this.s = s;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.s > this.s) return 1;
		else if(o.s == this.s)
		{
			if(o.h > this.h) return 1;
			else if(o.h == this.h) return 0;
			else return -1;
		}
		else return -1;
	}
}