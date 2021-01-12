import java.util.*;

public class Main {
	static int N, M, K;
	static long[] arr, dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		arr = new long[N + 1];
		dp = new long[N + 1];
		
		for(int i = 1; i <= N; i++)
			arr[i] = sc.nextLong();
		
		for(int i = 1; i <= N; i++) {
			dp[i] = Long.MAX_VALUE;
			long max = arr[i], min = arr[i];
			for(int j = i; j >= Math.max(1, i - M + 1); j--) {
				max = Math.max(max, arr[j]);
				min = Math.min(min, arr[j]);
				
				dp[i] = Math.min(dp[i], dp[j - 1] + K + (i - j + 1) * (max - min));
			}
		}
		
		System.out.println(dp[N]);
	}
}