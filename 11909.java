import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		int[][][] chk = new int[N][N][2];
		StringTokenizer st;
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(i != 0 || j != 0) Arrays.fill(chk[i][j], Integer.MAX_VALUE);
			}
		}
		
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(0, 0, 0));
		int size = 0;
		while(!q.isEmpty())
		{
			size = q.size();
			while(--size >= 0)
			{
				Pair p = q.poll();
				if(p.x == N - 1 && p.y == N - 1) continue;
				if(p.y + 1 < N)
				{
					int sub = (arr[p.x][p.y] <= arr[p.x][p.y + 1] ? arr[p.x][p.y + 1] - arr[p.x][p.y] + 1 : 0);
					if(chk[p.x][p.y+1][1] > chk[p.x][p.y][p.d] + sub)
					{
						chk[p.x][p.y + 1][1] = chk[p.x][p.y][p.d] + sub;
						q.offer(new Pair(p.x, p.y + 1, 1));
					}
				}
				if(p.x + 1 < N)
				{
					int sub = (arr[p.x][p.y] <= arr[p.x+1][p.y] ? arr[p.x+1][p.y] - arr[p.x][p.y] + 1 : 0);
					if(chk[p.x+1][p.y][0] > chk[p.x][p.y][p.d] + sub)
					{
						chk[p.x+1][p.y][0] = chk[p.x][p.y][p.d] + sub;
						q.offer(new Pair(p.x+1, p.y, 0));
					}
				}
			}
		}
		
		System.out.println(Math.min(chk[N-1][N-1][0], chk[N-1][N-1][1]));
	}
}
class Pair{
	int x, y, d;
	Pair(int x, int y, int d)
	{
		this.x = x;
		this.y = y;
		this.d = d;
	}
}