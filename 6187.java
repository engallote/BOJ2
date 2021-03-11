import java.util.*;

public class Main {
	static int N, C;
	static int[] arr, dp;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        C = sc.nextInt();
        N = sc.nextInt();
        arr = new int[N];
        dp = new int[1<<N];
        
        Arrays.fill(dp, -1);
        for(int i = 0; i < N; i++)
        	arr[i] = sc.nextInt();
        
        int res = solve(0, 0, 0);
        System.out.println(res);
    }
	private static int solve(int idx, int chk, int sum) {
		if(idx == N) return 0;
		if(dp[chk] != -1) return dp[chk];
		
		int ret = 0;
		
		ret = Math.max(ret, solve(idx + 1, chk, sum));
		if(sum + arr[idx] <= C)
			ret = Math.max(ret, solve(idx + 1, chk|(1<<idx), sum + arr[idx]) + arr[idx]);
		
		return dp[chk] = ret;
	}
}