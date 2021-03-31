import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int W = sc.nextInt();
        int H = sc.nextInt();
        int mod = 1000000007;
        int[] dp = new int[N + 1];
        dp[0] = 1;
        
        for(int i = 0; i < W; i++)
        	for(int j = N; j >= 0; j--)
        		for(int k = 1; k <= H && j - k >= 0; k++)
        			dp[j] = (dp[j] + dp[j - k]) % mod;
        
        int res = mod - Math.min(H + 1, N / W + 1);
        for(int i = 0; i <= N; i++)
        	res = (res + dp[i]) % mod;
        
        System.out.println(res);
    }
}