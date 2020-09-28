import java.util.*;

public class Main {
	static int N;
	static int[] arr, chk;
	static int[][] dp;
	static ArrayList<Integer>[] aly;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N + 1];
		chk = new int[N + 1];
		dp = new int[N + 1][2];
		aly = new ArrayList[N + 1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
			aly[i] = new ArrayList<>();
			chk[i] = -1;
			Arrays.fill(dp[i], -1);
		}
		
		for(int i = 1; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			aly[a].add(b);
			aly[b].add(a);
		}
		
		int res = Math.max(solve(1, 1) + arr[1], solve(1, 0));
		System.out.println(res);
	}
	private static int solve(int idx, int p) {		
		if(dp[idx][p] != -1) return dp[idx][p];
		chk[idx] = p;
		int ret = 0;
		
		for(int next : aly[idx]) {
			if(chk[next] != -1) continue;
			if(p == 1)
				ret += solve(next, 0);
			else
				ret += Math.max(solve(next, 1) + arr[next], solve(next, 0));
		}
		
		chk[idx] = -1;
		return dp[idx][p] = ret;
	}
}