import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	Queue<Pair> q = new LinkedList<>();
    	Stack<Pair> st = new Stack<>();
    	PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    	for(int i = 0; i < N; i++) {
    		int p = sc.nextInt();
    		int w = sc.nextInt();
    		q.offer(new Pair(p, w));
    		pq.offer(p);
    	}
    	
    	int sum = 0;
    	
    	while(!q.isEmpty()) {
    		Pair p = q.poll();
    		if(pq.peek() != p.p) {
    			q.offer(p);
//    			System.out.println(p.p + " " + p.w + " 레일 끝으로");
    			sum += p.w;
    			continue;
    		}
    		
    		if(st.isEmpty() || (st.peek().p >= p.p && st.peek().w >= p.w)) {
    			st.push(p);
//    			System.out.println(p.p + " " + p.w + " 적재");
    			sum += p.w;
    		}
    		else {
    			Stack<Pair> tmp = new Stack<>();
    			int weight = 0;
    			while(!st.isEmpty()) {
    				Pair p2 = st.peek();
    				if(p2.p != p.p || p2.w >= p.w) break;
    				tmp.push(st.pop());
//    				System.out.println(tmp.peek().p + " " + tmp.peek().w + " 들어올리기");
    				weight += p2.w;
    			}
    			
    			st.push(p);
//    			System.out.println(p.p + " " + p.w + " 적재");
    			
    			while(!tmp.isEmpty()) {
//    				System.out.println(tmp.peek().p + " " + tmp.peek().w + " 다시 적재");
    				st.push(tmp.pop());
    			}
    			sum += weight * 2 + p.w;
    		}
    		pq.poll();
    	}
    	
    	System.out.println(sum);
	}
}
class Pair {
	int p, w;
	Pair(int p, int w) {
		this.p = p;
		this.w = w;
	}
}