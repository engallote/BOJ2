import java.util.*;

public class Main {
	static int N, p, q, res;
	static int[] arr, path;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	arr = new int[N];
    	res = -1;
    	
    	for(int i = 0; i < N; i++)
    		arr[i] = sc.nextInt();
    	
    	p = sc.nextInt();
    	q = sc.nextInt();
    	path = new int[q + 1];
    	
    	solve(0, 0);
    	System.out.println(res);
	}
	private static void solve(int idx, int len) {
		if(idx == N) {
			if(len < q) return;
			int ret = 1;
			
			for(int i = 0; i <= len; i++)
				ret *= path[i];
			
			res = Math.max(ret, res);
			return;
		}
		
		if(len + 1 <= q) {
			path[len + 1] = arr[idx];
			solve(idx + 1, len + 1);
			path[len + 1] = 0;
		}
		for(int i = 0; i <= len; i++) {
			path[i] += arr[idx];
			solve(idx + 1, len);
			path[i] -= arr[idx];
		}
	}
}