import java.io.*;
import java.util.*;

public class Main {
	static int R, C;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static char[][] map;
	static boolean[][] chk;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	R = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	map = new char[R][C];
    	chk = new boolean[R][C];
    	
    	for(int i = 0; i < R; i++)
    		map[i] = br.readLine().trim().toCharArray();
    	
    	st = new StringTokenizer(br.readLine());
    	int x = Integer.parseInt(st.nextToken()) - 1;
    	int y = Integer.parseInt(st.nextToken()) - 1;
    	char[] order = br.readLine().trim().toCharArray();
    	
    	ArrayList<Pair> aly = new ArrayList<>();
    	for(char c : order) {
    		if(c == 'W') aly.add(new Pair(x, y));
    		else if(c == 'U') x -= 1;
    		else if(c == 'L') y -= 1;
    		else if(c == 'D') x += 1;
    		else y += 1;
    	}
    	
    	for(Pair p : aly) bfs(p.x, p.y);
    	
    	for(int i = 0; i < R; i++) {
    		for(int j = 0; j < C; j++) {
    			if(chk[i][j] || (x == i && y == j)) bw.write(".");
    			else if((x + 1 == i && y == j) || (x - 1 == i && y == j) || (x == i && y + 1 == j) || (x == i && y - 1 == j)) bw.write(".");
    			else bw.write("#");
    		}
    		bw.newLine();
    	}
    	bw.flush();
    }
	private static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		char c = map[x][y];
		chk[x][y] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] != c || chk[nx][ny]) continue;
					chk[nx][ny] = true;
					q.offer(new Pair(nx, ny));
				}
			}
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