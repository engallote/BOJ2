import java.util.*;

public class Main {
	static int N;
	static ArrayList<Pair>[] arr;
	static int[] level, work;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		level = new int[123];
		work = new int[123];
		arr = new ArrayList[123];
		
		for(int i = 60; i <= 122; i++)
			arr[i] = new ArrayList<>();
		
		for(int i = 0; i < N; i++){
			char a = sc.next().charAt(0);
			char b = sc.next().charAt(0);
			int c = sc.nextInt();
			
			arr[a].add(new Pair((int) b, c, arr[b].size()));
			arr[b].add(new Pair((int) a, c, arr[a].size()-1));
		}
		
		int res = 0;
		while(bfs()){
			Arrays.fill(work, 0);
			int tmp = dfs((int)'A', 1000000000);
			if(tmp == 0) break;
			res += tmp;
		}
		
		System.out.println(res);
	}
	private static int dfs(int idx, int cap) {
		if(idx == (int)'Z') return cap;
		
		for(int i = work[idx]; i < arr[idx].size(); i++){
			Pair next = arr[idx].get(i);
			
			if(level[idx] + 1 == level[next.v] && next.cap > 0){
				int flow = dfs(next.v, Math.min(next.cap, cap));
				if(flow > 0){
					arr[idx].get(i).cap -= flow;
					arr[next.v].get(next.rev).cap += flow;
					return flow;
				}
			}
		}
		
		return 0;
	}
	private static boolean bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer((int)'A');
		Arrays.fill(level, -1);
		level['A'] = 0;
		
		while(!q.isEmpty()){
			int v = q.poll();
			
			for(Pair next : arr[v]){
				if(level[next.v] == -1 && next.cap > 0){
					level[next.v] = level[v] + 1;
					q.offer(next.v);
				}
			}
		}
		return level['Z'] == -1 ? false : true;
	}
}
class Pair{
	int v, cap, rev;
	Pair(int v, int cap, int rev){
		this.v = v;
		this.cap = cap;
		this.rev = rev;
	}
}