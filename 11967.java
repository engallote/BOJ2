import java.util.*;

public class Main {
	static int N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		ArrayList<Pair>[][] arr = new ArrayList[N+1][N+1];
		boolean[][] chk = new boolean[N+1][N+1], light = new boolean[N+1][N+1];
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		
		for(int i = 1; i <= N; i++){
			arr[i] = new ArrayList[N+1];
			for(int j = 1; j <= N; j++)
				arr[i][j] = new ArrayList<>();
		}
		
		while(--M >= 0){
			int x = sc.nextInt();
			int y = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[x][y].add(new Pair(a, b));
		}
		
		int res = 1, size = 0;
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(1, 1));
		light[1][1] = true;
		chk[1][1] = true;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				for(Pair next : arr[p.x][p.y]){
					if(!light[next.x][next.y]) {
						light[next.x][next.y] = true;
						++res;
					}
					if(!chk[next.x][next.y] && light[next.x][next.y]){
						for(int i = 0; i < 4; i++){
							int nx = next.x + dx[i], ny = next.y + dy[i];
							if(nx < 1 || ny < 1 || nx > N || ny > N || !light[nx][ny])
								continue;
							if(chk[nx][ny]){
								q.offer(new Pair(nx, ny));
								break;
							}
						}
					}
				}
				
				for(int i = 0; i < 4; i++){
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 1 || ny < 1 || nx > N || ny > N || chk[nx][ny] || !light[nx][ny])
						continue;
					chk[nx][ny] = true;
					q.offer(new Pair(nx, ny));
				}
			}
		}
		
		System.out.println(res);
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}