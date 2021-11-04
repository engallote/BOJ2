import java.util.*;

public class Main {
	static int N, M, K;
	static char[][] map;
	static int[][] chk;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	while(true) {
    		N = sc.nextInt();
        	M = sc.nextInt();
        	K = sc.nextInt();
        	
        	if(N == 0 && M == 0 && K == 0) break;
        	
        	map = new char[N][M];
        	chk = new int[N][M];
        	
        	for(int i = 0; i < N; i++)
        		map[i] = sc.next().toCharArray();
        	
        	solve(0, K - 1);
    	}
	}
	private static void solve(int r, int c) {
		for(int i = 0; i < N; i++) Arrays.fill(chk[i], -1);
		int x = r, y = c, cnt = 0;
		
		while(true) {
			if(x < 0 || y < 0 || x >= N || y >= M) {
				System.out.println(cnt + " step(s) to exit");
				return;
			}
			if(chk[x][y] != -1) {
				System.out.println(chk[x][y] + " step(s) before a loop of " + (cnt - chk[x][y]) + " step(s)");
				return;
			}
			
			chk[x][y] = cnt++;
			if(map[x][y] == 'S') x += 1;
			else if(map[x][y] == 'W') y -= 1;
			else if(map[x][y] == 'E') y += 1;
			else x -= 1;
		}
	}
}