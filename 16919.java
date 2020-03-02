import java.util.*;

public class Main {
	static int R, C;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static char[][] arr;
	static char[][][] res;
	static HashSet<String> hs = new HashSet<>();
	static Queue<Pair> q = new LinkedList<Pair>();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        int N = sc.nextInt();
        arr = new char[R][C];
        res = new char[5][R][C];
        
        for(int i = 0; i < R; i++){
        	arr[i] = sc.next().toCharArray();
        	for(int j = 0; j < C; j++)
        		if(arr[i][j] == 'O') q.offer(new Pair(i, j, 3));
        }
        
        if(N <= 1){
        	for(int i = 0; i < R; i++)
        		System.out.println(new String(arr[i]));
        	return;
        }
        
        int size;
        for(int k = 1; k <= 5; k++){
        	if(k == 1) {
        		timer();
        		continue;
        	}
        	if(k % 2 == 0){
        		timer();
        		for(int i = 0; i < R; i++)
            		for(int j = 0; j < C; j++){
            			if(arr[i][j] == '.') q.offer(new Pair(i, j, 3));
            			arr[i][j] = 'O';
            		}
            			
        	}
        	else{
        		size = q.size();
    			while(--size >= 0){
    				Pair p = q.poll();
    				if(p.t - 1 == 0) solve(p);
    				if(arr[p.x][p.y] == '.') continue;
    				else q.offer(new Pair(p.x, p.y, p.t - 1));
    			}
        	}
        	
        	for(int i = 0; i < R; i++)
        		for(int j = 0; j < C; j++)
        			res[(k - 1) % 4][i][j] = arr[i][j];
        }
        
        int idx = (N - 1) % 4;
        for(int i = 0; i < R; i++)
        	System.out.println(new String(res[idx][i]));
    }
	private static void timer() {
		int size = q.size();
		while(--size >= 0){
			Pair p = q.poll();
			q.offer(new Pair(p.x, p.y, p.t - 1));
		}
	}
	private static void solve(Pair p) {
		arr[p.x][p.y] = '.';
		for(int i = 0; i < 4; i++){
			int nx = p.x + dx[i], ny = p.y + dy[i];
			if(nx < 0 || ny < 0 || nx >= R || ny >= C || arr[nx][ny] == '.') continue;
			arr[nx][ny] = '.';
		}
	}
}
class Pair{
	int x, y, t;
	Pair(int x, int y, int t){
		this.x = x;
		this.y = y;
		this.t = t;
	}
}