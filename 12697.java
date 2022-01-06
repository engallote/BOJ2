import java.util.*;

public class Main {
	static int N, M;
	static char[][] map;
	static int[][][][][][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	
    	for(int test_case = 1; test_case <= T; test_case++) {
    		N = sc.nextInt();
    		M = sc.nextInt();
    		map = new char[N + 2][M + 2];
    		
    		int sx = 0, sy = 0;
    		
    		for(int i = 0; i < N + 2; i++) {
    			Arrays.fill(map[i], '#');
    			if(i == 0 || i > N) continue;
    			char[] ch = sc.next().toCharArray();
    			for(int j = 0; j < M; j++) {
    				map[i][j + 1] = ch[j];
    				if(map[i][j + 1] == 'O') {
    					sx = i;
    					sy = j + 1;
    				}
    			}
    		}
    		
    		N += 2;
    		M += 2;
    		
//    		for(int a = 0; a < N; a++)
//    			System.out.println(new String(map[a]));
    		
    		chk = new int[N][M][N][M][N][M];
    		
    		for(int a = 0; a < N; a++)
    			for(int b = 0; b < M; b++)
    				for(int c = 0; c < N; c++)
    					for(int d = 0; d < M; d++)
    						for(int e = 0; e < N; e++)
    							Arrays.fill(chk[a][b][c][d][e], 100000000);
    		
    		System.out.println("Case #" + test_case + ": " + bfs(sx, sy));
    	}
    }
	private static String bfs(int sx, int sy) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();		
		pq.offer(new Pair(sx, sy, 0, 0, 0, 0, 0));
		chk[sx][sy][0][0][0][0] = 0;
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
//			System.out.println(p.x + " " + p.y + " " + p.px + " " + p.py + " " + p.yx + " " + p.yy + " " + p.cnt);
			if(map[p.x][p.y] == 'X') return Integer.toString(p.cnt);
			
			for(int d = 0; d < 4; d++) {//새로운 포탈 만들기
				int nx = p.x, ny = p.y;
				
				while(map[nx][ny] != '#') {
					nx += dx[d];
					ny += dy[d];
				}
				
				nx -= dx[d];
				ny -= dy[d];
				
				if(chk[p.x][p.y][nx][ny][p.yx][p.yy] > p.cnt) {
					chk[p.x][p.y][nx][ny][p.yx][p.yy] = p.cnt;
					pq.offer(new Pair(p.x, p.y, nx, ny, p.yx, p.yy, p.cnt));
				}
				if(chk[p.x][p.y][p.px][p.py][nx][ny] > p.cnt) {
					chk[p.x][p.y][p.px][p.py][nx][ny] = p.cnt;
					pq.offer(new Pair(p.x, p.y, p.px, p.py, nx, ny, p.cnt));
				}
			}
			
			if(p.x == p.px && p.y == p.py && map[p.yx][p.yy] != '#') {//포탈1로 나가기
				if(chk[p.yx][p.yy][p.px][p.py][p.yx][p.yy] > p.cnt + 1) {
					chk[p.yx][p.yy][p.px][p.py][p.yx][p.yy] = p.cnt + 1;
					pq.offer(new Pair(p.yx, p.yy, p.px, p.py, p.yx, p.yy, p.cnt + 1));
				}
			}
			if(p.x == p.yx && p.y == p.yy && map[p.px][p.py] != '#') {//포탈2로 나가기
				if(chk[p.px][p.py][p.px][p.py][p.yx][p.yy] > p.cnt + 1) {
					chk[p.px][p.py][p.px][p.py][p.yx][p.yy] = p.cnt + 1;
					pq.offer(new Pair(p.px, p.py, p.px, p.py, p.yx, p.yy, p.cnt + 1));
				}
			}
			
			for(int i = 0; i < 4; i++) {//이동
				int nx = p.x + dx[i], ny = p.y + dy[i];
				
				if(map[nx][ny] != '#') {//빈 공간이면 그냥 가기
					if(chk[nx][ny][p.px][p.py][p.yx][p.yy] > p.cnt + 1) {
						chk[nx][ny][p.px][p.py][p.yx][p.yy] = p.cnt + 1;
						pq.offer(new Pair(nx, ny, p.px, p.py, p.yx, p.yy, p.cnt + 1));
					}
				}				
			}
		}
		
		return "THE CAKE IS A LIE";
	}
}
class Pair implements Comparable<Pair>{
	int x, y, px, py, yx, yy, cnt;
	Pair(int x, int y, int px, int py, int yx, int yy, int cnt) {
		this.x = x;
		this.y = y;
		this.px = px;
		this.py = py;
		this.yx = yx;
		this.yy = yy;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.cnt, o.cnt);
	}
}