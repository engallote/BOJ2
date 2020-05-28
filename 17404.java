import java.util.*;

public class Main {
	static int N;
	static int[][] arr, dp;
	static int[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N + 1][4];
		dp = new int[N + 1][4];
		chk = new int[N + 1];
		
		for(int i = 1; i <= N; i++)
			for(int j = 1; j <= 3; j++)
				arr[i][j] = sc.nextInt();
		
		int res = Integer.MAX_VALUE;
		
		for(int k = 1; k <= 3; k++){
			Arrays.fill(dp[1], 10000000);
			dp[1][k] = arr[1][k];
			
			for(int i = 2; i <= N; i++){
				dp[i][1] = Math.min(dp[i-1][2], dp[i-1][3]) + arr[i][1];
				dp[i][2] = Math.min(dp[i-1][1], dp[i-1][3]) + arr[i][2];
				dp[i][3] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][3];
			}
			
			for(int i = 1; i <= 3; i++)
				if(i != k)
					res = Math.min(res, dp[N][i]);
		}
		
		System.out.println(res);
	}
}