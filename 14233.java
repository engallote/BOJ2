import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int[] arr = new int[N];
    	
    	for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
    	Arrays.sort(arr);
    	
    	long l = 1, r = arr[N - 1], mid, res = 0;
    	while(l <= r) {
    		mid = (l + r) / 2;
    		boolean flag = true;
    		for(int i = 0; i < N; i++)
    			if((long)(i + 1) * mid > (long)arr[i]) {
    				flag = false;
    				break;
    			}
    		
    		if(flag) {
    			res = Math.max(res, mid);
    			l = mid + 1;
    		}
    		else r = mid - 1;
    	}
    	
    	System.out.println(res);
	}
}