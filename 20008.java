import java.util.*;

public class Main {
	static int N, H, res;
	static int[][] skill;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	H = sc.nextInt();
    	res = Integer.MAX_VALUE;
    	skill = new int[N][2];
    	
    	for(int i = 0; i < N; i++) {
    		int c = sc.nextInt();
    		int d = sc.nextInt();
    		skill[i][0] = c;
    		skill[i][1] = d;
    	}
    	
    	ArrayList<Integer> path = new ArrayList<>();
    	solve(0, 0, path);
    	
    	System.out.println(res);
	}
	private static void solve(int idx, int chk, ArrayList<Integer> path) {
		if(idx == N) {
			play(path);
			return;
		}
		
		for(int i = 0; i < N; i++)
			if((chk&(1<<i)) == 0) {
				path.add(i);
				solve(idx + 1, chk|(1<<i), path);
				path.remove(path.size() - 1);
			}
	}
	private static void play(ArrayList<Integer> path) {
		PriorityQueue<Pair> pq = new PriorityQueue<>(), wait = new PriorityQueue<>();
		for(int i = 0; i < path.size(); i++)
			pq.offer(new Pair(path.get(i), i, 0));
		
		int hp = H, time = 0;
		while(hp > 0) {
			Pair p = pq.peek();
			
			if(p.time == 0) {
				pq.poll();
				hp -= skill[p.idx][1];
				pq.offer(new Pair(p.idx, p.r, skill[p.idx][0]));
			}
			
			while(!pq.isEmpty()) {
				p = pq.poll();
				
				if(p.time - 1 >= 0) wait.offer(new Pair(p.idx, p.r, p.time - 1));
				else wait.offer(p);
			}
			
			if(!wait.isEmpty()) {
				pq.addAll(wait);
				wait.clear();
			}
			time += 1;
		}
		
		if(res > time) res = time;
	}
}
class Pair implements Comparable<Pair> {
	int idx, r, time;
	Pair(int idx, int r, int time) {
		this.idx = idx;
		this.r = r;
		this.time = time;
	}
	@Override
	public int compareTo(Pair o) {
		if(this.time < o.time) return -1;
		else if(this.time == o.time) return Integer.compare(this.r, o.r);
		else return 1;
	}
}