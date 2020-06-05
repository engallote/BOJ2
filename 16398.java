import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int[] par;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        par = new int[N];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int count = 0;
        StringTokenizer st;
        for(int i = 0; i < N; i++){
        	par[i] = i;
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < N; j++){
        		int num = Integer.parseInt(st.nextToken());
        		
        		if(i == j) continue;
        		pq.offer(new Pair(i, j, num));
        	}
        }
        
        long res = 0;
        while(!pq.isEmpty()){
        	Pair p = pq.poll();
        	
        	int ap = find(p.a), bp = find(p.b);
        	if(ap == bp) continue;
        	
        	par[bp] = ap;
        	res += (long)p.c;
        	++count;
        	if(count == N - 1) break;
        }
        
        bw.write(res+"");
        bw.flush();
    }
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}
class Pair implements Comparable<Pair>{
	int a, b, c;
	Pair(int a, int b, int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	@Override
	public int compareTo(Pair o) {
		return o.c > this.c ? -1 : (o.c == this.c ? 0 : 1);
	}
}