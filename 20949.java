import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			double W = sc.nextDouble();
			double H = sc.nextDouble();
			
			pq.offer(new Pair(i + 1, Math.sqrt((W * W) + (H * H)) / 77.0));
		}
		
		while(!pq.isEmpty())
			System.out.println(pq.poll().idx);
	}
}
class Pair implements Comparable<Pair>{
	int idx;
	double num;
	Pair(int idx, double num){
		this.idx = idx;
		this.num = num;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.num > this.num) return 1;
		else if(o.num == this.num) return this.idx > o.idx ? 1 : -1;
		else return -1;
	}
}