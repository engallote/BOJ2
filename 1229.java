import java.util.*;

public class Main {
	static ArrayList<Integer> arr = new ArrayList<>();
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int num = 1, cnt = 2;
		dp = new int[1000001];
		
		Arrays.fill(dp, -1);
		arr.add(1);
		while(num < 1000000){
			arr.add(num);
			num = cnt * (cnt * 2 - 1);
			++cnt;
		}
		
		System.out.println(dfs(N, 0));
	}

	private static int dfs(int n, int cnt) {
		if(n < 6) return n;
		if(n < 15) return n / 6 + n % 6;
		if(dp[n] != -1) return dp[n];
		int l = 0, r = arr.size() - 1, mid, idx = 0, ret = Integer.MAX_VALUE;
		while(l <= r){
			mid = (l + r) / 2;
			
			if(arr.get(mid) <= n){
				idx = Math.max(idx, mid);
				l = mid + 1;
			}
			else r = mid - 1;
		}
		
		for(int i = idx; i >= 0; i--)
			ret = Math.min(ret, dfs(n - arr.get(i), cnt + 1) + 1);
		
		return dp[n] = ret;
	}
}