import java.util.*;

public class Main {
	static int N;
	static int[] arr, dp;
	static HashSet<Integer> hs;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	arr = new int[N];
    	dp = new int[1100000];
    	Arrays.fill(dp, -1);
    	
    	int sum = 0;
    	for(int i = 0; i < N; i++) {
    		arr[i] = sc.nextInt();
    		sum += arr[i];
    	}
    	
    	hs = new HashSet<>();
    	solve(0, 0);
    	
    	int res = sum - (hs.size() - 1);
    	
    	System.out.println(res);
	}
	private static int solve(int idx, int sum) {
		hs.add(sum);
		if(dp[idx] != -1) return dp[idx];
		
		for(int i = 0; i < N; i++)
			if((idx&(1<<i)) == 0)
				solve(idx|(1<<i), sum + arr[i]);
		
		return dp[idx] = sum;
	}
}