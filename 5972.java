import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M;
	static ArrayList<Pair>[] arr;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		int[] chk = new int[N+1];
		Arrays.fill(chk, Integer.MAX_VALUE);
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
		
		for(int i = 1; i <= N; i++)
			Collections.sort(arr[i]);
		
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		pq.offer(new Pair(1, 0));
		chk[1] = 0;
        
		int res = Integer.MAX_VALUE;
		while(!pq.isEmpty()){
			Pair p = pq.poll();
				if(p.v == N){
					res = Math.min(res, p.c);
					break;
				}
				
				for(Pair next : arr[p.v])
					if(chk[next.v] > p.c + next.c){
						chk[next.v] = p.c + next.c;
						pq.offer(new Pair(next.v, next.c + p.c));
					}
		}
		
		bw.write(res+"");
		bw.flush();
	}
}
class Pair implements Comparable<Pair>{
	int v, c;
	Pair(int v, int c){
		this.v = v;
		this.c = c;
	}
	@Override
	public int compareTo(Pair o) {
		return o.c > this.c ? -1 : o.c == this.c ? 0 : 1;
	}
}