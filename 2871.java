import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] arr = sc.next().toCharArray();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean[] chk = new boolean[N];
		
		for(int i = 0; i < N; i++) pq.offer(new Pair(i, arr[i]));
		int idx = N - 1;
		StringBuilder h = new StringBuilder(), s = new StringBuilder();
		
		while(!pq.isEmpty()){
			while(idx >= 0 && chk[idx]) --idx;
			if(idx < 0) break;
			s.append(arr[idx]);
			--idx;
			while(!pq.isEmpty() && pq.peek().idx > idx) pq.poll();
			if(pq.isEmpty()) break;
			h.append(pq.peek().c);
			chk[pq.poll().idx] = true;
		}
		
		PriorityQueue<String> sort = new PriorityQueue<>();
		sort.offer(h.toString());
		sort.offer(s.toString());
//		System.out.println(s.toString() + " " + h.toString());
		if(sort.peek().equals(h.toString()) && !sort.peek().equals(s.toString()))
			System.out.println("DA");
		else System.out.println("NE");
		System.out.println(h.toString());
	}
}
class Pair implements Comparable<Pair>{
	int idx;
	char c;
	Pair(int idx, char c){
		this.idx = idx;
		this.c = c;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.c > this.c) return -1;
		else if(o.c == this.c) return o.idx > this.idx ? 1 : -1;
		else return 1;
	}
}