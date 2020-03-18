import java.util.*;

public class Main {
	static int N;
	static long mod = 123456789;
	static long[] dp;
	static ArrayList<Integer> arr = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new long[N + 1];
		boolean[] chk = new boolean[N + 1];
		
		for(int i = 2; i <= N; i++){
			if(chk[i]) continue;
			arr.add(i);
			for(int j = i + i; j <= N; j+=i)
				chk[j] = true;
		}
		
		dp[0] = 1;
		for(int i = 0; i < arr.size(); i++)
			for(int j = arr.get(i); j <= N; j++){
				dp[j] += dp[j-arr.get(i)];
				dp[j] %= mod;
			}
		
		System.out.println(dp[N]);
	}
}