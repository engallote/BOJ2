import java.util.*;

public class Main {
	static int N, M;
	static char[][] map;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static boolean[][][] visit;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int test_case = 1; test_case <= T; test_case++) {
        	M = sc.nextInt();
        	N = sc.nextInt();
        	map = new char[N][M];
        	visit = new boolean[N][M][4];
        	int x = 0, y = 0;
        	
        	for(int i = 0; i < N; i++) {
        		map[i] = sc.next().toCharArray();
        		for(int j = 0; j < M; j++)
        			if(map[i][j] == 'S') {
        				x = i;
        				y = j;
        				break;
        			}
        	}
        	
        	System.out.println("Data Set " + test_case + ":");
        	bfs(x, y);
        	System.out.println();
        }
	}
	private static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y, 0));
		int size, res = 0;
		visit[x][y][0] = true;
		
		while(!q.isEmpty()) {
			size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
					if((map[nx][ny] == '.' || map[nx][ny] == 'H') && !visit[nx][ny][p.cnt]) {
						visit[nx][ny][p.cnt] = true;
						q.offer(new Pair(nx, ny, p.cnt));
					}
					else if(map[nx][ny] == 'G' && p.cnt < 3 && !visit[nx][ny][p.cnt + 1]) {
						visit[nx][ny][p.cnt + 1] = true;
						q.offer(new Pair(nx, ny, p.cnt + 1));
					}
					else if(map[nx][ny] == 'P' && !visit[nx][ny][p.cnt]) {
						visit[nx][ny][p.cnt] = true;
						q.offer(new Pair(nx, ny, 0));
					}
				}
			}
		}
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(map[i][j] == 'H' && (visit[i][j][0] || visit[i][j][1] || visit[i][j][2] || visit[i][j][3])) ++res;
		
		System.out.println(res);
	}
}
class Pair {
	int x, y, cnt;
	Pair(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}