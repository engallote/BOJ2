import java.util.*;

public class Main {
	static int N, K, res;
	static int[][] arr;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	arr = new int[N][2];
    	
    	for(int i = 1; i < N; i++) {
    		arr[i][0] = sc.nextInt();
    		arr[i][1] = sc.nextInt();
    	}
    	
    	K = sc.nextInt();
    	
    	res = solve(1, 1);
    	
    	System.out.println(res);
    }
	private static int solve(int idx, int k) {
		if(idx >= N) return 0;
		
		int ret = 1000000000;
		
		if(idx + 1 <= N) ret = Math.min(ret, solve(idx + 1, k) + arr[idx][0]);
		if(idx + 2 <= N) ret = Math.min(ret, solve(idx + 2, k) + arr[idx][1]);
		if(k == 1 && idx + 3 <= N) ret = Math.min(ret, solve(idx + 3, 0) + K);
		
		return ret;
	}
}