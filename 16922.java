import java.util.*;

public class Main {
	static int N;
	static int[] arr = {1, 5, 10, 50};
	static int[][] dp;
	static HashSet<Integer> hs = new HashSet<>();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[20][10000];
        
        for(int i = 0; i < 20; i++)
        	Arrays.fill(dp[i], -1);
        
        solve(0, 0);
        System.out.println(hs.size());
    }
	private static int solve(int idx, int num) {
		if(idx == N) {
			if(hs.contains(num)) return 0;
			hs.add(num);
			return 1;
		}
		if(dp[idx][num] != -1) return dp[idx][num];
		int ret = 0;
		for(int i = 0; i < 4; i++)
			ret += solve(idx + 1, num + arr[i]);
		
		return dp[idx][num] = ret;
	}
}