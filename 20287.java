import java.util.*;

public class Main {
	static int N, M, Q;
	static char[][] map;
	static int[][] dp;
	static int[] arr;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	map = new char[N][M];
    	dp = new int[N][M];
    	arr = new int[26];
    	
    	for(int i = 0; i < N; i++)
    		map[i] = sc.next().toCharArray();
    	
    	Q = sc.nextInt();
    	int[][] ret = new int[N][M];
    	
    	while(--Q >= 0) {
    		Arrays.fill(arr, 0);
    		char[] ch = sc.next().toCharArray();
    		
    		for(char c : ch)
    			arr[c - 'A'] += 1;
    		
    		for(int i = 0; i < N; i++)
    			for(int j = 0; j < M; j++) {
    				solve(i, j, ch.length);
    			}
    		
    		for(int i = 0; i < N; i++)
    			for(int j = 0; j < M; j++) {
    				ret[i][j] += dp[i][j];
    				dp[i][j] = 0;
    			}
    	}
    	
    	int res = 0;
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < M; j++)
    			if(ret[i][j] > 1) res += 1;
    	
    	System.out.println(res);		
	}
	private static void solve(int x, int y, int len) {
		int[] tmp = new int[26];
		
		for(int i = y; i < Math.min(y + len, M); i++)
			tmp[map[x][i] - 'A'] += 1;
		
		if(same(tmp)) {
			for(int i = y; i < Math.min(y + len, M); i++)
				dp[x][i] = 1;
		}
		
		Arrays.fill(tmp, 0);
		for(int i = x; i < Math.min(N, x + len); i++)
			tmp[map[i][y] - 'A'] += 1;
		

		if(same(tmp)) {
			for(int i = x; i < Math.min(N, x + len); i++)
				dp[i][y] = 1;
		}
		
		Arrays.fill(tmp, 0);
		for(int i = x, j = y; i < Math.min(N, x + len) && j < Math.min(M, y + len); i++, j++)
			tmp[map[i][j] - 'A'] += 1;
		
		if(same(tmp)) {
			for(int i = x, j = y; i < Math.min(N, x + len) && j < Math.min(M, y + len); i++, j++)
				dp[i][j] = 1;
		}
		
		Arrays.fill(tmp, 0);
		for(int i = x, j = y; i < Math.min(N, x + len) && j > Math.max(-1, y - len); i++, j--)
			tmp[map[i][j] - 'A'] += 1;
		
		if(same(tmp)) {
			for(int i = x, j = y; i < Math.min(N, x + len) && j > Math.max(-1, y - len); i++, j--)
				dp[i][j] = 1;
		}
	}
	private static boolean same(int[] tmp) {
		for(int i = 0; i < 26; i++)
			if(arr[i] != tmp[i]) return false;
		return true;
	}
}