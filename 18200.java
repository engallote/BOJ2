import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int K = sc.nextInt();
    	int[] arr = new int[N];
    	
    	for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
    	
    	Arrays.sort(arr);
    	
    	long l = 0, r = Long.MAX_VALUE, mid, res = r;
    	while(l <= r) {
    		mid = (l + r) / 2;
    		
    		long cnt = 0;
    		for(int i = 0; i < Math.min(N, K); i++) {
    			if(arr[i] > mid) break;
    			cnt += (mid / arr[i] + 1) / 2 * 4 + 1;
    			if(cnt >= N) break;
    		}
    		
    		if(cnt >= N) {
    			res = mid;
    			r = mid - 1;
    		}
    		else l = mid + 1;
    	}
    	System.out.println(res);
    }
}