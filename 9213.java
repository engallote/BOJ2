import java.util.*;

public class Main {
	static int s, e, K;
	static int[] dp = new int[1000001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 1; i <= 1000000; i++)
			for(int j = 1; j * j <= i; j++)
				if(i % j == 0){
					dp[i] += j;
					if(i / j != j && i / j != i) dp[i] += i / j;
				}
		
		
		int tc = 1;
		while(true){
			s = sc.nextInt();
			e = sc.nextInt();
			K = sc.nextInt();
			
			if(s == 0 && e == 0 && K == 0) break;
			int res = 0;
			
			for(int i = s; i <= e; i++)
				if(Math.abs(dp[i] - i) <= K) ++res;
			
			System.out.println("Test " + tc + ": " +res);
			++tc;
		}
	}
}