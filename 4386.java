import java.util.*;

public class Main {
	static int N;
	static int[] par;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		par = new int[N + 1];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		ArrayList<Pair> arr = new ArrayList<>();

		double res = 0;
		for(int i = 0; i < N; i++){
			par[i] = i;
			double a = sc.nextDouble();
			double b = sc.nextDouble();
			arr.add(new Pair(a, b));
		}
		
		for(int i = 0; i < arr.size(); i++)
			for(int j = i + 1; j < arr.size(); j++){
				double dist = Math.sqrt(Math.pow(Math.abs(arr.get(i).a - arr.get(j).a), 2) + Math.pow(Math.abs(arr.get(i).b - arr.get(j).b), 2));
				pq.offer(new Pair(i, j, dist));
			}
		
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			int a = find((int)p.a), b = find((int)p.b);
			
			if(a == b) continue;
			par[b] = a;
			res += p.c;
		}
		
		System.out.printf("%.2f\n",res);
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}
class Pair implements Comparable<Pair>{
	double a, b, c;
	Pair(double a, double b){
		this.a = a;
		this.b = b;
	}
	Pair(double a, double b, double c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.c > this.c) return -1;
		else if(o.c == this.c) return 0;
		else return 1;
	}
}