import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[10001];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++){
			int num = sc.nextInt();
			int time = sc.nextInt();
			pq.offer(new Pair(num, time));
		}
		
		int sum = 0;
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			
			if(arr[p.time] == 0){
				arr[p.time] = p.num;
				sum += p.num;
			}
			else{
				for(int i = p.time - 1; i >= 1; i--)
					if(arr[i] == 0){
						arr[i] = p.num;
						sum += p.num;
						break;
					}
			}
		}
		
		System.out.println(sum);
	}
}
class Pair implements Comparable<Pair>{
	int num, time;
	Pair(int num, int time){
		this.num = num;
		this.time = time;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.num > this.num) return 1;
		else if(o.num == this.num){
			if(o.time > this.time) return 1;
			else if(o.time == this.time) return 0;
			else return -1;
		}
		else return -1;
	}
}