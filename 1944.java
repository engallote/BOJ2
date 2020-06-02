import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, K;
	static int[] par, dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static char[][] arr;
	static int[][] num;
	static boolean[][] chk;
	static ArrayList<Pair> aly;
	static PriorityQueue<Pair> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new char[N][N];
		chk = new boolean[N][N];
		num = new int[N][N];
		aly = new ArrayList<>();
		par = new int[K+1];
		int idx = 0;
		
		for(int i = 0; i <= K; i++) 
			par[i] = i;
		
		for(int i = 0; i < N; i++){
			arr[i] = br.readLine().toCharArray();
			for(int j = 0; j < N; j++){
				if(arr[i][j] == 'S'){
					aly.add(new Pair(i, j));
					num[i][j] = idx++;
				}
				else if(arr[i][j] == 'K'){
					aly.add(new Pair(i, j));
					num[i][j] = idx++;
				}
			}
		}
		
		for(int i = 0; i <= K; i++)
			if(bfs(aly.get(i)) != K + 1){
				bw.write("-1");
				bw.flush();
				return;
			}
		
		int res = 0, cnt = 0;
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			
			int ap = find(p.x), bp = find(p.y);
			if(ap == bp) continue;
			
			par[bp] = ap;
			res += p.cnt;
			++cnt;
			if(cnt == K) break;
		}
		
		bw.write(res+"");
		bw.flush();
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
	private static int bfs(Pair pair) {
		for(int i = 0; i < N; i++)
			Arrays.fill(chk[i], false);
		
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(pair.x, pair.y, 0));
		chk[pair.x][pair.y] = true;
		int cnt = 0, size = 0;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				if(arr[p.x][p.y] == 'K' || arr[p.x][p.y] == 'S') ++cnt;
				
				for(int i = 0; i < 4; i++){
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N || chk[nx][ny] || arr[nx][ny] == '1')
						continue;
					chk[nx][ny] = true;
					q.offer(new Pair(nx, ny, p.cnt + 1));
					if(arr[nx][ny] == 'K' || arr[nx][ny] == 'S') 
						pq.offer(new Pair(num[pair.x][pair.y], num[nx][ny], p.cnt + 1));
				}
			}
		}
		
		return cnt;
	}
}
class Pair implements Comparable<Pair>{
	int x, y, cnt;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	Pair(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : (o.cnt == this.cnt ? 0 : 1);
	}
}