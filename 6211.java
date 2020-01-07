import java.util.*;

public class Main {
	static int C, B, max = 0;
	static int[] arr;
	static int[] dp = new int[4200000];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		B = sc.nextInt();
		arr = new int[B];
		Arrays.fill(dp, -1);
		for(int i = 0; i < B; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		
		solve(0, 0, 0);
		System.out.println(max);
	}
	private static int solve(int idx, int chk, int sum) {
		if(idx == B) return 0;
		if(sum > C) return -5000000;
		if(dp[chk] != -1) return dp[chk];
		max = Math.max(max, sum);
		int ret = 0;
		
		ret = Math.max(ret, solve(idx + 1, chk|(1<<idx), sum + arr[idx]) + arr[idx]);
		ret = Math.max(ret, solve(idx + 1, chk, sum));
		
		return dp[chk] = ret;
	}
}