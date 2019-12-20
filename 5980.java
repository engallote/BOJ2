import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] arr = new char[N][M];
		int[][] port = new int[26][4];
		int[][] chk = new int[N][M];
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		for(int i = 0; i < 26; i++)
			Arrays.fill(port[i], -1);
		int x = 0, y = 0;
		for(int i = 0; i < N; i++)
		{
			arr[i] = sc.next().toCharArray();
			Arrays.fill(chk[i], Integer.MAX_VALUE);
			for(int j = 0; j < M; j++)
			{
				if(arr[i][j] == '@')
				{
					x = i;
					y = j;
				}
				else if(arr[i][j] >= 'A' && arr[i][j] <= 'Z')
				{
					if(port[arr[i][j]-'A'][0] == -1)
					{
						port[arr[i][j]-'A'][0] = i;
						port[arr[i][j]-'A'][1] = j;
					}
					else
					{
						port[arr[i][j]-'A'][2] = i;
						port[arr[i][j]-'A'][3] = j;
					}
				}
			}
		}
		Queue<Pair> q = new LinkedList<Pair>();
		chk[x][y] = 0;
		q.offer(new Pair(x, y));
		int size = 0, time = 0;
		while(!q.isEmpty())
		{
			size = q.size();
			while(--size >= 0)
			{
				Pair p = q.poll();
				if(p.x == -1) continue;
				if(arr[p.x][p.y] == '=')
				{
					System.out.println(time);
					return;
				}
				for(int i = 0; i < 4; i++)
				{
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == '#' || chk[nx][ny] <= time)
						continue;
					if(arr[nx][ny] >='A' && arr[nx][ny] <= 'Z')
					{
						if(port[arr[nx][ny]-'A'][0] == nx && port[arr[nx][ny]-'A'][1] == ny)
							q.offer(new Pair(port[arr[nx][ny]-'A'][2], port[arr[nx][ny]-'A'][3]));
						else 
							q.offer(new Pair(port[arr[nx][ny]-'A'][0], port[arr[nx][ny]-'A'][1]));
					}
					else 
					{
						chk[nx][ny] = time;
						q.offer(new Pair(nx, ny));
					}
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