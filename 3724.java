import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	
    	while(--T >= 0) {
    		int M = sc.nextInt();
    		int N = sc.nextInt();
    		BigInteger[] arr = new BigInteger[M];
    		
    		for(int i = 0; i < M; i++)
    			arr[i] = BigInteger.ONE;
    		
    		PriorityQueue<Pair> pq = new PriorityQueue<>();
    		
    		for(int i = 0; i < N; i++) {
    			for(int j = 0; j < M; j++) {
    				arr[j] = arr[j].multiply(new BigInteger(sc.next()));
    				if(i == N - 1) pq.offer(new Pair(j + 1, arr[j]));
    			}
    		}
    		
    		System.out.println(pq.poll().idx);
    	}
	}
}
class Pair implements Comparable<Pair> {
	int idx;
	BigInteger sum;
	Pair(int idx, BigInteger sum) {
		this.idx = idx;
		this.sum = sum;
	}
	@Override
	public int compareTo(Pair o) {
		if(this.sum.compareTo(o.sum) > 0) return -1;
		else if(this.sum.compareTo(o.sum) == 0) return Integer.compare(o.idx, this.idx);
		else return 0;
	}
}