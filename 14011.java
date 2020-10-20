import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		PriorityQueue<Pair> pq = new PriorityQueue<>(), tmp = new PriorityQueue<>();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if(arr[i] >= num) continue;
			pq.offer(new Pair(arr[i], num));
		}
		
		boolean flag = true;
		while(flag) {
			flag = false;
			while(!pq.isEmpty()) {
				Pair p = pq.poll();
				
				if(M >= p.need) {
					M -= p.need;
					M += p.back;
					flag = true;
				}
				else tmp.offer(p);
			}
			pq.addAll(tmp);
			tmp.clear();
		}
		
		System.out.println(M);
	}
}
class Pair implements Comparable<Pair>{
	int need, back;
	Pair(int need, int back){
		this.need = need;
		this.back = back;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.need > this.need) return -1;
		else if(o.need == this.need) return o.back > this.back ? 1 : (o.back == this.back ? 0 : -1);
		else return 1;
	}
}