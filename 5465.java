import java.util.*;

public class Main {
	static int N, S;
	static char[][] arr;
	static int[][] bchk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static Queue<Pair> bee = new LinkedList<Pair>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new char[N][N];
		bchk = new int[N][N];
		int x = 0, y = 0;
		
		for(int i = 0; i < N; i++){
			arr[i] = sc.next().toCharArray();
			Arrays.fill(bchk[i], -1);
			for(int j = 0; j < N; j++){
				if(arr[i][j] == 'M'){
					arr[i][j] = 'G';
					x = i;
					y = j;
				}
				else if(arr[i][j] == 'H'){
					bchk[i][j] = 0;
					bee.offer(new Pair(i, j));
				}
				else if(arr[i][j] == 'D') bchk[i][j] = Integer.MAX_VALUE;
			}
		}
		
		beePre();
		int l = -1, r = N * N * 2, mid, res = -1;
		while(l <= r){
			mid = (l + r) / 2;
			
			if(mid * S >= bchk[x][y]) r = mid - 1;
			else if(bfs(x, y, mid)){
				res = Math.max(res, mid);
				l = mid + 1;
			}
			else r = mid - 1;
		}
		
		System.out.println(res);
	}
	private static boolean bfs(int x, int y, int mid) {
		Queue<Pair> q = new LinkedList<Pair>();
		boolean[][] chk = new boolean[N][N];
		chk[x][y] = true;
		q.offer(new Pair(x, y));
		int size = 0, time = mid * S + 1;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				if(arr[p.x][p.y] == 'D') return true;
				
				for(int i = 0; i < 4; i++){
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N || chk[nx][ny] || arr[nx][ny] == 'T' || bchk[nx][ny] <= time) continue;
					chk[nx][ny] = true;
					q.offer(new Pair(nx, ny));
				}
			}
			++time;
		}
		return false;
	}
	private static void beePre() {		
		int size = 0;
		while(!bee.isEmpty()){
			size = bee.size();
			while(--size >= 0){
				Pair p = bee.poll();
				
				for(int i = 0; i < 4; i++){
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N || bchk[nx][ny] != -1 || arr[nx][ny] != 'G') continue;
					bchk[nx][ny] = bchk[p.x][p.y] + S;
					bee.offer(new Pair(nx, ny));
				}
			}
		}
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}