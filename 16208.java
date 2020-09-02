import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long sum = 0;
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++){
			long num = sc.nextLong();
			pq.offer(num);
			sum += num;
		}
		
		long res = 0;
		
		while(pq.size() > 1){
			long x = pq.poll();
			
			res += x * (sum - x);
			sum -= x;
		}
		
		System.out.println(res);
	}
}