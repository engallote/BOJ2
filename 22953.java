import java.util.*;

public class Main {
	static int N, K, C;
	static long res;
	static long[] arr;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	K = sc.nextInt();
    	C = sc.nextInt();
    	arr = new long[N];
    	res = Long.MAX_VALUE - 1;
    	int one = 0;
    	
    	for(int i = 0; i < N; i++) {
    		arr[i] = sc.nextLong();
    		if(arr[i] == 1) ++one;
    	}
    	
    	solve(0, one);
    	
    	System.out.println(res);
	}
	private static void solve(int cnt, int one) {
		if(cnt == C || one == N) {
			find();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(arr[i] == 1) continue;
			arr[i] -= 1;
			
			solve(cnt + 1, arr[i] == 1 ? one + 1 : one);
			
			arr[i] += 1;
		}
	}
	private static void find() {
		long l = 1, r = 2000000000000l, mid;
    	while(l <= r) {
    		mid = (l + r) / 2;
    		long sum = 0;
    		
    		for(int i = 0; i < N; i++)
    			sum += mid / arr[i];
    		
    		if(sum >= K) {
    			res = Math.min(res, mid);
    			r = mid - 1;
    		}
    		else l = mid + 1;
    	}
	}
}