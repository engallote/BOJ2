import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		int[][] arr = new int[N][M];
		int[][] chk = new int[N][M];
		
		for(int i = 0; i < N; i++){
			char[] ch = sc.next().toCharArray();
			Arrays.fill(chk[i], Integer.MAX_VALUE);
			for(int j = 0; j < M; j++)
				arr[i][j] = ch[j]-'0';
		}
		
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(0, 0));
		chk[0][0] = -1;
		int time = 0, size;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				if(p.x == N - 1 && p.y == M - 1){
					System.out.println(time);
					return;
				}
				
				for(int i = 0; i < 4; i++){
					int nx = p.x + (dx[i] * arr[p.x][p.y]), ny = p.y + (dy[i] * arr[p.x][p.y]);
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] <= time) continue;
					chk[nx][ny] = time;
					q.offer(new Pair(nx, ny));
				}
			}
			++time;
		}
		
		System.out.println("IMPOSSIBLE");
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}