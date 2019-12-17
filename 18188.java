import java.util.*;

public class Main {
	static int H, W, N;
	static char[][] map;
	static int[][] order;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		H = sc.nextInt();
		W = sc.nextInt();
		map = new char[H][W];
		HashMap<String, Integer> hs = new HashMap<>();
		hs.put("S", 0);
		hs.put("D", 1);
		hs.put("W", 2);
		hs.put("A", 3);
		String[] dir = {"S","D","W","A"};
		int x = 0, y = 0;
		for(int i = 0; i < H; i++)
		{
			map[i] = sc.next().toCharArray();
			for(int j = 0; j < W; j++)
				if(map[i][j] == 'D')
				{
					x = i;
					y = j;
				}
		}
		
		N = sc.nextInt();
		order = new int[N][2];
		for(int i = 0; i < N; i++)
		{
			order[i][0] = hs.get(sc.next());
			order[i][1] = hs.get(sc.next());
		}
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(0, 0, x, y, ""));
		
		int size = 0;
		while(!q.isEmpty())
		{
			size = q.size();
			while(--size >= 0)
			{
				Pair p = q.poll();
				
				if(map[p.x][p.y] == 'Z')
				{
					System.out.println("YES");
					System.out.println(p.path);
					return;
				}
				if(p.idx == N) continue;
				
				int nx = p.x + dx[order[p.idx][0]], ny = p.y + dy[order[p.idx][0]];
				if(nx >= 0 && ny >= 0 && nx < H && ny < W && map[nx][ny] != '@')
					q.offer(new Pair(p.idx + 1, 0, nx, ny, p.path+dir[order[p.idx][0]]));
				
				nx = p.x + dx[order[p.idx][1]];
				ny = p.y + dy[order[p.idx][1]];
				if(nx >= 0 && ny >= 0 && nx < H && ny < W && map[nx][ny] != '@')
					q.offer(new Pair(p.idx + 1, 1, nx, ny, p.path+dir[order[p.idx][1]]));
			}
		}
		System.out.println("NO");
	}
}
class Pair{
	int idx, k, x, y;
	String path;
	Pair(int idx, int k, int x, int y, String path)
	{
		this.idx = idx;
		this.k = k;
		this.x = x;
		this.y = y;
		this.path = path;
	}
}