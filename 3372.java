import java.math.BigInteger;
import java.util.*;

public class Main {
	static int N;
	static int[][] arr;
	static BigInteger[][] dp;
	static int[] dx = {1, 0}, dy = {0, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		dp = new BigInteger[N][N];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++){
				arr[i][j] = sc.nextInt();
				dp[i][j] = new BigInteger("-1");
			}
		
		BigInteger res = solve(0, 0);
		System.out.println(res);
	}
	private static BigInteger solve(int x, int y) {
		if(x == N - 1 && y == N - 1) return BigInteger.ONE;
		if(arr[x][y] == 0) return BigInteger.ZERO;
		if(dp[x][y].compareTo(new BigInteger("-1")) != 0) return dp[x][y];
		BigInteger ret = BigInteger.ZERO;
		
		for(int i = 0; i < 2; i++){
			int nx = x + dx[i] * arr[x][y], ny = y + dy[i] * arr[x][y];
			if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
			ret = ret.add(solve(nx, ny));
		}
		
		return dp[x][y] = ret;
	}
}