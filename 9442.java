import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 1;
        while(true){
        	int N = sc.nextInt();
        	if(N == 0) break;
            String order = sc.next();
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            
            for(int i = 0; i < N; i++)
            	pq.offer(new Pair(sc.next(), order));
            
            System.out.println("year " + tc);
            ++tc;
            while(!pq.isEmpty())
            	System.out.println(pq.poll().str);
        }
    }
}
class Pair implements Comparable<Pair>{
	String str, order;
	Pair(String str, String order){
		this.str = str;
		this.order = order;
	}
	@Override
	public int compareTo(Pair o) {
		char[] a = o.str.toCharArray(), b = this.str.toCharArray();
		
		for(int i = 0; i < Math.min(a.length, b.length); i++){
			if(o.order.indexOf(a[i]+"") < o.order.indexOf(b[i]+"")) return 1;
			else if(o.order.indexOf(a[i]+"") > o.order.indexOf(b[i]+"")) return -1;
		}
		
		if(a.length > b.length) return -1;
		else if(a.length == b.length) return 0;
		else return 1;
	}
}