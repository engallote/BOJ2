import java.util.*;

public class Main {
	static int N, M, K;
	static long[][][] dp;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();//±Ê¿Ã
    	M = sc.nextInt();
    	K = sc.nextInt();
    	dp = new long[N][31][K + 1];
    	
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < 31; j++)
    			Arrays.fill(dp[i][j], -1);
    	
    	long res = solve(0, 1, 0);
    	System.out.println(res);
	}

	private static long solve(int cnt, int num,  int s) {
		if(cnt == N) return 1;
		if(dp[cnt][num][s] != -1) return dp[cnt][num][s];
		long ret = 0;
		
		for(int i = num; i <= M; i++) {
			if(num == i && s < K) {
				ret += solve(cnt + 1, i, s + 1);
			}
			else if(num != i) {
				ret += solve(cnt + 1, i, 1);
			}
		}
		
		return dp[cnt][num][s] = ret;
	}
}