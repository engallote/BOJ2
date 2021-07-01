import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	long[] arr = new long[N + 1];
    	long[][] dp = new long[N + 1][N + 1];
    	
    	for(int i = 1; i <= N; i++)
    		arr[i] = sc.nextLong();
    	
    	for(int i = 1; i <= N; i++)
    		dp[i][i] = arr[i];
    	
    	long max = 0;
    	for(int i = 1; i <= N - 1; i++)
    		for(int j = 1; j <= N - i; j++) {
    			int end = i + j;
    			max = 0;
    			
    			for(int k = j; k < end; k++) {
    				long num = (dp[j][k] + dp[k + 1][end]) / 2;
    				if(max < num) max = num;
    			}
    			
    			dp[j][end] = max;
    		}
    	
    	System.out.println(max);
	}
}