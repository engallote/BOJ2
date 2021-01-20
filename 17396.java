import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M;
	static long[] see, chk;
	static ArrayList<Pair>[] arr;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        see = new long[N];
        chk = new long[N];
        arr = new ArrayList[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	see[i] = Integer.parseInt(st.nextToken());
        	arr[i] = new ArrayList<>();
        	chk[i] = Long.MAX_VALUE;
        }
        
        see[N - 1] = 0;
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	long c = Long.parseLong(st.nextToken());
        	if(see[a] == 1 || see[b] == 1) continue;
        	arr[a].add(new Pair(b, c));
        	arr[b].add(new Pair(a, c));
        }
        
        bfs();
    }
	private static void bfs() throws IOException {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(0, 0));
		chk[0] = 0;
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			if(p.v == N - 1) {
				bw.write(p.cost+"");
				bw.flush();
				return;
			}
			if(chk[p.v] != p.cost) continue;
			
			for(Pair next : arr[p.v])
				if(chk[next.v] > p.cost + next.cost) {
					chk[next.v] = p.cost + next.cost;
					pq.offer(new Pair(next.v, chk[next.v]));
				}
		}
		
		bw.write("-1");
		bw.flush();
	}
}
class Pair implements Comparable<Pair> {
	int v;
	long cost;
	Pair(int v, long cost) {
		this.v = v;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.cost > this.cost) return -1;
		else if(o.cost == this.cost) return 0;
		else return 1;
	}
}