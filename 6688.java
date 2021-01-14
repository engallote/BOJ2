import java.util.*;

public class Main {
	static int N, M;
	static int[] cnt, res;
	static char[][] arr;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static int[][] chk;
	static boolean[][] visit;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
        	N = sc.nextInt();
        	M = sc.nextInt();
        	
        	if(N == 0 && M == 0) break;
        	
        	arr = new char[N][M];
        	chk = new int[N][M];
        	visit = new boolean[N][M];
        	
        	for(int i = 0; i < N; i++)
        		arr[i] = sc.next().toCharArray();
        	
        	int idx = 1;
        	cnt = new int[1000];
        	for(int i = 0; i < N; i++)
        		for(int j = 0; j < M; j++)
        			if((arr[i][j] == 'X' || arr[i][j] == '*') && !visit[i][j]) {
        				count(i, j, idx);
        				++idx;
        			}
        	
        	res = new int[idx];
        	
        	for(int i = 0; i < N; i++)
        		Arrays.fill(visit[i], false);
        	
        	for(int i = 0; i < N; i++)
        		for(int j = 0; j < M; j++)
        			if(arr[i][j] == 'X' && !visit[i][j]) {
        				++res[chk[i][j]];
        				visit[i][j] = true;
        				
        				bfs(i, j);
        			}
        	
        	System.out.print("Throw: ");
        	Arrays.sort(res);
        	
        	for(int i = 1; i < idx; i++)
        		System.out.print(res[i] + " ");
        	System.out.println();
        }
    }
	private static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			for(int k = 0; k < 4; k++) {
				int nx = p.x + dx[k], ny = p.y + dy[k];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] != 'X' || visit[nx][ny])
					continue;
				visit[nx][ny] = true;
				q.offer(new Pair(nx, ny));
			}
		}
	}
	private static void count(int x, int y, int idx) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		chk[x][y] = idx;
		int count = 0;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			for(int i = 0; i < 4; i++){
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == '.' || visit[nx][ny])
					continue;
				if(arr[nx][ny] == 'X') ++count;
				visit[nx][ny] = true;
				chk[nx][ny] = idx;
				q.offer(new Pair(nx, ny));
			}
		}
		
		cnt[idx] = count;
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}