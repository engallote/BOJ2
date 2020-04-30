import java.util.*;

public class Main {
	static int N, M;
	static char[][] arr;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static int[][] chk;
	static boolean[][] visit;
	static ArrayList<Pair> camera = new ArrayList<>(), cell = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new char[N][M];
		chk = new int[N][M];
		visit = new boolean[N][M];
		int x = 0, y = 0;
		
		for(int i = 0; i < N; i++){
			arr[i] = sc.next().toCharArray();
			Arrays.fill(chk[i], Integer.MAX_VALUE);
			for(int j = 0; j < M; j++){
				if(arr[i][j] == 'C'){
					visit[i][j] = true;
					camera.add(new Pair(i, j));
				}
				else if(arr[i][j] == 'S'){
					x = i;
					y = j;
					arr[i][j] = '.';
				}
				else if(arr[i][j] == '.') cell.add(new Pair(i, j));
			}
		}
		
		findCamera();
		bfs(x, y);
		
		for(Pair p : cell)
			System.out.println(chk[p.x][p.y] == Integer.MAX_VALUE ? -1 : chk[p.x][p.y]);
	}
	private static void bfs(int x, int y) {
		if(visit[x][y]) return;
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(x, y, 0));
		int size;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				for(int i = 0; i < 4; i++){
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(!range(nx, ny)) continue;
					
					if(arr[nx][ny] == '.'){
						chk[nx][ny] = p.cnt + 1;
						visit[nx][ny] = true;
						q.offer(new Pair(nx, ny, p.cnt + 1));
					}
					else{
						visit[nx][ny] = true;
						if(arr[nx][ny] == 'U') nx -= 1;
						else if(arr[nx][ny] == 'D') nx += 1;
						else if(arr[nx][ny] == 'L') ny -= 1;
						else if(arr[nx][ny] == 'R') ny += 1;
						
						while(range(nx, ny)){
							if(arr[nx][ny] == '.'){
								visit[nx][ny] = true;
								chk[nx][ny] = p.cnt + 1;
								q.offer(new Pair(nx, ny, p.cnt + 1));
								break;
							}
							else if(arr[nx][ny] == 'U'){
								visit[nx][ny] = true;
								nx -= 1;
							}
							else if(arr[nx][ny] == 'D'){
								visit[nx][ny] = true;
								nx += 1;
							}
							else if(arr[nx][ny] == 'L'){
								visit[nx][ny] = true;
								ny -= 1;
							}
							else if(arr[nx][ny] == 'R'){
								visit[nx][ny] = true;
								ny += 1;
							}
						}
					}
				}//for
			}//size
		}//q
	}
	private static boolean range(int nx, int ny) {
		if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 'W' || visit[nx][ny])
			return false;
		return true;
	}
	private static void findCamera() {
		for(Pair cur : camera){
			for(int i = 0; i < 4; i++){
				int x = cur.x + dx[i], y = cur.y + dy[i];
				
				while(x >= 0 && y >= 0 && x < N && y < M && arr[x][y] != 'W'){
					if(arr[x][y] == '.' || arr[x][y] == 'S') visit[x][y] = true;
					x += dx[i];
					y += dy[i];
				}
			}
		}
	}
}
class Pair{
	int x, y, cnt;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	Pair(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}