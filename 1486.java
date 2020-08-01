import java.util.*;

public class Main {
	static int N, M, T, D, res;
	static int[][] arr, up, down;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();
		D = sc.nextInt();
		arr = new int[N][M];
		up = new int[N][M];
		down = new int[N][M];
		
		for(int i = 0; i < N; i++){
			char[] ch = sc.next().toCharArray();
			for(int j = 0; j < M; j++){
				if(ch[j] >= 'A' && ch[j] <= 'Z') arr[i][j] = ch[j] - 'A';
				else arr[i][j] = ch[j] - 'a' + 26;
				up[i][j] = down[i][j] = Integer.MAX_VALUE;
			}
		}
		
		res = arr[0][0];
		go();
		back();
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(up[i][j] != Integer.MAX_VALUE && down[i][j] != Integer.MAX_VALUE && up[i][j] + down[i][j] <= D)
					res = Math.max(res, arr[i][j]);
		
		System.out.println(res);
	}
	private static void back() {
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(0, 0));
		down[0][0] = 0;
		
		while(!q.isEmpty()){
			Pair p = q.poll();
			
			for(int i = 0; i < 4; i++){
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || Math.abs(arr[p.x][p.y] - arr[nx][ny]) > T)
					continue;
				
				int time = down[p.x][p.y];
				if(arr[p.x][p.y] <= arr[nx][ny])
					++time;
				else
					time += (int)Math.pow(Math.abs(arr[p.x][p.y] - arr[nx][ny]), 2);
				
				if(time > D || down[nx][ny] <= time) continue;
				
				down[nx][ny] = time;
				q.offer(new Pair(nx, ny));
			}
		}
	}
	
	private static void go() {
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(0, 0));
		up[0][0] = 0;
		
		while(!q.isEmpty()){
			Pair p = q.poll();
			
			for(int i = 0; i < 4; i++){
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || Math.abs(arr[p.x][p.y] - arr[nx][ny]) > T)
					continue;
				
				int time = up[p.x][p.y];
				if(arr[p.x][p.y] < arr[nx][ny])
					time += (int)Math.pow(Math.abs(arr[p.x][p.y] - arr[nx][ny]), 2);
				else
					++time;
					
				if(time > D || up[nx][ny] <= time) continue;
				
				up[nx][ny] = time;
				q.offer(new Pair(nx, ny));
			}
		}
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}