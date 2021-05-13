import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);    	
    	N = sc.nextInt();
    	M = sc.nextInt();
    	arr = new int[N + 1];
    	
    	for(int i = 1; i <= N; i++)
    		arr[i] = sc.nextInt();
    	
    	int res = solve(1, 0, M);
    	System.out.println(res);
	}
	private static int solve(int cur, int idx, int time) {
		if(idx >= N || time == 0) return cur;
		int ret = 0;
		
		if(idx + 1 <= N) ret = Math.max(ret, solve(cur + arr[idx + 1], idx + 1, time - 1));
		if(idx + 2 <= N) ret = Math.max(ret, solve(cur / 2 + arr[idx + 2], idx + 2, time - 1));
		
		return ret;
	}
}