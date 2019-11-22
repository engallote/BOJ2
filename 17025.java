import java.util.*;

public class Main {
	static int N, area = 0, per = 0;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static int[][] sum;
	static char[][] arr;
	static boolean[][] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new char[N][N];
		sum = new int[N][N];
		chk = new boolean[N][N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.next().toCharArray();
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				if(arr[i][j] == '#')
				{
					for(int k = 0; k < 4; k++)
					{
						int nx = i + dx[k], ny = j + dy[k];
						if(nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] == '.')
							++sum[i][j];
					}
				}
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				if(!chk[i][j] && arr[i][j] == '#')
					bfs(i, j);
		
		System.out.println(area + " " + per);
	}
	private static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(x, y));
		chk[x][y] = true;
		int tmp = 0, pe = 0, size = 0;
		
		while(!q.isEmpty())
		{
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				++tmp;
				pe += sum[p.x][p.y];
				
				for(int i = 0; i < 4; i++)
				{
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] == '.' || chk[nx][ny])
						continue;
					chk[nx][ny] = true;
					q.offer(new Pair(nx, ny));
				}
			}
		}
		
		if(tmp > area)
		{
			area = tmp;
			per = pe;
		}
		else if(tmp == area) per = Math.min(per, pe);
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