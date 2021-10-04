import java.util.*;

public class Main {
	static int N, res;
	static int[][] arr;
	static boolean[] chk;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	arr = new int[N][N];
    	chk = new boolean[N];
    	
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < N; j++)
    			arr[i][j] = sc.nextInt();
    	
    	res = Integer.MAX_VALUE;
    	solve(0, 0);
    	System.out.println(res);
	}
	private static void solve(int idx, int cnt) {
		if(cnt >= 2) calc();
		if(cnt == N / 2) return;
		if(idx >= N) return;
		
		chk[idx] = true;
		solve(idx + 1, cnt + 1);
		chk[idx] = false;
		solve(idx + 1, cnt);
	}
	private static void calc() {
		int a = 0, b = 0;
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++) {
				if(chk[i] && chk[j]) a += arr[i][j];
				else if(!chk[i] && !chk[j]) b += arr[i][j];
			}
		
		res = Math.min(res, Math.abs(a - b));
	}
}