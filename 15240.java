import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] arr = new char[N][M];
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		for(int i = 0; i < N; i++)
			arr[i] = sc.next().toCharArray();
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		char color = sc.next().charAt(0);
		
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(x, y));
		
		char pre = arr[x][y];
		arr[x][y] = color;
		
		int size = 0;
		while(!q.isEmpty())
		{
			size = q.size();
			while(--size >= 0)
			{
				Pair p = q.poll();
				
				for(int i = 0; i < 4; i++)
				{
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] != pre) continue;
					q.offer(new Pair(nx, ny));
					arr[nx][ny] = color;
				}
			}
		}
		
		for(int i = 0; i < N; i++)
			System.out.println(new String(arr[i]));
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