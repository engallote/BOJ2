import java.util.*;

public class Main {
	static int N;
	static int[] par;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			N = sc.nextInt();
			
			if(N == 0) break;
			
			par = new int[N];
			
			for(int i = 0; i < N; i++)
				par[i] = i;
			
			ArrayList<Pair> arr = new ArrayList<>();
			
			for(int i = 1; i < N; i++){
				char c = sc.next().charAt(0);
				int num = sc.nextInt();
				
				for(int j = 0; j < num; j++){
					char v = sc.next().charAt(0);
					int cost = sc.nextInt();
					arr.add(new Pair(c - 'A', v - 'A', cost));
				}
			}
			
			Collections.sort(arr);
			int res = 0;
			
			for(int i = 0; i < arr.size(); i++){
				Pair p = arr.get(i);
				int a = find(p.a), b = find(p.b);
				
				if(a == b) continue;
				
				par[b] = a;
				res += p.c;
			}
			
			System.out.println(res);
		}
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}
class Pair implements Comparable<Pair>{
	int a, b, c;
	Pair(int a, int b, int c){
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