import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int i = 0; i < N; i++)
        	pq.offer(new Pair(sc.nextInt(), sc.nextInt()));
        
        int x = pq.peek().x, y = pq.peek().y, px = x;
        pq.poll();
        while(!pq.isEmpty()){
        	Pair p = pq.poll();
        	
        	if(p.x >= x || (p.x < x && p.y >= x)) continue;
        	else if(p.y < x){
        		if(px < p.y) continue;
        		else px = p.y;
        	}
        }
        
        System.out.println(x-px);
    }
}
class Pair implements Comparable<Pair>{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.x > this.x) return 1;
		else if(o.x == this.x) return o.y > this.y ? 1 : -1;
		else return -1;
	}
}