import java.util.*;

public class Main {
	static int N, M;
	static char[][] arr;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new char[N][M];
        int x1 = -1, y1 = 0, x2 = 0, y2 = 0;
        
        for(int i = 0; i < N; i++){
        	arr[i] = sc.next().toCharArray();
        	for(int j = 0; j < M; j++){
        		if(arr[i][j] == 'o'){
        			if(x1 == -1){
        				x1 = i;
        				y1 = j;
        			}
        			else{
        				x2 = i;
        				y2 = j;
        			}
        			arr[i][j] = '.';
        		}
        	}
        }
        
        bfs(x1, y1, x2, y2);
    }
	private static void bfs(int x1, int y1, int x2, int y2) {
		boolean[][][][] chk = new boolean[N][M][N][M];
		chk[x1][y1][x2][y2] = true;
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(x1, y1, x2, y2));
		int size = 0, time = 0;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				for(int i = 0; i < 4; i++){
					int nx1 = p.x1 + dx[i], ny1 = p.y1 + dy[i], nx2 = p.x2 + dx[i], ny2 = p.y2 + dy[i];
					if(nx1 >= 0 && ny1 >= 0 && nx1 < N && ny1 < M && arr[nx1][ny1] == '#'){
						nx1 -= dx[i];
						ny1 -= dy[i];
					}
					if(nx2 >= 0 && ny2 >= 0 && nx2 < N && ny2 < M && arr[nx2][ny2] == '#'){
						nx2 -= dx[i];
						ny2 -= dy[i];
					}
					if((nx1 < 0 || ny1 < 0 || nx1 >= N || ny1 >= M) &&
					   (nx2 < 0 || ny2 < 0 || nx2 >= N || ny2 >= M)) continue;
					if(nx1 == nx2 && ny1 == ny2) continue;
					if((nx1 >= 0 && ny1 >= 0 && nx1 < N && ny1 < M) &&
					   (nx2 >= 0 && ny2 >= 0 && nx2 < N && ny2 < M) &&
						chk[nx1][ny1][nx2][ny2]) continue;
					
					if(check(new Pair(nx1, ny1, nx2, ny2))){
						System.out.println(time + 1);
						return;
					}
					
					chk[nx1][ny1][nx2][ny2] = true;
					q.offer(new Pair(nx1, ny1, nx2, ny2));
				}
			}
			++time;
		}
		
		System.out.println(-1);
	}
	private static boolean check(Pair p) {
		if((p.x1 < 0 || p.y1 < 0 || p.x1 >= N || p.y1 >= M) && (p.x2 >= 0 && p.x2 < N && p.y2 >= 0 && p.y2 < M)) return true;
		if((p.x2 < 0 || p.y2 < 0 || p.x2 >= N || p.y2 >= M) && (p.x1 >= 0 && p.x1 < N && p.y1 >= 0 && p.y1 < M)) return true;
		return false;
	}
}
class Pair{
	int x1, y1, x2, y2;
	Pair(int x1, int y1, int x2, int y2){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
}