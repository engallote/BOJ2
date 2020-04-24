import java.util.*;

public class Main {
	static int N, M;
	static char[][] arr;
	static int[][] chk;
	static int[] dx = {0, 1, 1, 1, 0, 0, 0, -1, -1, -1}, dy = {0, -1, 0, 1, -1, 0, 1, -1, 0, 1};
	static Queue<Pair> q = new LinkedList<Pair>();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new char[N][M];
        chk = new int[N][M];
        int x = 0, y = 0;
        
        for(int i = 0; i < N; i++){
        	arr[i] = sc.next().toCharArray();
        	for(int j = 0; j < M; j++){
        		if(arr[i][j] == 'I'){
        			arr[i][j] = '.';
        			x = i;
        			y = j;
        		}
        		else if(arr[i][j] == 'R'){
        			arr[i][j] = '.';
        			q.offer(new Pair(i, j));
        		}
        	}
        }
        
        char[] order = sc.next().toCharArray();
        int i = 0;
        for(; i < order.length; i++){
        	int c = order[i] - '0';
        	x += dx[c];
        	y += dy[c];
        	if(arr[x][y] == 'R') break;
        	if(playAd(x, y)) break;
        }
        
        if(i < order.length) System.out.println("kraj " + (i + 1));
        else{
        	arr[x][y] = 'I';
        	for(i = 0; i < N; i++)
        		System.out.println(new String(arr[i]));
        }
    }
	private static boolean playAd(int x, int y) {
		Queue<Pair> tmp = new LinkedList<Pair>();
		for(int i = 0; i < N; i++)
			Arrays.fill(chk[i], 0);
		
		int d = 0, min = Integer.MAX_VALUE;
		while(!q.isEmpty()){
			Pair p = q.poll();
			arr[p.x][p.y] = '.';
			d = 0;
			min = Integer.MAX_VALUE;
			
			for(int i = 1; i < 10; i++){
				if(i == 5) continue;
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				int sub = Math.abs(nx - x) + Math.abs(ny - y);
				
				if(min > sub){
					min = sub;
					d = i;
				}
			}
			
			tmp.offer(new Pair(p.x + dx[d], p.y + dy[d]));
			++chk[p.x + dx[d]][p.y + dy[d]];
		}
		
		while(!tmp.isEmpty()){
			Pair p = tmp.poll();
			
			if(p.x == x && p.y == y) return true;
			if(chk[p.x][p.y] == 1){
				arr[p.x][p.y] = 'R';
				q.offer(p);
			}
		}
		
		return false;
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}