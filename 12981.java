import java.util.*;

public class Main {
	static int[][][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int g = sc.nextInt();
		int b = sc.nextInt();
		dp = new int[101][101][101];
		
		for(int i = 0; i <= 100; i++)
			for(int j = 0; j <= 100; j++)
				Arrays.fill(dp[i][j], -1);
		
		int res = solve(r, g, b);
		System.out.println(res);
	}
	private static int solve(int r, int g, int b) {
		if(r == 0 && g == 0 && b == 0) return 0;
		if(dp[r][g][b] != -1) return dp[r][g][b];
		int ret = Integer.MAX_VALUE;
		
		//3개
		if(r > 0 && g > 0 && b > 0) ret = Math.min(ret, solve(r-1,g-1,b-1) + 1);
		if(r >= 3) ret = Math.min(ret, solve(r-3,g,b)+1);
		if(g >= 3) ret = Math.min(ret, solve(r,g-3,b)+1);
		if(b >= 3) ret = Math.min(ret, solve(r,g,b-3)+1);
		//2개
		if(r >= 2) ret = Math.min(ret, solve(r-2,g,b)+1);
		if(r >= 1)
		{
			if(g >= 1) ret = Math.min(ret, solve(r-1,g-1,b)+1);
			if(b >= 1) ret = Math.min(ret, solve(r-1,g,b-1)+1);
		}
		if(g >= 2) ret = Math.min(ret, solve(r,g-2,b)+1);
		if(g >= 1)
		{
			if(r >= 1) ret = Math.min(ret, solve(r-1,g-1,b)+1);
			if(b >= 1) ret = Math.min(ret, solve(r,g-1,b-1)+1);
		}
		if(b >= 2) ret = Math.min(ret, solve(r,g,b-2)+1);
		if(b >= 1){
			if(r >= 1) ret = Math.min(ret, solve(r-1,g,b-1)+1);
			if(g >= 1) ret = Math.min(ret, solve(r,g-1,b-1)+1);
		}
		//1개
		if(r >= 1) ret = Math.min(ret, solve(r-1,g,b)+1);
		if(g >= 1) ret = Math.min(ret, solve(r,g-1,b)+1);
		if(b >= 1) ret = Math.min(ret, solve(r,g,b-1)+1);
		return dp[r][g][b] = ret;
	}
}