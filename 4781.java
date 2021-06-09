import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	while(true) {
    		int N = sc.nextInt();
        	double M = sc.nextDouble();
        	
        	if(N == 0 && M == 0.0) break;
        	
        	int m = (int)(M * 100 + 0.5);
        	int[] dp = new int[m + 1];
        	int[] cal = new int[N], cost = new int[N];
        	
        	for(int i = 0; i < N; i++) {
        		int c = sc.nextInt();
        		double p = sc.nextDouble();
        		
        		cal[i] = c;
        		cost[i] = (int)(p * 100 + 0.5);
        	}
        	
        	
        	
        	for(int i = 0; i < N; i++)
        		for(int j = cost[i]; j <= m; j++)
        			dp[j] = Math.max(dp[j], dp[j - cost[i]] + cal[i]);
        			
        	System.out.println(dp[m]);
    	}
	}
}