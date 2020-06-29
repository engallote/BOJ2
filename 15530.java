import java.util.*;

public class Main {
	static int N, M, ex, ey;
	static char[][] arr;
	static Queue<Pair> sol;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new char[N][M];
		sol = new LinkedList<Pair>();
		int px = 0, py = 0;
		
		for(int i = 0; i < N; i++){
			arr[i] = sc.next().toCharArray();
			for(int j = 0; j < M; j++){
				if(arr[i][j] == '@'){
					arr[i][j] = '?';
					px = i;
					py = j;
				}
				else if(arr[i][j] == '$') sol.offer(new Pair(i, j));
				else if(arr[i][j] == '%'){
					ex = i;
					ey = j;
				}
			}
		}
		
		bfs(px, py);
	}
	private static void bfs(int x, int y) {
		Queue<Pair> pri = new LinkedList<Pair>();
		pri.offer(new Pair(x, y));
		int size = 0;
		
		while(!pri.isEmpty()){
			size = sol.size();
			while(--size >= 0){
				Pair p = sol.poll();
				
				for(int i = 0; i < 4; i++){
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
					if(arr[nx][ny] == '!' || arr[nx][ny] == '$' || arr[nx][ny] == '#') continue;
					arr[nx][ny] = '!';//군인의 발자취
					sol.offer(new Pair(nx, ny));
				}
			}
			
			size = pri.size();
			while(--size >= 0){
				Pair p = pri.poll();
				
				if(p.x == ex && p.y == ey){
					System.out.println("Yes");
					return;
				}
				
				for(int i = 0; i < 4; i++){
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
					if(arr[nx][ny] == '?' || arr[nx][ny] == '$' || arr[nx][ny] == '#' || arr[nx][ny] == '!')
						continue;
					arr[nx][ny] = '?';//공주의 발자취
					pri.offer(new Pair(nx, ny));
				}
			}
		}
		
		System.out.println("No");
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}