import java.util.*;

public class Main {
	static int H, W;
	static char[][] map;
	static int[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	H = sc.nextInt();
    	W = sc.nextInt();
    	map = new char[H][W];
    	chk = new int[H][W];
    	int sx = 0, sy = 0;
    	
    	for(int i = 0; i < H; i++) {
    		map[i] = sc.next().toCharArray();
    		Arrays.fill(chk[i], Integer.MAX_VALUE);
    		for(int j = 0; j < W; j++)
    			if(map[i][j] == 'S') {
    				chk[i][j] = 0;
    				sx = i;
    				sy = j;
    			}
    	}
    	
    	bfs(sx, sy);
    }
	private static void bfs(int sx, int sy) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(sx, sy));
		int time = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				if(map[p.x][p.y] == 'E') {
					time = Math.min(time, chk[p.x][p.y]);
					continue;
				}
				
				boolean s = false, e = false;
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
					if(map[nx][ny] == '#') {
						s = true;
						break;
					}
				}
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= H || ny >= W || map[nx][ny] == '#') continue;
					e = false;
					if(s) {//현재 벽에 인접한 땅
						for(int d = 0; d < 4; d++) {//가려는 땅 근처에도 벽이 있나?
							int nx2 = nx + dx[d], ny2 = ny + dy[d];
							if(nx2 < 0 || ny2 < 0 || nx2 >= H || ny2 >= W) continue;
							if(map[nx2][ny2] == '#') {
								e = true;
								break;
							}
						}
						
						if(e) {//벽 타고 이동
							if(chk[nx][ny] > chk[p.x][p.y]) {
								chk[nx][ny] = chk[p.x][p.y];
								q.offer(new Pair(nx, ny));
							}
						}
						else {//그냥 이동
							if(chk[nx][ny] > chk[p.x][p.y] + 1) {
								chk[nx][ny] = chk[p.x][p.y] + 1;
								q.offer(new Pair(nx, ny));
							}
						}
					}
					else {//그냥 이동
						if(chk[nx][ny] > chk[p.x][p.y] + 1) {
							chk[nx][ny] = chk[p.x][p.y] + 1;
							q.offer(new Pair(nx, ny));
						}
					}
				}
			}
		}
		
		System.out.println(time);
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}