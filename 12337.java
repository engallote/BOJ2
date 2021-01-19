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
        	loop:for(int i = 0; i < N; i++)
        		for(int j = 0; j < M; j++)
        			if(map[i][j] == 1 && !chk[i][j]) {
        				boolean tmp = solve(i, j);
        				if(!tmp) {
        					flag = false;
        					break loop;
        				}
        			}
        	
        	System.out.println("Case #" + test_case + ": " + (flag ? "YES" : "NO"));
        }
    }
	private static boolean solve(int x, int y) {
		boolean ret1 = true, ret2 = true;
		for(int i = 0; i < N; i++)
			if(map[i][y] != 1) {
				ret1 = false;
				break;
			}
		
		for(int i = 0; i < M; i++)
			if(map[x][i] != 1) {
				ret2 = false;
				break;
			}
		
		return ret1|ret2;
	}
}