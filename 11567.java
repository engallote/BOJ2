import java.util.*;

public class Main {
	static int N, M, ex, ey;
	static char[][] arr;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new char[N][M];
        
        for(int i = 0; i < N; i++)
        	arr[i] = sc.next().toCharArray();
        
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;
        ex = sc.nextInt() - 1;
        ey = sc.nextInt() - 1;
        
        bfs(x, y);
    }
	private static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(x, y));
		int size = 0;
		
		while(!q.isEmpty()){
			size = q.size();
			
			while(--size >= 0){
				Pair p = q.poll();
				
				for(int i = 0; i < 4; i++){
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
					
					if(nx == ex && ny == ey) {
						if(arr[nx][ny] == 'X') {
							System.out.println("YES");
							return;
						}
						else{
							arr[nx][ny] = 'X';
							q.offer(new Pair(nx, ny));
						}
					}
					else {
						if(arr[nx][ny] == 'X') continue;
						arr[nx][ny] = 'X';
						q.offer(new Pair(nx, ny));
					}
				}
			}
		}
		System.out.println("NO");
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}