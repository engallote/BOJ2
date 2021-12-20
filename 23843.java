import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	int[] arr = new int[N];
    	int[] sum = new int[M];
    	
    	for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
    	
    	Arrays.sort(arr);
    	
    	for(int i = N - 1; i >= 0; i--) {
    		int min = Integer.MAX_VALUE, idx = 0;
    		
    		for(int j = 0; j < M; j++) {
    			if(sum[j] < min) {
    				min = sum[j];
    				idx = j;
    			}
    		}
    		
    		sum[idx] += arr[i];
    	}
    	
    	int res = 0;
    	for(int i = 0; i < M; i++) 
    		res = Math.max(res, sum[i]);
    	
    	System.out.println(res);
    }
}