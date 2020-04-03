import java.util.*;

public class Main {
	static int N, T, ex, ey;
	static char[][] arr;
	static int[][][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		T = sc.nextInt();
		ex = sc.nextInt() - 1;
		ey = sc.nextInt() - 1;
		arr = new char[N][N];
		chk = new int[N][N][2];
		
		for(int i = 0; i < N; i++){
			arr[i] = sc.next().toCharArray();
			for(int j = 0; j < N; j++)
				Arrays.fill(chk[i][j], Integer.MAX_VALUE);
		}
		
		bfs();
	}
	private static void bfs() {
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(0, 0, 0, 0));
		q.offer(new Pair(0, 0, 1, T));
		chk[0][0][0] = 0;
		chk[0][0][1] = T;
		int size, res = Integer.MAX_VALUE;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				if(p.x == ex && p.y == ey){
					res = Math.min(res, p.cnt);
					continue;
				}
				
				if(p.k == 0){
					//일반 -> 변신
					if(chk[p.x][p.y][1] > p.cnt + T){
						chk[p.x][p.y][1] = p.cnt + T;
						q.offer(new Pair(p.x, p.y, 1, p.cnt + T));
					}
					//일반모드
					for(int i = 0; i < 4; i++){
						int nx = p.x + dx[i], ny = p.y + dy[i];
						if(nx < 0 || ny < 0 || nx >= N || ny >= N || chk[nx][ny][0] <= p.cnt + 1)
							continue;
						chk[nx][ny][0] = p.cnt + 1;
						q.offer(new Pair(nx, ny, p.k, p.cnt + 1));
					}
				}
				else{
					//변신모드
					for(int i = 0; i < 4; i++){
						int nx = p.x + dx[i], ny = p.y + dy[i];
						if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
						
						while(nx >= 0 && ny >= 0 && nx < N && ny < N){
							if(arr[nx][ny] == '#'){
								if(chk[nx][ny][1] > p.cnt + 1){
									chk[nx][ny][1] = p.cnt + 1;
									q.offer(new Pair(nx, ny, p.k, p.cnt + 1));
								}
								break;
							}
							nx += dx[i];
							ny += dy[i];
						}
					}
					//변신 -> 일반
					for(int i = 0; i < 4; i++){
						int nx = p.x + dx[i], ny = p.y + dy[i];
						if(nx < 0 || ny < 0 || nx >= N || ny >= N || chk[nx][ny][0] <= p.cnt + 1)
							continue;
						chk[nx][ny][0] = p.cnt + 1;
						q.offer(new Pair(nx, ny, 0, p.cnt + 1));
					}
				}
			}
		}
		
		System.out.println(res);
	}
}
class Pair{
	int x, y, k, cnt;
	Pair(int x, int y, int k, int cnt){
		this.x = x;
		this.y = y;
		this.k = k;
		this.cnt = cnt;
	}
}