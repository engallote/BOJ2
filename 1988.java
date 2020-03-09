import java.util.*;

public class Main {
	static int N, B;
	static int[][][] dp;
	static int[] arr, sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		B = sc.nextInt();
		arr = new int[N + 1];
		sum = new int[N + 1];
		dp = new int[3][N + 1][B + 1];
		
		for(int i = 1; i <= N; i++){
			arr[i] = sc.nextInt();
			sum[i] = arr[i] + sum[i-1];
		}
		
		if(N == B){
			System.out.println(sum[N-1] - arr[0]);
			return;
		}
		
		for(int i = 0; i < 3; i++)
			for(int j = 0; j <= N; j++)
				Arrays.fill(dp[i][j], -1);
		
		int res = solve(0, 0, 0);
		System.out.println(res);
	}
	private static int solve(int s, int idx, int cnt) {
		if(cnt == B) return 0;
		if(idx > N) return -100000000;
		if(dp[s][idx][cnt] != -1) return dp[s][idx][cnt];
		int ret = 0;
		
		if(s == 0){//초기
			ret = Math.max(solve(1, idx + 1, cnt + 1), solve(2, idx + 1, cnt));
		}
		else if(s == 1){//자고 있음
			if(idx + 1 <= N)
				ret = Math.max(ret, solve(s, idx + 1, cnt + 1) + arr[idx + 1]);//계속 자기
			ret = Math.max(ret, solve(2, idx + 1, cnt));//깨기
		}
		else{//깨어있음
			ret = Math.max(ret, solve(s, idx + 1, cnt));//계속 깨어있기
			ret = Math.max(ret, solve(1, idx + 1, cnt + 1));//자기
		}
		return dp[s][idx][cnt] = ret;
	}
}