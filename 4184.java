import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M;
	static char[][] arr;
	static int[][] chk;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}, dy = {0, 1, 1, 1, 0, -1, -1, -1};
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		chk = new int[N][M];
		
		for(int i = 0; i < N; i++)
			arr[i] = br.readLine().trim().toCharArray();
		
		int Q = Integer.parseInt(br.readLine());
		
		while(--Q >= 0){
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken()) - 1;
			int sy = Integer.parseInt(st.nextToken()) - 1;
			int ex = Integer.parseInt(st.nextToken()) - 1;
			int ey = Integer.parseInt(st.nextToken()) - 1;
			
			if(sx == ex && sy == ey){
				bw.write("0\n");
				continue;
			}
			
			bw.write(bfs(sx, sy, ex, ey) + "\n");
		}
		bw.flush();
	}

	private static int bfs(int x, int y, int ex, int ey) {
		for(int i = 0; i < N; i++)
			Arrays.fill(chk[i], Integer.MAX_VALUE);
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(x, y, 0));
		
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			
			if(p.x == ex && p.y == ey) return p.cnt;

			for(int i = 0; i < 8; i++){
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				if(arr[p.x][p.y] - '0' == i && chk[nx][ny] > p.cnt){//no energy
					chk[nx][ny] = p.cnt;
					pq.offer(new Pair(nx, ny, p.cnt));
				}
				else if(chk[nx][ny] > p.cnt + 1){
					chk[nx][ny] = p.cnt + 1;
					pq.offer(new Pair(nx, ny, p.cnt + 1));
				}
			}
		}	
		
		return 0;
	}
}
class Pair implements Comparable<Pair>{
	int x, y, cnt;
	Pair(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : 1;
	}
}