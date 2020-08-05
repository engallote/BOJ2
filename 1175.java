import java.util.*;

public class Main {
	static int N, M, res;
	static int[][] arr;
	static boolean[][][][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        res = Integer.MAX_VALUE;
        arr = new int[N][M];
        chk = new boolean[N][M][1<<3][4];
        int x = 0, y = 0, idx = 0;
        
        for(int i = 0; i < N; i++){
        	char[] ch = sc.next().toCharArray();
        	for(int j = 0; j < M; j++){
        		if(ch[j] == 'S'){
        			x = i;
        			y = j;
        		}
        		else if(ch[j] == 'C') arr[i][j] = ++idx;
        		else if(ch[j] == '#') arr[i][j] = 9;
        	}
        }
        
        bfs(x, y);
    }
	private static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(x, y, 0, 0));
		q.offer(new Pair(x, y, 0, 1));
		q.offer(new Pair(x, y, 0, 2));
		q.offer(new Pair(x, y, 0, 3));
		int size, time = 0;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				if(p.cnt == 6){
					System.out.println(time);
					return;
				}
				
				for(int i = 0; i < 4; i++){
					if(i == p.d) continue;
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny][p.cnt][i] || arr[nx][ny] == 9)
						continue;
					if(arr[nx][ny] == 0){
						chk[nx][ny][p.cnt][i] = true;
						q.offer(new Pair(nx, ny, p.cnt, i));
					}
					else{
						chk[nx][ny][p.cnt|(1<<arr[nx][ny])][i] = true;
						q.offer(new Pair(nx, ny, p.cnt|(1<<arr[nx][ny]), i));
					}
				}
			}
			++time;
		}
		
		System.out.println(-1);
	}
}
class Pair{
	int x, y, cnt, d;
	Pair(int x, int y, int cnt, int d){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.d = d;
	}
}