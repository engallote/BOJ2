import java.util.*;

public class Main {
	static int D, N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		D = sc.nextInt();
		N = sc.nextInt();
		int[] dp = new int[D+1];
		dp[0] = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++){
			int l = sc.nextInt();
			int c = sc.nextInt();
			
			for(int j = D; j >= l; j--)
				dp[j] = Math.max(dp[j], Math.min(dp[j-l], c));
		}
		
		System.out.println(dp[D]);
	}
}