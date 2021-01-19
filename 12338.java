import java.util.*;

public class Main {
	static int N, M;
	static int[][] map;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int test_case = 1; test_case <= T; test_case++) {
        	N = sc.nextInt();
        	M = sc.nextInt();
        	map = new int[N][M];
        	boolean[][] chk = new boolean[N][M];
        	
        	for(int i = 0; i < N; i++)
        		for(int j = 0; j < M; j++)
        			map[i][j] = sc.nextInt();
        	
        	boolean flag = true;
        	loop:for(int k = 1; k <= 100; k++) {
        		for(int i = 0; i < N; i++)
            		for(int j = 0; j < M; j++)
            			if(map[i][j] == k && !chk[i][j]) {
            				boolean tmp = solve(i, j, k);
            				if(!tmp) {
            					flag = false;
            					break loop;
            				}
            			}
        	}
        	
        	System.out.println("Case #" + test_case + ": " + (flag ? "YES" : "NO"));
        }
    }
	private static boolean solve(int x, int y, int num) {
		boolean ret1 = true, ret2 = true;
		for(int i = 0; i < N; i++)
			if(map[i][y] > num) {
				ret1 = false;
				break;
			}
		
		for(int i = 0; i < M; i++)
			if(map[x][i] > num) {
				ret2 = false;
				break;
			}
		
		return ret1|ret2;
	}
}