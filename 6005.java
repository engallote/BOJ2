import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N], dp = new int[N][N];
		for(int i = 0; i < N; i++)
			for(int j = 0; j <= i; j++)
				arr[i][j] = sc.nextInt();
		
		dp[0][0] = arr[0][0];
		
		for(int i = 1; i < N; i++)
			for(int j = 0; j < i; j++){
				dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + arr[i][j]);
				dp[i][j+1] = Math.max(dp[i][j+1], dp[i-1][j] + arr[i][j+1]);
			}
		
		int res = 0;
		for(int i = 0; i < N; i++)
			res = Math.max(res, dp[N-1][i]);
		
		System.out.println(res);
	}
}