import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[1001];
		
		dp[1] = dp[3] = dp[4] = 1;
		
		for(int i = 5; i <= N; i++)
			if(dp[i-1] + dp[i-3] + dp[i-4] < 3) dp[i] = 1;
		
		System.out.println(dp[N] == 1 ? "SK" : "CY");
	}
}