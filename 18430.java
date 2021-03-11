import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr;
	static boolean[][] chk;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];
        chk = new boolean[N][M];
        
        for(int i = 0; i < N; i++)
        	for(int j = 0; j < M; j++)
        		arr[i][j] = sc.nextInt();

        int res = solve(0);
        System.out.println(res);
    }
	private static int solve(int x) {
		int ret = 0;
		
		for(int i = x; i < N; i++)
			for(int j = 0; j < M; j++) {
				if(chk[i][j]) continue;
				int tmp = 0;
				if(j + 1 < M && i + 1 < N && !chk[i][j] && !chk[i+1][j] && !chk[i][j+1]) {
					tmp = arr[i][j] * 2 + arr[i+1][j] + arr[i][j+1];
					chk[i][j] = chk[i+1][j] = chk[i][j+1] = true;
					ret = Math.max(ret, solve(i) + tmp);
					chk[i][j] = chk[i+1][j] = chk[i][j+1] = false;
				}
				if(j - 1 >= 0 && i + 1 < N && !chk[i][j] && !chk[i+1][j] && !chk[i][j-1]) {
					tmp = arr[i][j] * 2 + arr[i+1][j] + arr[i][j-1];
					chk[i][j] = chk[i+1][j] = chk[i][j-1] = true;
					ret = Math.max(ret, solve(i) + tmp);
					chk[i][j] = chk[i+1][j] = chk[i][j-1] = false;
				}
				if(j + 1 < M && i - 1 >= 0 && !chk[i][j] && !chk[i-1][j] && !chk[i][j+1]) {
					tmp = arr[i][j] * 2 + arr[i-1][j] + arr[i][j+1];
					chk[i][j] = chk[i-1][j] = chk[i][j+1] = true;
					ret = Math.max(ret, solve(i) + tmp);
					chk[i][j] = chk[i-1][j] = chk[i][j+1] = false;
				}
				if(j - 1 >= 0 && i - 1 >= 0 && !chk[i][j] && !chk[i-1][j] && !chk[i][j-1]) {
					tmp = arr[i][j] * 2 + arr[i-1][j] + arr[i][j-1];
					chk[i][j] = chk[i-1][j] = chk[i][j-1] = true;
					ret = Math.max(ret, solve(i) + tmp);
					chk[i][j] = chk[i-1][j] = chk[i][j-1] = false;
				}
			}
		
		return ret;
	}
}