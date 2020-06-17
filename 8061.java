import java.util.*;

public class Main {
	static int N, M;
	static char[][] arr;
	static int[][] res;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new char[N][M];
		res = new int[N][M];
		
		Queue<Pair> q = new LinkedList<Pair>();
		
		for(int i = 0; i < N; i++){
			arr[i] = sc.next().toCharArray();
			for(int j = 0; j < M; j++)
				if(arr[i][j] == '1') q.offer(new Pair(i, j));
		}
		
		bfs(q);
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++)
				System.out.print(res[i][j] + " ");
			System.out.println();
		}
	}
	private static void bfs(Queue<Pair> q) {
		int size, time = 1;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				for(int i = 0; i < 4; i++){
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] != '0') continue;
					
					arr[nx][ny] = '1';
					res[nx][ny] = time;
					q.offer(new Pair(nx, ny));
				}
			}
			++time;
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