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
//    	Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	par = new int[N + 1];
    	PriorityQueue<Pair> pq = new PriorityQueue<>();
    	long all = 0;
    	
    	for(int i = 0; i <= N; i++) par[i] = i;
    	
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		long c = Long.parseLong(st.nextToken());
    		
    		if(a > b) {
    			int tmp = a;
    			a = b;
    			b = tmp;
    		}
    		
    		pq.offer(new Pair(a, b, c));
    		all += c;
    	}
    	
    	int cnt = 0;
    	long res = 0;
    	while(!pq.isEmpty()) {
    		Pair p = pq.poll();
    		int ap = find(p.a), bp = find(p.b);
    		
    		if(ap == bp) continue;
    		
    		res += p.c;
    		par[bp] = ap;
    		++cnt;
    		if(cnt == N - 1) break;
    	}
    	
    	if(cnt == N - 1) bw.write((all-res)+"");
    	else bw.write("-1");
    	
    	bw.flush();
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}
class Pair implements Comparable<Pair> {
	int a, b;
	long c;
	Pair(int a, int b, long c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	@Override
	public int compareTo(Pair o) {
		return Long.compare(this.c, o.c);
	}
}