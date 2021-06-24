import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	arr = new int[N][M];
    	int[][] chk1 = new int[N][M];
    	int[][] chk2 = new int[N][M];
    	
    	for(int i = 0; i < N; i++) {
    		Arrays.fill(chk1[i], Integer.MIN_VALUE);
    		Arrays.fill(chk2[i], Integer.MIN_VALUE);
    		for(int j = 0; j < M; j++)
    			arr[i][j] = sc.nextInt();
    	}
    	
    	if(N == 1 && M == 1) {
    		System.out.println(arr[0][0] * 2);
    		return;
    	}
    	
    	solve(N - 1, 0, 0, chk1);
    	solve(N - 1, M - 1, 1, chk2);
    	int res = Integer.MIN_VALUE;
    	
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < M; j++)
    			res = Math.max(res, chk1[i][j] + chk2[i][j]);
    	
    	System.out.println(res);
	}
	private static void solve(int x, int y, int k, int[][] chk) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		chk[x][y] = arr[x][y];
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				if(k == 0) {
					if(p.y + 1 < M && chk[p.x][p.y + 1] < chk[p.x][p.y] + arr[p.x][p.y + 1]) {
						chk[p.x][p.y + 1] = chk[p.x][p.y] + arr[p.x][p.y + 1];
						q.offer(new Pair(p.x, p.y + 1));
					}
					if(p.x - 1 >= 0 && chk[p.x - 1][p.y] < chk[p.x][p.y] + arr[p.x - 1][p.y]) {
						chk[p.x - 1][p.y] = chk[p.x][p.y] + arr[p.x - 1][p.y];
						q.offer(new Pair(p.x - 1, p.y));
					}
				}
				else {
					if(p.y - 1 >= 0 && chk[p.x][p.y - 1] < chk[p.x][p.y] + arr[p.x][p.y - 1]) {
						chk[p.x][p.y - 1] = chk[p.x][p.y] + arr[p.x][p.y - 1];
						q.offer(new Pair(p.x, p.y - 1));
					}
					if(p.x - 1 >= 0 && chk[p.x - 1][p.y] < chk[p.x][p.y] + arr[p.x - 1][p.y]) {
						chk[p.x - 1][p.y] = chk[p.x][p.y] + arr[p.x - 1][p.y];
						q.offer(new Pair(p.x - 1, p.y));
					}
				}
			}
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