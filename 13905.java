import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static ArrayList<Pair>[] arr;
	static int[] chk;
	public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        chk = new int[N+1];
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
        
        for(int i = 1; i <= N; i++){
        	arr[i] = new ArrayList<>();
        	chk[i] = -1;
        }
        
        for(int i = 0; i < M; i++){
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	arr[a].add(new Pair(b, c));
        	arr[b].add(new Pair(a, c));
        }
        
        bfs(s, e);
    }
	private static void bfs(int s, int e) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(s, 1000000));
		
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			
			if(p.v == e){
				System.out.println(p.w);
				return;
			}
			
			for(Pair next : arr[p.v])
				if(chk[next.v] < Math.min(p.w, next.w)){
					chk[next.v] = Math.min(p.w, next.w);
					pq.offer(new Pair(next.v, chk[next.v]));
				}
		}
		System.out.println(0);
	}
}
class Pair implements Comparable<Pair>{
	int v, w;
	Pair(int v, int w){
		this.v = v;
		this.w = w;
	}
	@Override
	public int compareTo(Pair o) {
		return o.w > this.w ? 1 : (o.w == this.w ? 0 : -1);
	}
}