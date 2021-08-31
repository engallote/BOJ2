import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, A, B, C, M;
	static int[][] chk;
	static ArrayList<Pair>[] arr;
    public static void main(String[] args) throws IOException {
//    	Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	A = Integer.parseInt(st.nextToken());
    	B = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	chk = new int[3][N + 1];
    	arr = new ArrayList[N + 1];
    	
    	for(int i = 0; i < 3; i++) Arrays.fill(chk[i], Integer.MAX_VALUE);
    	for(int i = 1; i <= N; i++) arr[i] = new ArrayList<>();
    	
    	chk[0][A] = chk[1][B] = chk[2][C] = 0;
    	
    	M = Integer.parseInt(br.readLine());
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int D = Integer.parseInt(st.nextToken());
    		int E = Integer.parseInt(st.nextToken());
    		int L = Integer.parseInt(st.nextToken());
    		arr[D].add(new Pair(E, L));
    		arr[E].add(new Pair(D, L));
    	}
    	
    	getD();
	}
	private static void getD() {
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		pq.offer(new Pair(0, A, 0));
		pq.offer(new Pair(1, B, 0));
		pq.offer(new Pair(2, C, 0));
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			for(Pair next : arr[p.v])
				if(chk[p.idx][next.v] > p.l + next.l) {
					chk[p.idx][next.v] = p.l + next.l;
					pq.offer(new Pair(p.idx, next.v, chk[p.idx][next.v]));
				}
		}
		
		int res = 0, max = -1;
		for(int i = 1; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < 3; j++)
				min = Math.min(min, chk[j][i]);
			
			if(max < min) {
				max = min;
				res = i;
			}
		}
		
		System.out.println(res);
	}
}
class Pair implements Comparable<Pair>{
	int idx, v, l;
	Pair(int v, int l) {
		this.v = v;
		this.l = l;
	}
	Pair(int idx, int v, int l) {
		this.idx = idx;
		this.v = v;
		this.l = l;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.l, o.l);
	}
}