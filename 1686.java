import java.util.*;

public class Main {
	static int M, idx;
	static Pair[] arr;
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		M = sc.nextInt() * 60 * N;
		arr = new Pair[1001];
		chk = new boolean[1001];
		
		double sx = sc.nextDouble();
		double sy = sc.nextDouble();
		double ex = sc.nextDouble();
		double ey = sc.nextDouble();
		arr[0] = new Pair(ex, ey);
		sc.nextLine();
		idx = 1;
		
		while(sc.hasNextDouble()){
			String[] str = sc.nextLine().split(" ");
			double x = Double.parseDouble(str[0]);
			double y = Double.parseDouble(str[1]);
			arr[idx] = new Pair(x, y);
			++idx;
		}
		
		solve(sx, sy, ex, ey);
	}
	private static void solve(double sx, double sy, double ex, double ey) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(sx, sy, 0));
		
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			
			if(p.x == ex && p.y == ey){
				System.out.println("Yes, visiting " + (p.cnt - 1) + " other holes.");
				return;
			}
			
			for(int i = 0; i < idx; i++){
				double x = arr[i].x, y = arr[i].y;
				double cost = Math.sqrt(Math.pow(Math.abs(p.x - x), 2.0) + Math.pow(Math.abs(p.y - y), 2.0));
				
				if(cost <= M && !chk[i]){
					chk[i] = true;
					pq.offer(new Pair(x, y, p.cnt + 1));
				}
			}
		}
		
		System.out.println("No.");
	}
}
class Pair implements Comparable<Pair>{
	double x, y;
	int cnt;
	Pair(double x, double y){
		this.x = x;
		this.y = y;
	}
	Pair(double x, double y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : (o.cnt == this.cnt ? 0 : 1);
	}
}