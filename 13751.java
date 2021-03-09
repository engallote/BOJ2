import java.util.*;

public class Main {
	static int b, p;
	static long[] bar, plate;
	static HashSet<Long> hs = new HashSet<>();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        b = sc.nextInt();
        p = sc.nextInt();
        bar = new long[b];
        plate = new long[p];
        HashSet<Long> res = new HashSet<>();
        
        for(int i = 0; i < b; i++) {
        	bar[i] = sc.nextLong();
        	res.add(bar[i]);
        }
        
        for(int i = 0; i < p; i++)
        	plate[i] = sc.nextLong();
        
        solve(0, 0, 0);
        
        Iterator<Long> it = hs.iterator();
        
        while(it.hasNext()) {
        	long key = it.next() * 2;
        	
        	for(int i = 0; i < b; i++)
        		res.add(bar[i] + key);
        }
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        it = res.iterator();
        while(it.hasNext())
        	pq.offer(it.next());
        
        while(!pq.isEmpty())
        	System.out.println(pq.poll());
    }
	private static void solve(int idx, long sum1, long sum2) {
		if(sum1 == sum2) hs.add(sum1);
		if(idx == p) return;
		
		solve(idx + 1, sum1, sum2);
		solve(idx + 1, sum1 + plate[idx], sum2);
		solve(idx + 1, sum1, sum2 + plate[idx]);
	}
}