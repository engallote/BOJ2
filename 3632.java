import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	long[] arr = new long[N];
    	
    	for(int i = 0; i < N; i++) arr[i] = sc.nextLong();
    	long k = sc.nextInt() - 1;
    	
    	Arrays.sort(arr);
    	
    	if(k ==0) {
    		System.out.println(arr[N - 1]);
    		return;
    	}
    	
    	long l = 0, r = arr[N - 1], mid, time = r;
    	while(l <= r) {
    		mid = (l + r) / 2;
    		
    		long cnt = 0;
    		for(int i = 0; i < N; i++) {
    			if(arr[i] - mid <= 0) continue;
    			long num = arr[i] - mid;
    			cnt += (num + k - 1) / k;
    		}
    		
    		if(cnt <= mid) {
    			time = mid;
    			r = mid - 1;
    		}
    		else l = mid + 1;
    	}
    	
    	System.out.println(time);
    }
}