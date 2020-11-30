import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashMap<String, Integer> hs = new HashMap<>();
		PriorityQueue<String> pq = new PriorityQueue<>();
		
		while(--N >= 0) {
			String str = sc.next();
			int idx = str.indexOf('.');
			
			if(hs.containsKey(str.substring(idx + 1)))
				hs.replace(str.substring(idx + 1), hs.get(str.substring(idx + 1)) + 1);
			else {
				hs.put(str.substring(idx + 1), 1);
				pq.offer(str.substring(idx + 1));
			}
		}
		
		while(!pq.isEmpty())
			System.out.println(pq.peek() + " " + hs.get(pq.poll()));
	}
}