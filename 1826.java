import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		PriorityQueue<Integer> tmp = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 0; i < N; i++)
			pq.offer(new Pair(sc.nextInt(), sc.nextInt()));
		
		int L = sc.nextInt();
		int P = sc.nextInt();
		int cnt = 0;
		
		while(P < L){
			while(!pq.isEmpty()){
				Pair p = pq.poll();
				
				if(p.x <= P) tmp.offer(p.g);
				else{
					pq.offer(p);
					break;
				}
			}
			
			if(tmp.isEmpty()) break;
			
			++cnt;
			P += tmp.poll();
		}
		System.out.println(P >= L ? cnt : -1);
	}
}
class Pair implements Comparable<Pair>{
	int x, g;
	Pair(int x, int g){
		this.x = x;
		this.g = g;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.x > this.x) return -1;
		else return 1;
	}
}