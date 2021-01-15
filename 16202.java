import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, K;
	static int[] par, dist;
	static boolean[][] chk;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        par = new int[N + 1];
        dist = new int[N + 1];
        chk = new boolean[N + 1][N + 1];
        
        reset();
        PriorityQueue<Pair> pq = new PriorityQueue<>(), tmp = new PriorityQueue<>();
        for(int i = 1; i <= M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	chk[a][b] = chk[b][a] = true;
        	pq.offer(new Pair(a, b, i));
        }
        
        boolean go = bfs();
        int res = 0;
        while(--K >= 0) {
        	res = 0;
        	if(!go) {
        		bw.write("0 ");
        		continue;
        	}
        	while(!pq.isEmpty()) {
        		Pair p = pq.poll();
        		int ap = find(p.a), bp = find(p.b);
        		
        		tmp.offer(p);
        		if(ap == bp) continue;
        		par[bp] = ap;
        		res += p.c;
        	}
        	reset();
        	bw.write(res + " ");
        	Pair p = tmp.poll();
        	chk[p.a][p.b] = chk[p.b][p.a] = false;
        	pq.addAll(tmp);
        	tmp.clear();
        	go = bfs();
        }
        bw.flush();
    }
	private static boolean bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		dist[1] = 0;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			
			for(int i = 1; i <= N; i++)
				if(chk[x][i] && dist[i] == Integer.MAX_VALUE) {
					dist[i] = dist[x] + 1;
					q.offer(i);
				}
		}
		
		for(int i = 1; i <= N; i++)
			if(dist[i] == Integer.MAX_VALUE) return false;
		
		return true;
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
	private static void reset() {
		for(int i = 1; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
			par[i] = i;
		}
	}
}
class Pair implements Comparable<Pair>{
	int a, b, c;
	Pair(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.c, o.c);
	}
}