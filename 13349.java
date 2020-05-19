import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr, chk, dist;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        chk = new int[N][M];
        dist = new int[N][M];
        
        for(int i = 0; i < N; i++){
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < M; j++){
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		chk[i][j] = Integer.MAX_VALUE;
        		dist[i][j] = Integer.MAX_VALUE;
        	}
        }
        
        bfs();
    }
	private static void bfs() {
		PriorityQueue<Pair> q = new PriorityQueue<>();
		q.offer(new Pair(0, 0, 0));
		chk[0][0] = 0;
		int size;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				if(p.x == N - 1 && p.y == M - 1){
					System.out.println(p.need);
					return;
				}
				
				for(int i = 0; i < 4; i++){
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
					
					if(arr[nx][ny] <= arr[p.x][p.y] && chk[nx][ny] > p.need){//down
						chk[nx][ny] = p.need;
						q.offer(new Pair(nx, ny, p.need));
					}
					else if(arr[nx][ny] > arr[p.x][p.y]){//up
						int max = Math.max(p.need, arr[nx][ny] - arr[p.x][p.y]);
						if(chk[nx][ny] > max){
							chk[nx][ny] = max;
							q.offer(new Pair(nx, ny, max));
						}
					}
				}
			}
		}
	}
}
class Pair implements Comparable<Pair>{
	int x, y, need;
	Pair(int x, int y, int need){
		this.x = x;
		this.y = y;
		this.need = need;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.need > this.need) return -1;
		else if(o.need == this.need) return 0;
		else return 1;
	}
}