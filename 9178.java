import java.util.*;

public class Main {
	static int N, max, s, e;
	static ArrayList<Pair>[] aly;
	static ArrayList<String> res;
	static boolean[] chk;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int tc = 1;
    	while(true) {
    		N = sc.nextInt();
    		if(N == -1) break;
    		int M = sc.nextInt();
    		aly = new ArrayList[N + 1];
    		chk = new boolean[N + 1];
    		res = new ArrayList<>();
    		
    		for(int i = 1; i <= N; i++) aly[i] = new ArrayList<>();
    		
    		for(int i = 0; i < M; i++) {
    			int a = sc.nextInt();
    			int b = sc.nextInt();
    			int c = sc.nextInt();
    			aly[a].add(new Pair(b, c));
    			aly[b].add(new Pair(a, c));
    		}
    		
    		s = sc.nextInt();
    		e = sc.nextInt();
    		max = sc.nextInt();
    		ArrayList<Integer> path = new ArrayList<>();
    		chk[s] = true;
    		
    		for(int d = 1; d <= max; d++) {
    			dfs(s, 0, d, path);
    		}
    		
    		System.out.println("Case " + tc + ":");
    		if(res.isEmpty()) System.out.println(" NO ACCEPTABLE TOURS");
    		else for(String s : res) System.out.println(s);
    		System.out.println();
    		
    		tc += 1;
    	}
	}
	private static void dfs(int idx, int curD, int d, ArrayList<Integer> path) {
		if(curD == d) {
			if(idx != e) return;
			StringBuilder sb = new StringBuilder();
			sb.append(" " + d + ": " + s + " ");
			
			for(int num : path) sb.append(num + " ");
			res.add(sb.toString());
			return;
		}
		if(idx == e) return;
		
		for(Pair next : aly[idx])
			if(!chk[next.v] && curD + next.cost <= d) {
				chk[next.v] = true;
				path.add(next.v);
				dfs(next.v, curD + next.cost, d, path);
				chk[next.v] = false;
				path.remove(path.size() - 1);
			}
	}
}
class Pair {
	int v, cost;
	Pair(int v, int cost) {
		this.v = v;
		this.cost = cost;
	}
}