import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean[] arr = new boolean[10001];
		int res = 0;
		
		for(int i = 0; i < N; i++)
			pq.offer(new Pair(sc.nextInt(), sc.nextInt()));
		
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			
			if(arr[p.time]){
				for(int i = p.time; i >= 1; i--){
					if(arr[i]) continue;
					arr[i] = true;
					res += p.cost;
					break;
				}
			}
			else{
				arr[p.time] = true;
				res += p.cost;
			}
		}
		
		System.out.println(res);
	}
}
class Pair implements Comparable<Pair>{
	int time, cost;
	Pair(int cost, int time){
		this.cost = cost;
		this.time = time;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.cost > this.cost) return 1;
		else if(o.cost == this.cost) return o.time > this.time ? -1 : (o.time == this.time ? 0 : 1);
		else return -1;
	}
}