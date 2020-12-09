import java.util.*;

public class Main {
	static int N, M;
	static int[][] map;
	static char[][] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int K = sc.nextInt();
		map = new int[N][M];
		chk = new char[N][M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				chk[i][j] = 'S';
			}
		
		int res = 0;
		while(--K >= 0) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			char d = sc.next().charAt(0);
			
			res += go(x, y, d);
			
			x = sc.nextInt() - 1;
			y = sc.nextInt() - 1;
			chk[x][y] = 'S';
		}
		
		System.out.println(res);
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				System.out.print(chk[i][j] + " ");
			System.out.println();
		}
	}
	private static int go(int x, int y, char d) {
		if(chk[x][y] == 'F') return 0;
		int ret = 0;
		
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y, map[x][y]));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			if(chk[p.x][p.y] == 'F') continue;
			chk[p.x][p.y] = 'F';
			++ret;
			
			for(int i = 0; i < p.num; i++) {
				if(d == 'E' && p.y + i < M && chk[p.x][p.y + i] == 'S') 
					q.offer(new Pair(p.x, p.y + i, map[p.x][p.y + i]));
				else if(d == 'W' && p.y - i >= 0 && chk[p.x][p.y - i] == 'S') 
					q.offer(new Pair(p.x, p.y - i, map[p.x][p.y - i]));
				else if(d == 'N' && p.x - i >= 0 && chk[p.x - i][p.y] == 'S') 
					q.offer(new Pair(p.x - i, p.y, map[p.x - i][p.y]));
				else if(d == 'S' && p.x + i < N && chk[p.x + i][p.y] == 'S') 
					q.offer(new Pair(p.x + i, p.y, map[p.x + i][p.y]));
			}
		}
		
		return ret;
	}
}
class Pair{
	int x, y, num;
	Pair(int x, int y, int num){
		this.x = x;
		this.y = y;
		this.num = num;
	}
}