import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M, min, max;
	static ArrayList<Pair>[] arr;
	static int[] chk;
	public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        chk = new int[N+1];
        min = Integer.MAX_VALUE;
        max = -1;
        
        for(int i = 1; i <= N; i++)
        	arr[i] = new ArrayList<>();
        
        for(int i = 0; i < M; i++){
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	arr[a].add(new Pair(b, c));
        	arr[b].add(new Pair(a, c));
        }
        
        if(arr[N].size() == 1 || arr[1].size() == 1){
        	bw.write("-1");
        	bw.flush();
        	return;
        }
        
        bfs(0);
        
        for(int i = 2; i < N; i++){
        	bfs(i);
			if(max == Integer.MAX_VALUE){
				bw.write("-1");
				bw.flush();
				return;
			}
        }
        
        if(max == Integer.MAX_VALUE) bw.write("-1");
        else bw.write((max-min)+"");
        bw.flush();
	}
	private static void bfs(int x) {
		Arrays.fill(chk, Integer.MAX_VALUE);
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(1, 0));
		chk[x] = -1;
		chk[1] = 0;
		
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			
			if(p.v == N){
				min = Math.min(min, p.cost);
				max = Math.max(max, p.cost);
				return;
			}
			
			for(Pair next : arr[p.v])
				if(chk[next.v] > p.cost + next.cost){
					chk[next.v] = p.cost + next.cost;
					pq.offer(new Pair(next.v, chk[next.v]));
				}
		}
		
		max = Integer.MAX_VALUE;
	}
}
class Pair implements Comparable<Pair>{
	int v, cost;
	Pair(int v, int cost){
		this.v = v;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cost > this.cost ? -1 : (o.cost == this.cost ? 0 : 1);
	}
}