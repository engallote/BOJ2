import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	int[][] arr = new int[N + 1][N + 1];
    	
    	for(int i = 1; i <= N; i++) {
    		Arrays.fill(arr[i], 1000000000);
    		arr[i][i] = 0;
    	}
    	
    	for(int i = 0; i < M; i++) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		int c = sc.nextInt();
    		arr[a][b] = arr[b][a] = c;
    	}
    	
    	for(int k = 1; k <= N; k++)
    		for(int i = 1; i <= N; i++)
    			for(int j = 1; j <= N; j++)
    				if(arr[i][k] + arr[k][j] < arr[i][j]) arr[i][j] = arr[i][k] + arr[k][j];
    	
    	int sum = 0, res = 0;
    	double min = Double.MAX_VALUE;
    	for(int i = 1; i <= N; i++) {
    		sum = 0;
    		for(int j = 1; j <= N; j++)
    			sum += (long)arr[i][j];
    		
    		double div = (double)sum / (N - 1);
    		
    		if(min > div) {
    			min = div;
    			res = i;
    		}
    	}
    			
    	System.out.println(res);
    }
}