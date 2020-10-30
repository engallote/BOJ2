import java.util.*;

public class Main {
	static int N, M;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static int[][] arr;
	static boolean[][] chk;
	static Queue<Pair> melt = new LinkedList<Pair>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = (int) Math.pow(2, sc.nextInt());
		M = sc.nextInt();
		arr = new int[N][N];
		chk = new boolean[N][N];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				arr[i][j] = sc.nextInt();
		
		while(--M >= 0) {
			int L = sc.nextInt();
			
			//È¸Àü
			if(L > 0) {
				int num = (int) Math.pow(2, L);
				
				for(int i = 0; i < N; i+=num)
					for(int j = 0; j < N; j+=num)
						rotate(i, j, num);
			}
			
			melt.clear();
			//Ä­ È®ÀÎ
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					if(arr[i][j] > 0)
						bfs(i, j);
					
			while(!melt.isEmpty())
				arr[melt.peek().x][melt.poll().y] -= 1;
		}
		
		int sum = 0, max = 0;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++) {
				sum += arr[i][j];
				if(arr[i][j] > 0 && !chk[i][j])
					max = Math.max(max, findMax(i, j));
			}
		
		System.out.println(sum);
		System.out.println(max);
	}
	private static int findMax(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		chk[x][y] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			++cnt;
			
			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || chk[nx][ny] || arr[nx][ny] == 0) 
					continue;
				chk[nx][ny] = true;
				q.offer(new Pair(nx, ny));
			}
		}
		
		return cnt;
	}
	private static void bfs(int x, int y) {
		int ice = 0;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] == 0)
				continue;
			if(arr[nx][ny] > 0) ++ice;
		}
		
		if(ice < 3) melt.offer(new Pair(x, y));
	}
	private static void rotate(int x, int y, int num) {
		int[][] tmp = new int[num][num];
		int r = 0, c = num - 1;
		
		for(int i = x; i < x + num; i++) {
			r = 0;
			for(int j = y; j < y + num; j++) {
				tmp[r][c] = arr[i][j];
				++r;
			}
			--c;
		}
		
		r = c = 0;
		for(int i = x; i < x + num; i++) {
			for(int j = y; j < y + num; j++) {
				arr[i][j] = tmp[r][c];
				++c;
			}
			c = 0;
			++r;
		}
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}