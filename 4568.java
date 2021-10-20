import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int tc = 1;
    	while(true) {
    		int N = sc.nextInt();
    		if(N == 0) break;
    		System.out.println("Simulation " + tc);
    		char[] ch = sc.next().toCharArray();
    		PriorityQueue<Pair> pq = new PriorityQueue<>();
    		HashSet<Character> hs = new HashSet<>();
    		char[] arr = new char[N];
    		
    		int idx = 0, time = 0;
    		for(char c : ch) {
    			++time;
    			if(c == '!') {//print
    				PriorityQueue<Pair> tmp = new PriorityQueue<>();
    				while(!pq.isEmpty()) {
    					Pair p = pq.poll();
    					System.out.print(p.ch + "");
    					tmp.offer(p);
    				}
    				System.out.println();
    				pq.addAll(tmp);
    				continue;
    			}
    			
    			if(idx < N) {
    				if(hs.contains(c)) {
    					PriorityQueue<Pair> tmp = new PriorityQueue<>();
    					while(!pq.isEmpty()) {
    						Pair p = pq.poll();
    						
    						if(p.ch == c) tmp.offer(new Pair(c, p.idx, time));
    						else tmp.offer(p);
    					}
    					
    					pq.addAll(tmp);
    					continue;
    				}
    				arr[idx] = c;
    				hs.add(c);
    				pq.offer(new Pair(c, idx, time));
    				idx += 1;
    			}
    			else {
    				if(hs.contains(c)) {
    					PriorityQueue<Pair> tmp = new PriorityQueue<>();
    					while(!pq.isEmpty()) {
    						Pair p = pq.poll();
    						
    						if(p.ch == c) tmp.offer(new Pair(c, p.idx, time));
    						else tmp.offer(p);
    					}
    					
    					pq.addAll(tmp);
    				}
    				else {
    					Pair p = pq.poll();
    					hs.remove(p.ch);
    					hs.add(c);
    					arr[p.idx] = c;
    					pq.offer(new Pair(c, p.idx, time));
    				}
    			}
    		}
    		
    		++tc;
    	}
	}
}
class Pair implements Comparable<Pair> {
	char ch;
	int idx, time;
	Pair(char ch, int idx, int time) {
		this.ch = ch;
		this.idx = idx;
		this.time = time;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.time, o.time);
	}
}