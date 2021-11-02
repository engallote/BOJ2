import java.util.*;

public class Main {
	static char[] ch;
	static ArrayList<Integer> l, r;
	static boolean[] chk;
	static PriorityQueue<String> pq;
	static HashSet<String> hs;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	ch = sc.next().toCharArray();
    	l = new ArrayList<>();
    	r = new ArrayList<>();
    	chk = new boolean[ch.length];
    	hs = new HashSet<>();
    	pq = new PriorityQueue<>();
    	Stack<Integer> st = new Stack<>();
    	
    	for(int i = 0; i < ch.length; i++) {
    		if(ch[i] == '(') st.push(i);
    		else if(ch[i] == ')') {
    			l.add(st.pop());
    			r.add(i);
    		}
    	}
    	
    	hs.add(new String(ch));
    	solve(0);
    	
    	while(!pq.isEmpty()) System.out.println(pq.poll());
	}
	private static void solve(int idx) {
		if(idx == l.size()) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < ch.length; i++)
				if(!chk[i]) sb.append(ch[i]);
			
			if(!hs.contains(sb.toString())) {
				hs.add(sb.toString());
				pq.offer(sb.toString());
			}
			return;
		}
		
		solve(idx + 1);
		chk[l.get(idx)] = chk[r.get(idx)] = true;
		solve(idx + 1);
		chk[l.get(idx)] = chk[r.get(idx)] = false;
	}
}