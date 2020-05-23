import java.util.*;

public class Main {
	static int N, M;
	static boolean[][] chk;
	static char[][] arr;
	static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1}, dy = {0, 1, 0, -1, 1, -1, 1, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new char[N][M];
		chk = new boolean[N][M];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.next().toCharArray();
		
		bfs();
	}
	private static void bfs() {
		int cnt = 0;
		if(arr[0][0] != '\\') cnt = 1;
		else cnt = 0;
		arr[0][0] = '\\';
		chk[0][0] = true;
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(0, 0, cnt));
		
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			
			if(p.x == N - 1 && p.y == M - 1){
				if(arr[p.x][p.y] == '/') continue;
				System.out.println(p.cnt);
				return;
			}
			
			for(int i = 0; i < 8; i++){
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny]) continue;
				
				if(arr[p.x][p.y] == '\\'){
					if(i <= 3){
						if(arr[nx][ny] == '/')
							pq.offer(new Pair(nx, ny, p.cnt));
						else if(arr[nx][ny] == '\\'){
							arr[nx][ny] = '/';
							pq.offer(new Pair(nx, ny, p.cnt + 1));
						}
						chk[nx][ny] = true;
					}
					else if(i == 4 || i == 7){
						if(arr[nx][ny] == '\\'){
							pq.offer(new Pair(nx, ny, p.cnt));
						}
						else if(arr[nx][ny] == '/'){
							arr[nx][ny] = '\\';
							pq.offer(new Pair(nx, ny, p.cnt + 1));
							
						}
						chk[nx][ny] = true;
					}
				}
				else{
					if(i <= 3){
						if(arr[nx][ny] == '\\'){
							pq.offer(new Pair(nx, ny, p.cnt));
						}
						else if(arr[nx][ny] == '/'){
							arr[nx][ny] = '\\';
							pq.offer(new Pair(nx, ny, p.cnt + 1));
						}
						chk[nx][ny] = true;
					}
					else if(i == 5 || i == 6){
						if(arr[nx][ny] == '/') pq.offer(new Pair(nx, ny, p.cnt));
						else if(arr[nx][ny] == '\\'){
							arr[nx][ny] = '/';
							pq.offer(new Pair(nx, ny, p.cnt + 1));	
						}
						chk[nx][ny] = true;
					}
				}				
			}
		}
		
		System.out.println("NO SOLUTION");
	}
}
class Pair implements Comparable<Pair>{
	int x, y, d, cnt;
	Pair(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : (o.cnt == this.cnt ? 0 : 1);
	}
}