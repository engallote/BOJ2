import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++){
			arr[i] = sc.nextInt();
			pq.offer(new Pair(i, arr[i]));
		}
		
		int sum = 0, idx = 0;;
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			
			if(arr[p.idx] == -1) continue;
			
			for(int i = p.idx - 1; i >= idx; i--)
				if(arr[i] != -1){
					sum += p.num - arr[i];
					arr[i] = -1;
				}
			
			idx = p.idx + 1;
		}
		
		System.out.println(sum);
	}
}
class Pair implements Comparable<Pair>{
	int idx, num;
	Pair(int idx, int num){
		this.idx = idx;
		this.num = num;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.num > this.num) return 1;
		else if(o.num == this.num) return 0;
		else return -1;
	}
}