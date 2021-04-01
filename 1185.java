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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        par = new int[N+1];
        int[] cost = new int[N+1];
        int min = Integer.MAX_VALUE;
        
        for(int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(br.readLine());
            par[i] = i;
            min = Math.min(min, cost[i]);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0; i < P; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            c = cost[a] + cost[b] + c + c;

            pq.offer(new Pair(a, b, c));
        }

        int res = 0, cnt = 0;
        while(!pq.isEmpty()){
        	Pair p = pq.poll();
            int ap = find(p.a), bp = find(p.b);

            if(ap == bp) continue;
            ++cnt;
            par[bp] = ap;
            res += p.cost;
            if(cnt == N - 1) break;
        }
        
        res += min;
        bw.write(res+"\n");
        bw.flush();
    }

    static int find(int x){
        if(par[x] == x) return x;
        return par[x] = find(par[x]);
    }
    
    static class Pair implements Comparable<Pair> {
        int a, b, cost;
        Pair(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
        @Override
	    public int compareTo(Pair o) {
		    return Integer.compare(this.cost, o.cost);
	    }
    }
}