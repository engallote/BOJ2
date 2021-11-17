import java.util.*;

public class Main {
	static int N, M;
	static HashSet<Integer>[] hs;
	static int[] dp, arr;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	hs = new HashSet[N];
    	dp = new int[M];
    	arr = new int[M];
    	
    	for(int i = 0; i < N; i++) {
    		hs[i] = new HashSet<>();
    		int num = sc.nextInt();
    		while(--num >= 0) hs[i].add(sc.nextInt());
    	}
    	
    	for(int i = 0; i < M; i++) {
    		arr[i] = sc.nextInt();
    		dp[i] = 100000;
    	}
    	
    	int idx = 0, cnt = 0;
    	dp[0] = 0;
    	
    	while(idx < M) {
    		int cur = idx;
    		for(int i = 0; i < N; i++)
    			idx = Math.max(idx, solve(i, cur, cnt));
    		++cnt;
    	}
    	
    	System.out.println(dp[M - 1]);
	}
	private static int solve(int n, int idx, int cnt) {
		while(idx < M && hs[n].contains(arr[idx])) {
			dp[idx] = cnt;
			++idx;
		}
		return idx;
	}
}