import java.util.*;

public class Main {
	static int N, M, K;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}, dy = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[][] mp, sp, dp, cp;
	static Queue<Pair> q = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		mp = new int[N + 1][N + 1];
		sp = new int[N + 1][N + 1];
		cp = new int[N + 1][N + 1];
		dp = new int[N + 1][N + 1];
		
		for(int i = 0; i < M; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int m = sc.nextInt();//질량
			int s = sc.nextInt();//속력
			int d = sc.nextInt();//방향
			q.offer(new Pair(r, c, m, s, d));
		}
		
		while(--K >= 0) {
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				int nx = p.x, ny = p.y, speed = p.s;
				
				while(--speed >= 0) {
					nx += dx[p.d];
					ny += dy[p.d];
					
					if(nx <= 0) nx = N;
					else if(nx > N) nx = 1;
					if(ny <= 0) ny = N;
					else if(ny > N) ny = 1;
				}
				
				if(mp[nx][ny] == 0) {
					mp[nx][ny] = p.m;
					sp[nx][ny] = p.s;
					cp[nx][ny] = 1;
					if(p.d % 2 == 0) dp[nx][ny] = 1;
					else dp[nx][ny] = -1;
					q.offer(new Pair(nx, ny, p.m, p.s, p.d));
				}
				else {
					mp[nx][ny] += p.m;
					sp[nx][ny] += p.s;
					if(p.d % 2 == 0) dp[nx][ny] += 1;
					else dp[nx][ny] += -1;
					cp[nx][ny] += 1;
				}
			}
			
			size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				if(p.m == 0) continue;
				if(cp[p.x][p.y] > 1) {
					int nm = mp[p.x][p.y] / 5;
					int ns = sp[p.x][p.y] / cp[p.x][p.y];
					if(nm == 0) continue;
					if(dp[p.x][p.y] == cp[p.x][p.y] || dp[p.x][p.y] == -cp[p.x][p.y]) {
						q.offer(new Pair(p.x, p.y, nm, ns, 0));
						q.offer(new Pair(p.x, p.y, nm, ns, 2));
						q.offer(new Pair(p.x, p.y, nm, ns, 4));
						q.offer(new Pair(p.x, p.y, nm, ns, 6));
					}
					else {
						q.offer(new Pair(p.x, p.y, nm, ns, 1));
						q.offer(new Pair(p.x, p.y, nm, ns, 3));
						q.offer(new Pair(p.x, p.y, nm, ns, 5));
						q.offer(new Pair(p.x, p.y, nm, ns, 7));
					}
				}
				else {
					q.offer(p);
				}
			}
			
			for(int i = 1; i <= N; i++) {
				Arrays.fill(mp[i], 0);
				Arrays.fill(sp[i], 0);
				Arrays.fill(dp[i], 0);
				Arrays.fill(cp[i], 0);
			}
		}
		
		int res = 0;
		while(!q.isEmpty())
			res += q.poll().m;
		
		System.out.println(res);
	}
}
class Pair {
	int x, y, m, s, d;
	Pair(int x, int y, int m, int s, int d) {
		this.x = x;
		this.y = y;
		this.m = m;
		this.s = s;
		this.d = d;
	}
}