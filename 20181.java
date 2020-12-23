import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		long[] arr = new long[N], dp = new long[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextLong();
		
		int l = 0, r = 0;
		long max = -1, sum = 0;
		while(true) {
			if(sum >= K) {
				if(l == 0) max = 0;
				else max = Math.max(max, dp[l - 1]);
				dp[r - 1] = Math.max(dp[r - 1], max + sum - K);
				sum -= arr[l++];
			}
			else if(r == N) break;
			else sum += arr[r++];
		}
		
		max = -1;
		for(int i = 0; i < N; i++)
			max = Math.max(max, dp[i]);
		
		System.out.println(max);
	}
}