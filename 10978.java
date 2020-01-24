import java.util.*;

public class Main {
	static int N;
	static long[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(--T >= 0){
			N = sc.nextInt();
			dp = new long[1<<N];
			
			Arrays.fill(dp, -1);
			long res = solve(0, 0);
			System.out.println(res);
		}
	}
	private static long solve(int idx, int cnt) {
		if(idx == N) return 1;
		if(dp[cnt] != -1) return dp[cnt];
		long ret = 0;
		
		for(int i = 0; i < N; i++)
			if((cnt&(1<<i))==0 && idx != i)
				ret += solve(idx + 1, cnt|(1<<i));
		return dp[cnt] = ret;
	}
}