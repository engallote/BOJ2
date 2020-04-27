import java.util.*;

public class Main {
	static int N, M;
	static char[][] arr;
	static int[][] dist, chk;
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);			
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new char[N][M];
		dist = new int[N][M];
		chk = new int[N][M];
		Queue<Pair> q = new LinkedList<Pair>();
		int x = 0, y = 0;
		
		for(int i = 0; i < N; i++){
			arr[i] = sc.next().toCharArray();
			Arrays.fill(chk[i], -1);
			Arrays.fill(dist[i], Integer.MAX_VALUE);
			for(int j = 0; j < M; j++){
				if(arr[i][j] == '+'){
					q.offer(new Pair(i, j));
					dist[i][j] = 0;
				}
				else if(arr[i][j] == 'V'){
					x = i;
					y = j;
				}
			}
		}
		
		findDist(q);//숲의 거리 계산
		bfs(x, y);
	}
	private static void bfs(int x, int y) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(x, y, dist[x][y]));
		chk[x][y] = dist[x][y];
		
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			
			if(arr[p.x][p.y] == 'J'){
				System.out.println(p.min);
				return;
			}
			
			for(int i = 0; i < 4; i++){
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] >= Math.min(p.min, dist[nx][ny])) continue;
				chk[nx][ny] = Math.min(p.min, dist[nx][ny]);
				pq.offer(new Pair(nx, ny, chk[nx][ny]));
			}
		}
	}
	private static void findDist(Queue<Pair> q) {
		int size, time = 1;
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				for(int i = 0; i < 4; i++){
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || dist[nx][ny] <= time) continue;
					dist[nx][ny] = time;
					q.offer(new Pair(nx, ny));
				}
			}
			++time;
		}
	}
}
class Pair implements Comparable<Pair>{
	int x, y, min;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	Pair(int x, int y, int min){
		this.x = x;
		this.y = y;
		this.min = min;
	}
	@Override
	public int compareTo(Pair o) {
		return o.min > this.min ? 1 : (o.min == this.min ? 0 : -1);
	}
}