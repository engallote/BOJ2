import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr, map, chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static ArrayList<Pair> aly;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		map = new int[N][M];
		chk = new int[N][M];
		aly = new ArrayList<>();
		
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) aly.add(new Pair(i, j));
			}
		}
		
		int res = bfs();
			
		bw.write(res+"");
		bw.flush();
	}
	private static int bfs() {
		PriorityQueue<Pair> q = new PriorityQueue<>();
		for(int i = 0; i < N; i++)
			Arrays.fill(chk[i], Integer.MAX_VALUE);
		
		q.offer(new Pair(0, 0, 0));
		chk[0][0] = -1;
		int ret = 0;
		
		while(!q.isEmpty()){
			Pair p = q.poll();
			
			for(int i = 0; i < 4; i++){
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				int max = Math.max(Math.abs(arr[nx][ny] - arr[p.x][p.y]), p.dif);
				if(chk[nx][ny] <= max) continue;
				chk[nx][ny] = max;
				q.offer(new Pair(nx, ny, max));
			}
		}
		
		for(int i = 0; i < aly.size(); i++)
			ret = Math.max(ret, chk[aly.get(i).x][aly.get(i).y]);
		
		return ret;
	}
}
class Pair implements Comparable<Pair>{
	int x, y, dif;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	Pair(int x, int y, int dif){
		this.x = x;
		this.y = y;
		this.dif = dif;
	}
	@Override
	public int compareTo(Pair o) {
		return o.dif > this.dif ? -1 : (o.dif == this.dif ? 0 : 1);
	}
}