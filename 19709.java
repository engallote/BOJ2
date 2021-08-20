import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	int[] arr = new int[M];
    	
    	for(int i = 0; i < M; i++)
    		arr[i] = sc.nextInt();
    	
    	Arrays.sort(arr);
    	
    	int res = 0;
    	for(int i = 0; i < M; i++) {
    		if(N - arr[i] >= 0) {
    			N -= arr[i];
    			++res;
    		}
    	}
    	
    	System.out.println(res);
	}
}