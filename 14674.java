import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++){
			int idx = sc.nextInt();
			long a = sc.nextLong();
			long b = sc.nextLong();
			pq.offer(new Pair(idx, a, b));
		}
		
		while(--K >= 0)
			System.out.println(pq.poll().idx);
	}
}
class Pair implements Comparable<Pair>{
	int idx;
	long a, b;
	Pair(int idx, long a, long b){
		this.idx = idx;
		this.a = a;
		this.b = b;
	}
	@Override
	public int compareTo(Pair o) {
		BigInteger A = new BigInteger(String.valueOf(o.a)), B = new BigInteger(String.valueOf(this.a));
		A = A.multiply(new BigInteger(String.valueOf(this.b)));
		B = B.multiply(new BigInteger(String.valueOf(o.b)));
		if(A.compareTo(B) > 0) return -1;
		else if(A.compareTo(B) == 0){
			if(this.a > o.a) return 1;
			else if(this.a == o.a) return o.idx > this.idx ? -1 : 1;
			else return -1;
		}
		else return 1;
	}
}