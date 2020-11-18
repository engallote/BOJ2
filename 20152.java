import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int N = sc.nextInt();
		long[][] arr = new long[31][31], cnt = new long[31][31];
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		
		for(int i = 0; i < 31; i++)
			Arrays.fill(arr[i], Long.MAX_VALUE);
		
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(H, H));
		cnt[H][H] = 1;
		arr[H][H] = 0;
		int size;
		
		while(!q.isEmpty()) {
			size = q.size();
			
			while(--size >= 0) {
				Pair p = q.poll();
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= 31 || ny >= 31 || ny > nx) 
						continue;
					if(arr[nx][ny] > arr[p.x][p.y] + 1) {
						arr[nx][ny] = arr[p.x][p.y] + 1;
						cnt[nx][ny] = cnt[p.x][p.y];
						q.offer(new Pair(nx, ny));
					}
					else if(arr[nx][ny] == arr[p.x][p.y] + 1) {
						cnt[nx][ny] = cnt[nx][ny] + cnt[p.x][p.y];
					}
				}
			}
		}
		
		System.out.println(cnt[N][N]);
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}