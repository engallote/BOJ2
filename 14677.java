import java.util.*;

public class Main {
	static int N;
	static char[] ch;
	static int[] arr;
	static int[][] dp;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt() * 3;
        ch = sc.next().toCharArray();
        dp = new int[N][N];
        arr = new int['Z'];
        arr['B'] = 0;
        arr['L'] = 1;
        arr['D'] = 2;
        
        for(int i = 0; i < N; i++)
        	Arrays.fill(dp[i], -1);
        
        int res = solve(0, N-1, 0);
        System.out.println(res);
    }
	private static int solve(int l, int r, int cur) {
		if(l > r) return 0;
		if(dp[l][r] != -1) return dp[l][r];
		
		int ret = 0;
		if(arr[ch[l]] == cur) 
			ret = Math.max(ret, solve(l + 1, r, (cur + 1) % 3) + 1);
		
		if(arr[ch[r]] == cur) 
			ret = Math.max(ret, solve(l, r - 1, (cur + 1) % 3) + 1);
		
		return dp[l][r] = ret;
	}
}