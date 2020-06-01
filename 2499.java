import java.util.*;

public class Main {
	static int N, res;
	static int[][] arr, sum;
	static int[][][] dp;
	static Queue<Integer> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		sum = new int[N][N];
		dp = new int[N][N+1][40001];
		q = new LinkedList<Integer>();
		res = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j <= N; j++){
				if(j < N) arr[i][j] = sc.nextInt();
				Arrays.fill(dp[i][j], -1);
			}
		
		
		for(int i = N - 1; i >= 0; i--)
			for(int j = 0; j < N; j++){
				sum[i][j] = arr[i][j];
				if(i < N - 1) sum[i][j] += sum[i+1][j];
			}
		
		ArrayList<Integer> path = new ArrayList<>();
		solve(0, 0, 0, 0, path);
		System.out.println(res);
		while(!q.isEmpty()) System.out.print(q.poll() + " ");
	}
	private static void solve(int idx, int num, int b, int d, ArrayList<Integer> path) {
		if(idx == N){
			if(Math.abs(b-d) < res){
				res = Math.abs(b-d);
				q.clear();
				for(int i : path) q.offer(i);
			}
			return;
		}
		if(dp[idx][num][b] != -1) return;
		
		for(int i = num; i <= N; i++){
			path.add(i);
			if(i == 0) solve(idx + 1, i, b, d + sum[0][idx], path);
			else solve(idx + 1, i, b + sum[N-i][idx], d + (sum[0][idx] - sum[N-i][idx]), path);
			path.remove(path.size()-1);
		}
		
		dp[idx][num][b] = 0;
	}
}