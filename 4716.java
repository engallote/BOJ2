import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	while(true) {
    		int N = sc.nextInt();
        	int A = sc.nextInt();
        	int B = sc.nextInt();
        	if(N == 0 && B == 0 && A == 0) break;
        	
        	PriorityQueue<Pair> pq = new PriorityQueue<>();
        	for(int i = 0; i < N; i++) {
        		long k = sc.nextLong();
        		long da = sc.nextLong();
        		long db = sc.nextLong();
        		pq.offer(new Pair(k, da, db));
        	}
        	
        	long res = 0;
        	while(!pq.isEmpty()) {
        		Pair p = pq.poll();
        		
        		if(p.a > p.b) {
        			if(B >= p.k) {
        				res += p.b * p.k;
        				B -= p.k;
        			}
        			else {
        				res += p.b * B;
        				res += p.a * (p.k - B);
        				A -= (p.k - B);
        				B = 0;
        			}
        		}
        		else {
        			if(A >= p.k) {
        				res += p.a * p.k;
        				A -= p.k;
        			}
        			else {
        				res += p.a * A;
        				res += p.b * (p.k - A);
        				B -= (p.k - A);
        				A = 0;
        			}
        		}
        	}
        	
        	System.out.println(res);
    	}
    }
    static class Pair implements Comparable<Pair>{
    	long k, a, b;
    	Pair(long k, long a, long b) {
    		this.k = k;
    		this.a = a;
    		this.b = b;
    	}
		@Override
		public int compareTo(Main.Pair o) {
			long a = Math.abs(this.a - this.b), b = Math.abs(o.a - o.b);
			if(a > b) return -1;
			else if(a == b) return 0;
			else return 1;
		}
    }
}