import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, A, B, C;
	static ArrayList<Pair>[] arr;
	static long[] chk;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N + 1];
		chk = new long[N + 1];
		
		for(int i = 1; i <= N; i++)
			arr[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			arr[a].add(new Pair(b, c));
			arr[b].add(new Pair(a, c));
		}
		
		long l = 0, r = 10000000000l, mid, res = Long.MAX_VALUE;
		while(l <= r) {
			mid = (l + r) / 2;
			
			if(!bfs(mid)) l = mid + 1;
			else {
				res = Math.min(res, mid);
				r = mid - 1;
			}
		}
		
		bw.write(res == Long.MAX_VALUE ? "-1" : res+"");
		bw.flush();
	}
	private static boolean bfs(long m) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(A, 0l));
		Arrays.fill(chk, Long.MAX_VALUE);
		chk[A] = 0l;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			if(p.v == B && p.cost <= C) return true;
			if(chk[p.v] != p.cost) continue;
			
			for(Pair next : arr[p.v]) {
				if(next.cost <= m && chk[next.v] > p.cost + next.cost) {
					chk[next.v] = p.cost + next.cost;
					q.offer(new Pair(next.v, p.cost + next.cost));
				}
			}
		}
		
		return false;
	}
}
class Pair {
	int v;
	long cost;
	Pair(int v, long cost) {
		this.v = v;
		this.cost = cost;
	}
}