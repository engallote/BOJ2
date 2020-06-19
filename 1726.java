import java.util.*;

public class Main {
	static int N, M, ex, ey, ed;
	static int[][] arr;
	static int[][][] chk;
	static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0}; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		chk = new int[N][M][5];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++){
				arr[i][j] = sc.nextInt();
				Arrays.fill(chk[i][j], Integer.MAX_VALUE);
			}
		
		int x = sc.nextInt() - 1;
		int y = sc.nextInt() - 1;
		int d = sc.nextInt() - 1;
		ex = sc.nextInt() - 1;
		ey = sc.nextInt() - 1;
		ed = sc.nextInt() - 1;
		
		bfs(x, y, d);
	}
	private static void bfs(int x, int y, int d) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(x, y, d, 0));
		chk[x][y][d] = 0;
		
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			
			if(p.x == ex && p.y == ey && p.d == ed){
				System.out.println(p.cnt);
				return;
			}
			
			//제자리에서 돌리기
			if(p.d == 0){//현재 동쪽을 보고 있다
				if(chk[p.x][p.y][1] > p.cnt + 2){//서쪽으로
					chk[p.x][p.y][1] = p.cnt + 2;
					pq.offer(new Pair(p.x, p.y, 1, p.cnt + 2));
				}
				if(chk[p.x][p.y][2] > p.cnt + 1){//남쪽으로
					chk[p.x][p.y][2] = p.cnt + 1;
					pq.offer(new Pair(p.x, p.y, 2, p.cnt + 1));
				}
				if(chk[p.x][p.y][3] > p.cnt + 1){//북쪽으로
					chk[p.x][p.y][3] = p.cnt + 1;
					pq.offer(new Pair(p.x, p.y, 3, p.cnt + 1));
				}
			}
			else if(p.d == 1){//현재 서쪽을 보고 있다
				if(chk[p.x][p.y][0] > p.cnt + 2){//서쪽으로
					chk[p.x][p.y][0] = p.cnt + 2;
					pq.offer(new Pair(p.x, p.y, 0, p.cnt + 2));
				}
				if(chk[p.x][p.y][2] > p.cnt + 1){//남쪽으로
					chk[p.x][p.y][2] = p.cnt + 1;
					pq.offer(new Pair(p.x, p.y, 2, p.cnt + 1));
				}
				if(chk[p.x][p.y][3] > p.cnt + 1){//북쪽으로
					chk[p.x][p.y][3] = p.cnt + 1;
					pq.offer(new Pair(p.x, p.y, 3, p.cnt + 1));
				}
			}
			else if(p.d == 2){//현재 남쪽을 보고 있다
				if(chk[p.x][p.y][0] > p.cnt + 1){//동쪽으로
					chk[p.x][p.y][0] = p.cnt + 1;
					pq.offer(new Pair(p.x, p.y, 0, p.cnt + 1));
				}
				if(chk[p.x][p.y][1] > p.cnt + 1){//서쪽으로
					chk[p.x][p.y][1] = p.cnt + 1;
					pq.offer(new Pair(p.x, p.y, 1, p.cnt + 1));
				}
				if(chk[p.x][p.y][3] > p.cnt + 2){//북쪽으로
					chk[p.x][p.y][3] = p.cnt + 2;
					pq.offer(new Pair(p.x, p.y, 3, p.cnt + 2));
				}
			}
			else if(p.d == 3){//현재 북쪽을 보고 있다
				if(chk[p.x][p.y][0] > p.cnt + 1){//동쪽으로
					chk[p.x][p.y][0] = p.cnt + 1;
					pq.offer(new Pair(p.x, p.y, 0, p.cnt + 1));
				}
				if(chk[p.x][p.y][1] > p.cnt + 1){//서쪽으로
					chk[p.x][p.y][1] = p.cnt + 1;
					pq.offer(new Pair(p.x, p.y, 1, p.cnt + 1));
				}
				if(chk[p.x][p.y][2] > p.cnt + 2){//북쪽으로
					chk[p.x][p.y][2] = p.cnt + 2;
					pq.offer(new Pair(p.x, p.y, 2, p.cnt + 2));
				}
			}
			
			//이동하기
			for(int j = 1; j <= 3; j++){
				int nx = p.x + dx[p.d] * j, ny = p.y + dy[p.d] * j;
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 1) break;
				if(chk[nx][ny][p.d] <= p.cnt + 1) continue;
				chk[nx][ny][p.d] = p.cnt + 1;
				pq.offer(new Pair(nx, ny, p.d, p.cnt + 1));
			}
		}
	}
}
class Pair implements Comparable<Pair>{
	int x, y, d, cnt;
	Pair(int x, int y, int d, int cnt){
		this.x = x;
		this.y = y;
		this.d = d;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : (o.cnt == this.cnt ? 0 : 1);
	}
}
