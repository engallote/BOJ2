import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static int[][] chk;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	map = new int[N][N];
    	chk = new int[N][N];
    	int x = 0, y = 0;
    	
    	for(int i = 0; i < N; i++) {
    		Arrays.fill(chk[i], -1);
    		
    		for(int j = 0; j < N; j++) {
    			String str = sc.next();
    			
    			if(str.charAt(0) == 'A') map[i][j] = 1;
    			else if(str.charAt(0) == 'T') map[i][j] = 10;
    			else if(str.charAt(0) == 'J') map[i][j] = 11;
    			else if(str.charAt(0) == 'Q') map[i][j] = 12;
    			else if(str.charAt(0) == 'K') map[i][j] = 13;
    			else map[i][j] = str.charAt(0) - '0';
    		}
    	}
    	
    	bfs(N - 1, 0);
    	System.out.println(chk[0][N-1]);
	}
	private static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		chk[x][y] = map[x][y];
		int cnt = 2 * N - 2;
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				if(p.x - 1 >= 0 && chk[p.x-1][p.y] < chk[p.x][p.y] + map[p.x-1][p.y]) {
					chk[p.x-1][p.y] = chk[p.x][p.y] + map[p.x-1][p.y];
					q.offer(new Pair(p.x - 1, p.y));
				}
				if(p.y + 1 < N && chk[p.x][p.y+1] < chk[p.x][p.y] + map[p.x][p.y+1]) {
					chk[p.x][p.y+1] = chk[p.x][p.y] + map[p.x][p.y+1];
					q.offer(new Pair(p.x, p.y + 1));
				}
			}
			--cnt;
			if(cnt == 0) break;
		}
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}