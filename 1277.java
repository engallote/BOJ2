import java.util.*;

public class Main {
	static int N, W;
	static double M;
	static double[][] arr;
	static double[] chk;
	static boolean[][] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		W = sc.nextInt();
		M = sc.nextDouble();
		arr = new double[N+1][2];
		chk = new double[N+1];
		visit = new boolean[N+1][N+1];
		Arrays.fill(chk, Double.MAX_VALUE);
		
		for(int i = 1; i <= N; i++){
			arr[i][0] = sc.nextDouble();
			arr[i][1] = sc.nextDouble();
		}
		
		for(int i = 0; i < W; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			visit[a][b] = visit[b][a] = true;
		}
		
		Queue<Pair> q = new LinkedList<Pair>();
		int size = 0;
		q.offer(new Pair(1, 0.0));
		chk[1] = 0.0;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				if(p.x == N) continue;
				
				for(int i = 1; i <= N; i++){
					if(p.x == i) continue;
					if(visit[p.x][i] && chk[i] > p.y){
						chk[i] = p.y;
						q.offer(new Pair(i, p.y));
						continue;
					}
					double dist = getDist(arr[p.x][0], arr[p.x][1], arr[i][0], arr[i][1]);
					if(dist > M || chk[i] <= p.y + dist) continue;
					chk[i] = p.y + dist;
					q.offer(new Pair(i, p.y + dist));
				}
			}
		}
		
		System.out.println((long)Math.floor(chk[N]*1000));
	}
	private static double getDist(double x1, double y1, double x2, double y2) {		
		return Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
	}
}
class Pair{
	int x;
	double y;
	Pair(int x, double y){
		this.x = x;
		this.y = y;
	}
}