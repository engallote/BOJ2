import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int T = Integer.parseInt(st.nextToken());
    	int W = Integer.parseInt(st.nextToken());
    	Queue<Pair> q = new LinkedList<>();
    	
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int p = Integer.parseInt(st.nextToken());
    		int t = Integer.parseInt(st.nextToken());
    		q.offer(new Pair(p, t));
    	}
    	
    	PriorityQueue<Pair> pq = new PriorityQueue<>();
    	int M = Integer.parseInt(br.readLine());
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int p = Integer.parseInt(st.nextToken());
    		int t = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		
    		pq.offer(new Pair(p, t, c));
    	}
    	
    	int time = 0;
    	Pair cur = q.poll();
    	for(int i = 1; i <= W; i++) {
    		if(!pq.isEmpty() && pq.peek().come == i) q.offer(pq.poll());
    		if(time < T) {
    			cur.time -= 1;
    			++time;
    			bw.write(cur.idx + "\n");
    			
    			if(cur.time == 0) time = T;
    		}
    		
    		if(time == T) {
    			time = 0;
    			if(cur.time > 0) q.offer(cur);
    			if(q.isEmpty()) continue;
    			cur = q.poll();
    		}
    	}
    	
    	bw.flush();
	}
}
class Pair implements Comparable<Pair>{
	int idx, time, come;
	Pair(int idx, int time) {
		this.idx = idx;
		this.time = time;
	}
	Pair(int idx, int time, int come) {
		this.idx = idx;
		this.time = time;
		this.come = come;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.come, o.come);
	}
}