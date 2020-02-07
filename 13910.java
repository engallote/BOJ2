import java.util.*;

public class Main {
	static int N, M;
	static int[] arr, dp;
	static HashSet<Integer> hs = new HashSet<>();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        dp = new int[N+1];
        Arrays.fill(dp, -1);
        
        for(int i = 0; i < M; i++)
        	arr[i] = sc.nextInt();
        
        for(int i = 0; i < M; i++){
        	int sum = arr[i];
        	hs.add(arr[i]);
        	for(int j = i + 1; j < M; j++)
        		hs.add(sum + arr[j]);
        }
        int res = solve(N);
        if(1000000000 == res) res = -1;
        System.out.println(res);
    }
	private static int solve(int n) {
		if(n == 0) return 0;
		if(dp[n] != -1) return dp[n];
		int ret = 1000000000;
		
		Iterator<Integer> it = hs.iterator();
		while(it.hasNext()){
			int num = it.next();
			if(num <= n) ret = Math.min(ret, solve(n - num) + 1);
		}
		return dp[n] = ret;
	}
}