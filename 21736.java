import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);    	
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	char[][] map = new char[N][M];
    	boolean[][] chk = new boolean[N][M];
    	int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    	
    	int x = 0, y = 0;
    	for(int i = 0; i < N; i++) {
    		map[i] = sc.next().toCharArray();
    		for(int j = 0; j < M; j++)
    			if(map[i][j] == 'I') {
    				x = i;
    				y = j;
    				map[i][j] = 'O';
    				chk[i][j] = true;
    			}
    	}
    	
    	int res = 0;
    	Queue<Pair> q = new LinkedList<>();
    	q.offer(new Pair(x, y));
    	
    	while(!q.isEmpty()) {
    		Pair p = q.poll();
    		
    		for(int i = 0; i < 4; i++) {
    			int nx = p.x + dx[i], ny = p.y + dy[i];
    			
    			if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] || map[nx][ny] == 'X')
    				continue;
    			if(map[nx][ny] == 'P') ++res;
    			
    			chk[nx][ny] = true;
    			q.offer(new Pair(nx, ny));
    		}
    	}
    	
    	System.out.println(res == 0 ? "TT" : res);
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}