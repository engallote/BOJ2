import java.util.*;

public class Main {
	static int N, M;
	static char[][] map;
	static ArrayList<Pair> aly = new ArrayList<>();
	static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1}, dy = {0, 1, 0, -1, 1, -1, 1, -1};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new char[N][M];
        
        for(int i = 0; i < N; i++) {
        	map[i] = sc.next().toCharArray();
        	for(int j = 0; j < M; j++)
        		if(map[i][j] == 'o') aly.add(new Pair(i, j));
        }
        
        int res = 0, max = 0, x = 0, y = 0;
        for(int i = 0; i < N; i++)
        	for(int j = 0; j < M; j++)
        		if(map[i][j] == '.') {
        			int sum = 0;
        			for(int k = 0; k < 8; k++) {
        				int nx = i + dx[k], ny = j + dy[k];
        				if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == '.') continue;
        				++sum;
        			}
        			if(sum > max) {
        				max = sum;
        				x = i;
        				y = j;
        			}
        		}
        
        map[x][y] = 'o';
        aly.add(new Pair(x, y));
        
        res = bfs();
        System.out.println(res);
	}
	private static int bfs() {
		boolean[][] chk = new boolean[N][M];
		int sum = 0;
		
		for(Pair p : aly) {
			chk[p.x][p.y] = true;
			for(int i = 0; i < 8; i++) {
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] || map[nx][ny] == '.') continue;
				++sum;
			}
		}
		
		return sum;
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}