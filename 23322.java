import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int K = sc.nextInt();
    	int[] arr = new int[N];
    	
    	for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
    	
    	Arrays.sort(arr);
    	
    	boolean flag = true;
    	int day = 0, res = 0;
    	while(flag) {
    		flag = false;
    		
    		for(int i = K; i < N; i++)
    			if(arr[i] > arr[i - K]) {
    				res += arr[i] - arr[i - K];
    				arr[i] -= arr[i] - arr[i - K];
    				flag = true;
    				break;
    			}
    		
    		if(!flag) break;
    		
    		++day;
    		Arrays.sort(arr);
    	}
    	
    	System.out.println(res + " " + day);
	}
}