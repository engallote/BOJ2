import java.util.*;

public class Main {
	static int N, M, clen, plen;
	static char[][] map;
	static ArrayList<Pair> car, park;
	static int[][] dist;
	static boolean[] visit;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1}, chk;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	map = new char[N][M];
    	car = new ArrayList<>();
    	park = new ArrayList<>();
    	
    	for(int i = 0; i < N; i++) {
    		map[i] = sc.next().toCharArray();
    		for(int j = 0; j < M; j++) {
    			if(map[i][j] == 'C') car.add(new Pair(i, j));
    			else if(map[i][j] == 'P') park.add(new Pair(i, j));
    		}
    	}
    	
    	if(car.isEmpty()) {
    		System.out.println(0);
    		return;
    	}
    	if(car.size() > park.size()) {
    		System.out.println(-1);
    		return;
    	}
    	
    	clen = car.size();
    	plen = park.size();
    	chk = new int[plen];
    	dist = new int[clen][plen];
    	visit = new boolean[clen];
    	
    	for(int i = 0; i < clen; i++)
    		for(int j = 0; j < plen; j++)
    			dist[i][j] = bfs(car.get(i), park.get(j));
    	
    	int res = -1, l = 0, r = 10000000, mid;
    	while(l <= r) {
    		mid = (l + r) / 2;
    		
        	Arrays.fill(chk, -1);
    		int cnt = 0;
        	for(int i = 0; i < clen; i++) {
        		Arrays.fill(visit, false);
        		if(solve(i, mid)) ++cnt;
        	}
        	
        	if(cnt < clen) l = mid + 1;
        	else {
        		res = mid;
        		r = mid - 1;
        	}
    	}
    	
    	System.out.println(res);
	}
	private static boolean solve(int idx, int time) {
		if(visit[idx]) return false;
		visit[idx] = true;
		
		for(int i = 0; i < plen; i++)
			if(dist[idx][i] != -1 && dist[idx][i] <= time) {
				if(chk[i] == -1 || solve(chk[i], time)) {
					chk[i] = idx;
					return true;
				}
			}
		
		return false;
	}
	private static int bfs(Pair s, Pair e) {
		Queue<Pair> q = new LinkedList<>();
		boolean[][] chk = new boolean[N][M];
		chk[s.x][s.y] = true;
		q.offer(s);
		int time = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				if(p.x == e.x && p.y == e.y) return time;
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 'X' || chk[nx][ny]) 
						continue;
					chk[nx][ny] = true;
					q.offer(new Pair(nx, ny));
				}
			}
			++time;
		}
		
		return -1;
	}
}
class Pair {
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}