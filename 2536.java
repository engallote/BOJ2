import java.util.*;

public class Main {
	static int N, M, K;
	static ArrayList<Pair>[] x, y;
	static Pair[] bus;
	static boolean[] chk;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	M = sc.nextInt();
    	N = sc.nextInt();
    	K = sc.nextInt();
    	x = new ArrayList[M + 1];
    	y = new ArrayList[N + 1];
    	chk = new boolean[K + 1];
    	bus = new Pair[K + 1];
    	
    	for(int i = 0; i <= M; i++)
    		x[i] = new ArrayList<>();
    	for(int i = 0; i <= N; i++)
    		y[i] = new ArrayList<>();
    	
    	for(int i = 0; i < K; i++) {
    		int idx = sc.nextInt();
    		int sx = sc.nextInt();
    		int sy = sc.nextInt();
    		int ex = sc.nextInt();
    		int ey = sc.nextInt();
    		
    		if(sy > ey) {
				int tmp = sy;
				sy = ey;
				ey = tmp;
			}
    		if(sx > ex) {
				int tmp = sx;
				sx = ex;
				ex = tmp;
			}
    		
    		if(sx == ex) x[sx].add(new Pair(idx, sx, sy, ex, ey));
    		else y[sy].add(new Pair(idx, sx, sy, ex, ey));
    		bus[idx] = new Pair(sx, sy, ex, ey);
    	}
    	
    	int sx = sc.nextInt();
    	int sy = sc.nextInt();
    	int ex = sc.nextInt();
    	int ey = sc.nextInt();
    	
    	if(sx == ex && sy == ey) {
    		System.out.println(0);
    		return;
    	}
    	
    	int res = solve(sx, sy, ex, ey);
    	System.out.println(res);
	}
	private static int solve(int sx, int sy, int ex, int ey) {
		Queue<Integer> q = new LinkedList<>();
		
		for(Pair next : x[sx])
			if(!chk[next.idx] && next.sy <= sy && sy <= next.ey) {
				chk[next.idx] = true;
				q.offer(next.idx);
			}
		for(Pair next : y[sy])
			if(!chk[next.idx] && next.sx <= sx && sx <= next.ex) {
				chk[next.idx] = true;
				q.offer(next.idx);
			}
		
		int time = 1, size = 0;
		
		while(!q.isEmpty()) {
			size = q.size();
			while(--size >= 0) {
				int idx = q.poll();
				Pair p = bus[idx];
				
				if(p.sy == p.ey) {
					if(p.sy == ey && p.sx <= ex && ex <= p.ex) return time;
					for(int i = p.sx; i <= p.ex; i++)
						for(Pair next : x[i])
							if(!chk[next.idx] && next.sy <= p.sy && p.sy <= next.ey) {
								chk[next.idx] = true;
								q.offer(next.idx);
							}
					for(Pair next : y[p.sy])
						if(!chk[next.idx] && !(next.sx > p.ex || p.sx > next.ex)) {
							chk[next.idx] = true;
							q.offer(next.idx);
						}
				}
				else {
					if(p.sx == ex && p.sy <= ey && ey <= p.ey) return time;
					for(int i = p.sy; i <= p.ey; i++)
						for(Pair next : y[i])
							if(!chk[next.idx] && next.sx <= p.sx && p.sx <= next.ex) {
								chk[next.idx] = true;
								q.offer(next.idx);
							}
					for(Pair next : x[p.sx])
						if(!chk[next.idx] && !(next.sy > p.ey || p.sy > next.ey)) {
							chk[next.idx] = true;
							q.offer(next.idx);
						}
				}
			}
			++time;
		}
		return 0;
	}
}
class Pair {
	int idx, sx, sy, ex, ey;
	Pair(int sx, int sy, int ex, int ey) {
		this.sx = sx;
		this.sy = sy;
		this.ex = ex;
		this.ey = ey;
	}
	Pair(int idx, int sx, int sy, int ex, int ey) {
		this.idx = idx;
		this.sx = sx;
		this.sy = sy;
		this.ex = ex;
		this.ey = ey;
	}
}