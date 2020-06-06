import java.util.*;

public class Main {
	static int N, D;
	static Pair[] arr;
	static int[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		D = sc.nextInt();
		arr = new Pair[N];
		chk = new int[D + 1];
		Arrays.fill(chk, Integer.MAX_VALUE);
		
		for(int i = 0; i < N; i++)
			arr[i] = new Pair(sc.nextInt(), sc.nextInt(), sc.nextInt());
		
		int res = solve();
		System.out.println(res);
	}
	private static int solve() {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(0, 0));
		chk[0] = 0;
		
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			
			if(p.x == D) return p.c;
			
			if(chk[p.x + 1] > p.c + 1){
				chk[p.x + 1] = p.c + 1;
				pq.offer(new Pair(p.x + 1, p.c + 1));
			}
			for(int i = 0; i < N; i++)
				if(p.x <= arr[i].x && arr[i].y <= D && chk[arr[i].y] > p.c + (arr[i].x - p.x) + arr[i].c){
					chk[arr[i].y] = p.c + (arr[i].x - p.x) + arr[i].c;
					pq.offer(new Pair(arr[i].y, chk[arr[i].y]));
				}
		}
		return 0;
	}
}
class Pair implements Comparable<Pair>{
	int x, y, c;
	Pair(int x, int y, int c){
		this.x = x;
		this.y = y;
		this.c = c;
	}
	Pair(int x, int c){
		this.x = x;
		this.c = c;
	}
	@Override
	public int compareTo(Pair o) {
		return o.c > this.c ? -1 : (o.c == this.c ? 0 : 1);
	}
}