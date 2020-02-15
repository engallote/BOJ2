import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        
        if(A == 1 || B == 1){
        	System.out.println(T);
        	return;
        }
        HashSet<Integer> hs = new HashSet<>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(0, 1));
        int size = 0, res = 0;
        
        while(!q.isEmpty()){
        	size = q.size();
        	while(--size >= 0){
        		Pair p = q.poll();
        		
        		res = Math.max(res, p.x);
        		
        		if(p.x + A <= T && !hs.contains(p.x + A)){
        			hs.add(p.x + A);
        			q.offer(new Pair(p.x + A, p.k));
        		}
        		if(p.x + B <= T && !hs.contains(p.x + B)){
        			hs.add(p.x + B);
        			q.offer(new Pair(p.x + B, p.k));
        		}
        		if(p.k == 1 && !hs.contains(p.x / 2)){
        			hs.add(p.x / 2);
        			q.offer(new Pair(p.x / 2, 0));
        		}
        	}
        }
        
        System.out.println(res);
    }
}
class Pair{
	int x, k;
	Pair(int x, int k){
		this.x = x;
		this.k = k;
	}
}