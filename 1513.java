import java.util.*;

public class Main {
	static int N, M, C, mod = 1000007;
	static int[][] arr;
	static int[][][][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		C = sc.nextInt();
		arr = new int[N+1][M+1];
		
		for(int i = 1; i <= C; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y] = i;
		}
		dp = new int[N+1][M+1][C+1][C+1];
		
		int res = 0;
		for(int i = 0; i <= C; i++){
			for(int j = 0; j <= N; j++)
				for(int k = 0; k <= M; k++)
					for(int l = 0; l <= C; l++)
						Arrays.fill(dp[j][k][l], -1);
			int count = 0;
			if(arr[1][1] > 0) ++count;
			res = solve(1, 1, arr[1][1], count, i) % mod;
			System.out.print(res + " ");
		}
	}
	private static int solve(int x, int y, int idx, int cnt, int total) {
		if(x == N && y == M){
			if(cnt == total) return 1;
			return 0;
		}
		if(dp[x][y][idx][cnt] != -1) return dp[x][y][idx][cnt];
		int ret = 0;
		if(x + 1 <= N){
			if(arr[x+1][y] == 0)
				ret += solve(x + 1, y, idx, cnt, total) % mod;
			else if(arr[x+1][y] > idx && cnt + 1 <= total)
				ret += solve(x + 1, y, arr[x+1][y], cnt + 1, total) % mod;
		}
		if(y + 1 <= M){
			if(arr[x][y+1] == 0)
				ret += solve(x, y + 1, idx, cnt, total) % mod;
			else if(arr[x][y+1] > idx && cnt + 1 <= total)
				ret += solve(x, y + 1, arr[x][y+1], cnt + 1, total) % mod;
		}
		return dp[x][y][idx][cnt] = ret % mod;
	}
}