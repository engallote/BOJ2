import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		boolean[][][] chk = new boolean[N][M][2];
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		PriorityQueue<Pair> q = new PriorityQueue<>();
		q.offer(new Pair(0, 0, 0, 0));
		chk[0][0][0] = true;
		
		while(!q.isEmpty()){
			Pair p = q.poll();
			
			if(p.x == N - 1 && p.y == M - 1){
				System.out.println(p.cnt);
				return;
			}
			
			for(int i = 0; i < 4; i++){
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(!can(nx, ny, p.orange)) 
					continue;
				int count = 1;
				int smell = p.orange;
				if(arr[nx][ny] == 4){
					while(can(nx + dx[i], ny + dy[i], smell) && arr[nx][ny] == 4){
						nx += dx[i];
						ny += dy[i];
						count++;
						smell = 0;
					}
				}
				
				if(arr[nx][ny] == 2) smell = 1;
				if(!chk[nx][ny][smell]){
					chk[nx][ny][smell] = true;
					q.offer(new Pair(nx, ny, smell, p.cnt + count));
				}
			}
		}
		
		bw.write("-1\n");
		bw.flush();
	}

	private static boolean can(int nx, int ny, int orange) {
		if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 0) return false;
		if(orange == 0 && arr[nx][ny] == 3) return false;
		return true;
	}
}
class Pair implements Comparable<Pair>{
	int x, y, orange, cnt;
	Pair(int x, int y, int orange, int cnt){
		this.x = x;
		this.y = y;
		this.orange = orange;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : (o.cnt == this.cnt ? 0 : 1);
	}
}