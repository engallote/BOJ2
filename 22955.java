import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M;
	static char[][] map;
	static int[][] chk;
    public static void main(String[] args) throws IOException {
//    	Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	map = new char[N][M];
    	chk = new int[N][M];
    	
    	int sx = 0, sy = 0;
    	for(int i = 0; i < N; i++) {
    		map[i] = br.readLine().trim().toCharArray();
    		Arrays.fill(chk[i], Integer.MAX_VALUE);
    		
    		for(int j = 0; j < M; j++) {
    			if(map[i][j] == 'C') {
    				chk[i][j] = 0;
    				map[i][j] = 'F';
    				sx = i;
    				sy = j;
    			}
    		}
    	}
    	
    	int res = bfs(sx, sy);
    	System.out.println(res == -1 ? "dodo sad" : res);
	}
	private static int bfs(int x, int y) {
		PriorityQueue<Pair> q = new PriorityQueue<>();
		q.offer(new Pair(x, y, 0));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			if(map[p.x][p.y] == 'E') return p.k;
			if(chk[p.x][p.y] < p.k) continue;
			
			//사다리 타기
			if(p.x + 1 < N && map[p.x+1][p.y] == 'L' && chk[p.x + 1][p.y] > p.k + 5) {//아래로
				chk[p.x + 1][p.y] = p.k + 5;
				q.offer(new Pair(p.x + 1, p.y, p.k + 5));
			}
			if(map[p.x][p.y] == 'L') {//위로
				//위
				if(p.x - 1 >= 0 && canGo(p.x - 1, p.y) && chk[p.x - 1][p.y] > p.k + 5) {
					chk[p.x - 1][p.y] = p.k + 5;
					q.offer(new Pair(p.x - 1, p.y, p.k + 5));
				}
			}
			
			//평지
			if(p.y - 1 >= 0 && canGo(p.x, p.y - 1) && chk[p.x][p.y-1] > p.k + 1) {//왼쪽
				chk[p.x][p.y - 1] = p.k + 1;
				q.offer(new Pair(p.x, p.y - 1, p.k + 1));
			}
			if(p.y + 1 < M && canGo(p.x, p.y + 1) && chk[p.x][p.y+1] > p.k + 1) {//오른쪽
				chk[p.x][p.y + 1] = p.k + 1;
				q.offer(new Pair(p.x, p.y + 1, p.k + 1));
			}
			
			//구멍
			if(p.y - 1 >= 0 && map[p.x][p.y - 1] == 'X') {//왼쪽
				int nx = p.x;
				for(int i = 1; i < N; i++)
					if(nx + i < N) {
						if(canGo(nx + i, p.y - 1)) {
							nx += i;
							break;
						}
						else if(map[nx + i][p.y - 1] == 'D') {
							nx = -1;
							break;
						}
					}
				
				if(nx != -1 && chk[nx][p.y - 1] > p.k + 11) {
					chk[nx][p.y - 1] = p.k + 11;
					q.offer(new Pair(nx, p.y - 1, p.k + 11));
				}
			}
			
			if(p.y + 1 < M && map[p.x][p.y+1] == 'X') {//오른쪽
				int nx = p.x;
				for(int i = 1; i < N; i++)
					if(nx + i < N) {
						if(canGo(nx + i, p.y + 1)) {
							nx += i;
							break;
						}
						else if(map[nx + i][p.y + 1] == 'D') {
							nx = -1;
							break;
						}
					}
				
				if(nx != -1 && chk[nx][p.y + 1] > p.k + 11) {
					chk[nx][p.y + 1] = p.k + 11;
					q.offer(new Pair(nx, p.y + 1, p.k + 11));
				}
			}
		}
		
		return -1;
	}
	private static boolean canGo(int x, int y) {
		if(map[x][y] == 'F' || map[x][y] == 'L' || map[x][y] == 'E') return true;
		return false;
	}
}
class Pair implements Comparable<Pair>{
	int x, y, k;
	Pair(int x, int y, int k){
		this.x = x;
		this.y = y;
		this.k = k;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.k, o.k);
	}
}