import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long x = sc.nextLong();
		long y = sc.nextLong();
		HashSet<String> hs = new HashSet<>();
		hs.add("0, 0");
		long res = 1;
		int size;
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(0, 0));
		
		while(!q.isEmpty()){
			size = q.size();
			
			while(--size >= 0){
				Pair p = q.poll();
				
				if(p.x == x && p.y == y){
					System.out.println("1");
					return;
				}
				
				if(p.x + res <= x && !hs.contains((p.x + res) + ", " + p.y)){
					hs.add((p.x + res) + ", " + p.y);
					q.offer(new Pair(p.x + res, p.y));
				}
				if(p.y + res <= y && !hs.contains(p.x + ", " + (p.y + res))){
					hs.add(p.x + ", " + (p.y + res));
					q.offer(new Pair(p.x, p.y + res));
				}
			}
			
			res *= 3;
		}
		
		System.out.println("0");
	}
}
class Pair{
	long x, y;
	Pair(long x, long y){
		this.x = x;
		this.y = y;
	}
}