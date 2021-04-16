import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, K;
	static int[] par;
	static int[][] map;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	par = new int[K + 1];
    	map = new int[N][N];
    	int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    	Queue<Pair> q = new LinkedList<>(), q2 = new LinkedList<>();
    	
    	for(int i = 1; i <= K; i++) {
    		st = new StringTokenizer(br.readLine());
    		par[i] = i;
    		int x = Integer.parseInt(st.nextToken()) - 1;
    		int y = Integer.parseInt(st.nextToken()) - 1;
    		map[x][y] = i;
    		q.offer(new Pair(x, y));
    	}
    	
    	int time = 0;
    	while(true) {
    		int size = q.size();
    		while(--size >= 0) {
				Pair p = q.poll();
				q2.offer(p);
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
					if(map[nx][ny] != 0) {
						int ap = find(map[nx][ny]), bp = find(map[p.x][p.y]);
						if(ap == bp) continue;
						if(ap > bp) {
							int tmp = ap;
							ap = bp;
							bp = tmp;
						}
						--K;
						par[bp] = ap;
					}
				}
			}
    		
    		if(K == 1) break;
    		
    		size = q2.size();
    		while(--size >= 0) {
    			Pair p = q2.poll();
    			
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
					if(map[nx][ny] != 0) {
						int ap = find(map[nx][ny]), bp = find(map[p.x][p.y]);
						if(ap == bp) continue;
						if(ap > bp) {
							int tmp = ap;
							ap = bp;
							bp = tmp;
						}
						--K;
						par[bp] = ap;
					}
					else {
						map[nx][ny] = map[p.x][p.y];
						q.offer(new Pair(nx, ny));
					}
				}
    		}
    		
    		++time;
    	}
    	
    	bw.write(time+"");
    	bw.flush();
    }
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}