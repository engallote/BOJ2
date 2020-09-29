import java.util.*;

public class Main {
	static int N, M;
	static long[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		dp = new long[11][2001];
		
		for(int i = 1; i <= 2000; i++)
			dp[1][i] = i;
		
		for(int i = 2; i <= 10; i++)
			for(int j = 1; j <= 2000; j++)
				dp[i][j] += dp[i - 1][j / 2] + dp[i][j - 1];
		
		while(--T >= 0) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			if(N == 1) {
				System.out.println(M);
				continue;
			}
			
			System.out.println(dp[N][M]);
		}
	}
}