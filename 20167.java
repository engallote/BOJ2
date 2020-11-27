import java.util.*;

public class Main {
	static int N, K, res = 0;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		solve(0, 0, 0);
		System.out.println(res);
	}
	private static void solve(int idx, int cur, int sum) {
		if(idx == N) {
			int tmp = 0;
			if(cur > K) tmp = K - cur;
			res = Math.max(res, sum + tmp);
			return;
		}
		
		if(cur == 0) solve(idx + 1, 0, sum);
		if(arr[idx] + cur < K) solve(idx + 1, cur + arr[idx], sum);
		else solve(idx + 1, 0, sum + ((arr[idx] + cur) - K));
	}
}