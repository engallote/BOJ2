import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);    	
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	int mod = 1000000009;
    	char[][] arr = new char[N][M];
    	int[][] dp = new int[N][M];
    	
    	for(int i = 0; i < N; i++)
    		arr[i] = sc.next().toCharArray();
    	
    	for(int i = N - 1; i >= 0; i--)
    		for(int j = M - 1; j >= 0; j--) {
    			if(i == N - 1 && j == M - 1) dp[i][j] = 1;
    			else if(arr[i][j] == 'B') dp[i][j] = (dp[i + 1][j] % mod + dp[i][j + 1] % mod) % mod;
    			else if(arr[i][j] == 'S') dp[i][j] = dp[i + 1][j] % mod;
    			else dp[i][j] = dp[i][j + 1] % mod;
    		}
    	
    	int res = 0;
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < M; j++) {
    			res += dp[i][j] % mod;
    			res %= mod;
    		}
    	
    	System.out.println(res);
	}
}