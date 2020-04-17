import java.util.*;

public class Main {
	static int N, K;
	static int[][] arr;
	static int[][][] chk;
	static ArrayList<Pair>[] aly;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N][N];
		chk = new int[N][N][K+1];
		aly = new ArrayList[K+1];
		for(int i = 2; i <= K; i++)
			aly[i] = new ArrayList<>();
		
		Queue<Pair> q = new LinkedList<Pair>();
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++){
				arr[i][j] = sc.nextInt();
				Arrays.fill(chk[i][j], Integer.MAX_VALUE);
				
				if(arr[i][j] == 1){
					q.offer(new Pair(i, j, 0));
					chk[i][j][0] = 0;
				}
				else aly[arr[i][j]].add(new Pair(i, j));
			}
		
		int res = bfs(q);
		System.out.println(res);
	}
	private static int bfs(Queue<Pair> q) {
		int size = 0, res = Integer.MAX_VALUE;
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				if(p.cnt == K - 1){
					res = Math.min(res, p.cost);
					continue;
				}
				
				for(Pair next : aly[arr[p.x][p.y]+1])
					if(chk[next.x][next.y][p.cnt+1] > p.cost + Math.abs(p.x - next.x) + Math.abs(p.y - next.y)){
						chk[next.x][next.y][p.cnt+1] = p.cost + Math.abs(p.x - next.x) + Math.abs(p.y - next.y);
						q.offer(new Pair(next.x, next.y, p.cnt + 1, chk[next.x][next.y][p.cnt+1]));
					}
			}
		}
		
		return res == Integer.MAX_VALUE ? -1 : res;
	}
}
class Pair{
	int x, y, cnt, cost;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	Pair(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	Pair(int x, int y, int cnt, int cost){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.cost = cost;
	}
}