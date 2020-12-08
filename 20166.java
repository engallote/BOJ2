import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M;
	static char[][] map;
	static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1}, dy = {0, 1, 0, -1, 1, -1, 1, -1};
	static HashMap<String, Integer> hs = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		for(int i = 0; i < N; i++)
			map[i] = br.readLine().trim().toCharArray();
		
		String[] arr = new String[K];
		for(int i = 0; i < K; i++) {
			arr[i] = br.readLine().trim();
			hs.put(arr[i], 0);
		}
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++) 
				bfs(i, j);
		
		for(int i = 0; i < K; i++)
			bw.write(hs.get(arr[i]) + "\n");
		
		bw.flush();
	}
	private static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y, map[x][y]+""));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			if(hs.containsKey(p.path)) hs.replace(p.path, hs.get(p.path) + 1);
			if(p.path.length() == 5) continue;
			
			for(int i = 0; i < 8; i++) {
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0) nx = N - 1;
				if(ny < 0) ny = M - 1;
				if(nx >= N) nx = 0;
				if(ny >= M) ny = 0;
				
				q.offer(new Pair(nx, ny, p.path + "" + map[nx][ny]));
			}
		}
	}
}
class Pair{
	int x, y;
	String path;
	Pair(int x, int y, String path) {
		this.x = x;
		this.y = y;
		this.path = path;
	}
}