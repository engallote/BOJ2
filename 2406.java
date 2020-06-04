import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N;
	static int[] par;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		par = new int[N + 1];
		int count = 0;
		
		for(int i = 1; i <= N; i++)
			par[i] = i;
		
		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int ap = find(a), bp = find(b);
			if(ap == bp) continue;
			++count;
			par[bp] = ap;
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		for(int i = 1; i <= N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++){
				int num = Integer.parseInt(st.nextToken());
				if(i == 1 || j == 1 || i == j) continue;
				pq.offer(new Pair(i, j, num));
			}
		}
		
		if(count == N - 2){
			bw.write("0 0");
			bw.flush();
			return;
		}
		
		long res = 0;
		Queue<Pair> q = new LinkedList<Pair>();
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			
			int ap = find(p.x), bp = find(p.y);
			if(ap == bp) continue;
			
			par[bp] = ap;
			res += (long)p.cost;
			q.offer(new Pair(p.x, p.y));
			
			++count;
			if(count >= N - 2) break;
		}
			
		bw.write(res + " " + q.size() + "\n");
		while(!q.isEmpty())
			bw.write(q.peek().x + " " + q.poll().y + "\n");
		bw.flush();
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}
class Pair implements Comparable<Pair>{
	int x, y, cost;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	Pair(int x, int y, int cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cost > this.cost ? -1 : (o.cost == this.cost ? 0 : 1);
	}
}