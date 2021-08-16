import java.util.*;

public class Main {
	static int N, H, K, D, res, sx, sy, ex, ey;
	static char[][] map;
	static ArrayList<Pair> um = new ArrayList<>();
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	H = sc.nextInt();
    	D = sc.nextInt();
    	map = new char[N][N];
    	res = Integer.MAX_VALUE;
    	sx = 0;
    	sy = 0;
    	ex = 0;
    	ey = 0;
    	
    	for(int i = 0; i < N; i++) {
    		map[i] = sc.next().toCharArray();
    		for(int j = 0; j < N; j++) {
    			if(map[i][j] == 'S') {
    				map[i][j] = '.';
    				sx = i;
    				sy = j;
    			}
    			else if(map[i][j] == 'U')
    				um.add(new Pair(i, j));
    			else if(map[i][j] == 'E') {
    				ex = i;
    				ey = j;
    			}
    		}
    	}
    	
    	K = um.size();
    	ArrayList<Integer> path = new ArrayList<>();
    	back(0, 0, path);
        
        if(Math.abs(sx - ex) + Math.abs(sy - ey) < H) 
    		res = Math.min(res, Math.abs(sx - ex) + Math.abs(sy - ey));
    	
    	if(res == Integer.MAX_VALUE) res = -1;
    	System.out.println(res);
	}
	private static void back(int cnt, int chk, ArrayList<Integer> path) {
		if(solve(path)) {
			return;
		}
		
		for(int i = 0; i < K; i++)
			if((chk&(1<<i)) == 0) {
				path.add(i);
				back(cnt + 1, chk|(1<<i), path);
				path.remove(path.size() - 1);
			}
			
	}
	private static boolean solve(ArrayList<Integer> path) {
		int sum = 0, x = sx, y = sy, h = H, d = 0, dist;
		
		for(int nxt : path) {
			dist = Math.abs(x - um.get(nxt).x) + Math.abs(y - um.get(nxt).y);
			sum += dist;
			if(dist > h + d) return false;
			
			x = um.get(nxt).x;
			y = um.get(nxt).y;
			dist -= d;
            if(dist < 0) dist = 0;
			h -= dist;
			d = D;
		}
		
		dist = Math.abs(x - ex) + Math.abs(y - ey);
		if(dist > h + d) return false;
		
		sum += dist;
		res = Math.min(res, sum);
		return true;
	}
}
class Pair {
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}