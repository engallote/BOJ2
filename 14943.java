import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Pair> sup = new PriorityQueue<>(), ned = new PriorityQueue<>();
		for(int i = 0; i < N; i++){
			long num = sc.nextLong();
			if(num < 0) ned.offer(new Pair(i, -num));
			else sup.offer(new Pair(i, num));
		}
		
		long res = 0;
		
		while(!ned.isEmpty()){
			Pair p = ned.poll();
			
			while(p.x > 0){
				Pair s = sup.poll();
				
				if(p.x > s.x){
					p.x -= s.x;
					res += s.x * Math.abs(p.idx - s.idx);
				}
				else{
					if(p.x < s.x)
						sup.offer(new Pair(s.idx, s.x - p.x));
					res += p.x * (Math.abs(p.idx - s.idx));
					p.x = 0;
				}
			}
		}
		
		System.out.println(res);
	}
}
class Pair implements Comparable<Pair>{
	long x;
	int idx;
	Pair(int idx, long x){
		this.idx = idx;
		this.x = x;
	}
	@Override
	public int compareTo(Pair o) {
		return o.idx > this.idx ? -1 : 1;
	}
}