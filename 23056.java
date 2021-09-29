import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	PriorityQueue<Pair> pq = new PriorityQueue<>();
    	int[] cnt = new int[N + 1];
    	
    	while(true) {
    		int num = sc.nextInt();
    		String str = sc.next();
    		
    		if(num == 0 && str.equals("0")) break;
    		if(cnt[num] == M) continue;
    		cnt[num] += 1;
    		pq.offer(new Pair(num, str));
    	}
    	
    	while(!pq.isEmpty()) {
    		Pair p = pq.poll();
    		System.out.println(p.idx + " " + p.name);
    	}
	}
}
class Pair implements Comparable<Pair> {
	int idx;
	String name;
	Pair(int idx, String name) {
		this.idx = idx;
		this.name = name;
	}
	@Override
	public int compareTo(Pair o) {
		int a = this.idx % 2, b = o.idx % 2;
		if(a > b) return -1;
		else if(a == b) {
			if(this.idx > o.idx) return 1;
			else if(this.idx < o.idx) return -1;
			else {
				if(o.name.length() < this.name.length()) return 1;
				else if(o.name.length() > this.name.length()) return -1;
				
				int len = o.name.length();
				for(int i = 0; i < len; i++) {
					if(o.name.charAt(i) < this.name.charAt(i)) return 1;
					else if(o.name.charAt(i) > this.name.charAt(i)) return -1;
				}
				
				return 0;
			}
		}
		else return 1;
	}
	
}