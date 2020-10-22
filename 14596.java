import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr1 = new int[N][M], arr2 = new int[N][M], dp = new int[N][M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++) {
				arr1[i][j] = sc.nextInt();
				dp[i][j] = 1000000000;
			}
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				arr2[i][j] = sc.nextInt();
		
		for(int i = 0; i < M; i++)
			dp[0][i] = pow(arr1[0][i], arr2[0][i]);
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < M; j++) {
				int num =  pow(arr1[i][j], arr2[i][j]);
				dp[i][j] = dp[i-1][j] + num;
				if(j - 1 >= 0) dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + num);
				if(j + 1 < M) dp[i][j] = Math.min(dp[i][j], dp[i-1][j+1] + num);
			}
		}
		
		int res = Integer.MAX_VALUE;
		for(int i = 0; i < M; i++)
			res = Math.min(res, dp[N-1][i]);
		
		System.out.println(res);
	}

	private static int pow(int x, int y) {
		return (x - y) * (x - y);
	}
}