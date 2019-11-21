import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt() + 500;
		int Y = sc.nextInt() + 500;
		int N = sc.nextInt();
		int[][] arr = new int[1001][1001];
		boolean[][] chk = new boolean[1001][1001];
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		
		for(int i = 0; i < N; i++)
		{
			int x = sc.nextInt() + 500;
			int y = sc.nextInt() + 500;
			arr[x][y] = -1;
		}
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(500, 500));
		int size = 0, time = 0;
		
		while(!q.isEmpty())
		{
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				if(p.x == X && p.y == Y)
				{
					System.out.println(time);
					return;
				}
				
				for(int i = 0; i < 4; i++)
				{
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx > 1000 || ny > 1000 || arr[nx][ny] == -1 || chk[nx][ny])
						continue;
					chk[nx][ny] = true;
					q.offer(new Pair(nx, ny));
				}
			}
			++time;
		}
	}
}
class Pair{
	int x, y;
	Pair(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}