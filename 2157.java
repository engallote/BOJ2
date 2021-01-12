import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr, dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int K = sc.nextInt();
		arr = new int[N+1][N+1];
		dp = new int[N+1][M+1];
		
		for(int i = 1; i <= N; i++)
			Arrays.fill(dp[i], -1);
		
		for(int i = 0; i < K; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			arr[a][b] = Math.max(arr[a][b], c);
		}
		
		dp[1][0] = 0;
		for(int i = 2; i <= N; i++)
			for(int j = 1; j < i; j++)
				for(int k = 1; k < M; k++)
					if(dp[j][k-1] != -1 && arr[j][i] > 0)
						dp[i][k] = Math.max(dp[i][k], dp[j][k - 1] + arr[j][i]);
		
		int res = 0;
		for(int i = 1; i < M; i++)
			res = Math.max(res, dp[N][i]);
		
		System.out.println(res);
	}
}