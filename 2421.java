import java.util.*;

public class Main {
	static int N;
	static int[][] dp;
	static HashSet<Integer> hs = new HashSet<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new int[1000][1000];
		boolean[] chk = new boolean[10000001];
		chk[11] = true;
		for(int i = 2; i <= 10000000; i++)
		{
			if(!chk[i]) hs.add(i);
			for(int j = i + i; j <= 10000000; j+=i) chk[j] = true;
		}
		
		for(int i = 0; i < 1000; i++)
			Arrays.fill(dp[i], -1);
		
		int res = solve(1, 1);
		System.out.println(res);
	}
	private static int solve(int a, int b) {
		if(a == N && b == N) 
		{
			String str = a + "" + b;
			if(hs.contains(Integer.parseInt(str))) return 1;
			return 0;
		}
		if(a > N || b > N) return -100000000;
		if(dp[a][b] != -1) return dp[a][b];
		int ret = 0;
		String str = a + "" + b;
		if(hs.contains(Integer.parseInt(str)))
		{
			ret = Math.max(ret, solve(a + 1, b) + 1);
			ret = Math.max(ret, solve(a, b + 1) + 1);
		}
		else
		{
			ret = Math.max(ret, solve(a + 1, b));
			ret = Math.max(ret, solve(a, b + 1));
		}
		return dp[a][b] = ret;
	}
}