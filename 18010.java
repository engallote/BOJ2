import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	static boolean[] chk;
	static int[][] dp;
	static ArrayList<Integer>[] aly;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++){
			N = sc.nextInt();
			M = sc.nextInt();
			chk = new boolean[N + 1];
			arr = new int[N + 1];
			aly = new ArrayList[N + 1];
			dp = new int[N+1][N+1];
			
			for(int i = 1; i <= N; i++){
				arr[i] = sc.nextInt();
				aly[i] = new ArrayList<>();
				Arrays.fill(dp[i], -1);
			}
			
			for(int i = 0; i < M; i++){
				int a = sc.nextInt();
				int b = sc.nextInt();
				aly[a].add(b);
				aly[b].add(a);
			}
			
			int start = sc.nextInt();
			chk[start] = true;
			int res = solve(start, start, 1, arr[start]);
			
			System.out.println("Data Set " + test_case + ": ");
			System.out.println(res);
			System.out.println();
		}
	}
	private static int solve(int cur, int pre, int cnt, int sum) {
		int ret = sum;
		if(dp[cur][cnt] != -1) return dp[cur][cnt];
		dp[cur][cnt] = ret;
		
		for(int next : aly[cur])
			if(next != pre){
				if(chk[next]) ret = Math.max(ret, solve(next, cur, cnt, sum));
				else{
					chk[next] = true;
					ret = Math.max(ret, solve(next, cur, cnt + 1, sum + arr[next]));
					chk[next] = false;
				}
			}
		return dp[cur][cnt] = ret;
	}
}