import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> s = new PriorityQueue<>(), e = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++){
			int idx = sc.nextInt();
			int start = sc.nextInt();
			int end = sc.nextInt();
			s.offer(start);
			e.offer(end);
		}
		
		int res = 0, sum = 0;
		while(!s.isEmpty() && !e.isEmpty()){
			int start = s.peek();
			int end = e.peek();
			
			if(start < end){
				++sum;
				res = Math.max(res, sum);
				s.poll();
			}
			else{
				e.poll();
				--sum;
			}
		}
		
		System.out.println(res);
	}
}