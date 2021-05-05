import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	
    	int m = 1, idx = 0;
    	Queue<Pair>[] wait = new LinkedList[M + 1];
    	for(int i = 1; i <= M; i++)
    		wait[i] = new LinkedList<>();
    	
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int d = Integer.parseInt(st.nextToken());
    		int h = Integer.parseInt(st.nextToken());
    		wait[m].offer(new Pair(i, m, d, h));
    		++m;
    		if(m > M) m = 1;
    		
    		if(i == K)//µ¥Ä«
    			idx = i;
    	}
    	
    	int res = 0;
    	PriorityQueue<Pair> pq = new PriorityQueue<>();
    	
    	for(int i = 1; i <= M; i++)
    		if(!wait[i].isEmpty()) pq.offer(wait[i].poll());
    	
    	while(true) {
    		Pair p = pq.poll();
    		
    		if(p.idx == idx) break;
    		if(!wait[p.line].isEmpty()) pq.offer(wait[p.line].poll());
    		++res;
    	}
    	
    	bw.write(res+"");
    	bw.flush();
	}
}
class Pair implements Comparable<Pair>{
	int idx, line, d, h;
	Pair(int idx, int line, int d, int h) {
		this.idx = idx;
		this.line = line;
		this.d = d;
		this.h = h;
	}
	@Override
	public int compareTo(Pair o) {
		if(this.d > o.d) return -1;
		else if(this.d == o.d) {
			if(this.h > o.h) return -1;
			else if(this.h == o.h) return Integer.compare(this.line, o.line);
			else return 1;
		}
		return 1;
	}
}