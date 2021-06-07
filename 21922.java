import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M, res;
	static int[][] map;
	static boolean[][] chk;
	static boolean[][][] chk2;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
//    	Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	map = new int[N][M];
    	chk = new boolean[N][M];
    	chk2 = new boolean[N][M][4];
    	Queue<Pair> list = new LinkedList<>();
    	
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < M; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    			if(map[i][j] == 9) list.offer(new Pair(i, j));
    		}
    	}
    	
    	res = 0;
    	while(!list.isEmpty()) {
    		Pair p = list.poll();
    		bfs(p.x, p.y);
    	}
    	
    	bw.write(res+"");
    	bw.flush();
	}
	private static void bfs(int sx, int sy) {
		Queue<Pair> q = new LinkedList<>();
		if(!chk[sx][sy]) {
			chk[sx][sy] = true;
			++res;
		}
		for(int i = 0; i < 4; i++)
			q.offer(new Pair(sx, sy, i));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			int nx = p.x + dx[p.d], ny = p.y + dy[p.d];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk2[nx][ny][p.d]) continue;
			if(!chk[nx][ny]) {
				chk[nx][ny] = true;
				++res;
			}
			chk2[nx][ny][p.d] = true;
			if(map[nx][ny] == 0 || map[nx][ny] == 9) q.offer(new Pair(nx, ny, p.d));
			else if(map[nx][ny] == 1) {
				if(p.d == 0 || p.d == 2) q.offer(new Pair(nx, ny, p.d));
			}
			else if(map[nx][ny] == 2) {
				if(p.d == 1 || p.d == 3) q.offer(new Pair(nx, ny, p.d));
			}
			else if(map[nx][ny] == 3) {
				if(p.d == 0) q.offer(new Pair(nx, ny, 3));
				else if(p.d == 1) q.offer(new Pair(nx, ny, 2));
				else if(p.d == 2) q.offer(new Pair(nx, ny, 1));
				else q.offer(new Pair(nx, ny, 0));
			}
			else if(map[nx][ny] == 4) {
				if(p.d == 0) q.offer(new Pair(nx, ny, 1));
				else if(p.d == 1) q.offer(new Pair(nx, ny, 0));
				else if(p.d == 2) q.offer(new Pair(nx, ny, 3));
				else q.offer(new Pair(nx, ny, 2));
			}
		}
	}
}
class Pair {
	int x, y, d;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	Pair(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}