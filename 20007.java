import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M, X, Y;
	static ArrayList<Pair>[] arr;
	static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());//최대거리
		Y = Integer.parseInt(st.nextToken());//성현이 집
		arr = new ArrayList[N];
		dist = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = new ArrayList<>();
			dist[i] = 1000000000;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			arr[a].add(new Pair(b, d));
			arr[b].add(new Pair(a, d));
		}
		
		bfs();
		
		Arrays.sort(dist);
		int res = 1, cur = 0;
		for(int i = 0; i < N; i++) {
			if(dist[i] * 2 > X) {
				res = -1;
				break;
			}
			if(cur + dist[i] * 2 <= X) cur += dist[i] * 2;
			else {
				cur = dist[i] * 2;
				++res;
			}
		}
		
		bw.write(res+"");
		bw.flush();
	}
	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(Y);
		dist[Y] = 0;
		int size;
		
		while(!q.isEmpty()) {
			size = q.size();
			while(--size >= 0) {
				int x = q.poll();
				
				for(Pair next : arr[x])
					if(dist[next.v] > dist[x] + next.d) {
						dist[next.v] = dist[x] + next.d;
						q.offer(next.v);
					}
			}
		}
	}
}
class Pair{
	int v, d;
	Pair(int v, int d) {
		this.v = v;
		this.d = d;
	}
}