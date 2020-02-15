import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int P = sc.nextInt();
        
        int[] chk = new int[V + 1];
        ArrayList<Pair>[] arr = new ArrayList[V + 1];
        
        Arrays.fill(chk, Integer.MAX_VALUE);
        for(int i = 1; i <= V; i++)
        	arr[i] = new ArrayList<>();
        
        for(int i = 0; i < E; i++){
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	int cost = sc.nextInt();
        	arr[a].add(new Pair(b, cost));
        	arr[b].add(new Pair(a, cost));
        }
        
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(1, 0, 0));
        chk[1] = 0;
        int size = 0, res = Integer.MAX_VALUE;
        boolean save = false;
        
        while(!q.isEmpty()){
        	size = q.size();
        	while(--size >= 0){
        		Pair p = q.poll();
        		int can = p.can;
        		if(p.v == P) can = 1;
        		
        		if(p.v == V){
        			if(res > p.cost){
        				res = p.cost;
        				save = p.can == 1 ?  true : false;
        			}
        			else if(res == p.cost && p.can == 1) save = true;
        			continue;
        		}
        		
        		for(Pair next : arr[p.v])
        			if(chk[next.v] >= p.cost + next.cost){
        				chk[next.v] = p.cost + next.cost;
        				if(next.v == P) q.offer(new Pair(next.v, p.cost + next.cost, 1));
        				else q.offer(new Pair(next.v, p.cost + next.cost, can));
        			}
        	}
        }
        
        if(save) System.out.println("SAVE HIM");
        else System.out.println("GOOD BYE");
    }
}
class Pair{
	int v, cost, can;
	Pair(int v, int cost){
		this.v = v;
		this.cost = cost;
	}
	Pair(int v, int cost, int can){
		this.v = v;
		this.cost = cost;
		this.can = can;
	}
}