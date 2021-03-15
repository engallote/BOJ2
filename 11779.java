import java.util.*;

public class Main {
	static int N;
	static ArrayList<Pair>[] arr;
	static int[] chk, ans;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int K = sc.nextInt();
        chk = new int[N + 1];
        ans = new int[N + 1];
        arr = new ArrayList[N + 1];
        
        for(int i = 1; i <= N; i++) {
        	arr[i] = new ArrayList<>();
        	chk[i] = Integer.MAX_VALUE;
        	ans[i] = -1;
        }
        
        for(int i = 0; i < K; i++) {
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	int c = sc.nextInt();
        	arr[a].add(new Pair(b, c));
        }
        
        int s = sc.nextInt();
        int e = sc.nextInt();
        
        if(s == e) {
        	System.out.println(0);
        	System.out.println(1);
        	System.out.println(s + " " + e);
        	return;
        }
        bfs(s, e);
    }
	private static void bfs(int s, int e) {
		PriorityQueue<Pair> q = new PriorityQueue<>();
		q.offer(new Pair(s, 0));
		chk[s] = 0;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			if(chk[p.v] < p.cost) continue;
			
			for(Pair next : arr[p.v])
				if(chk[next.v] > next.cost + p.cost) {
					chk[next.v] = next.cost + p.cost;
					ans[next.v] = p.v;
					q.offer(new Pair(next.v, chk[next.v]));
				}
		}
		
		System.out.println(chk[e]);
		int size = 1, idx = e;
		Stack<Integer> st = new Stack<>();
		st.push(idx);
		while(ans[idx] != -1) {
			st.push(ans[idx]);
			idx = ans[idx];
			++size;
		}
		System.out.println(size);
		
		while(!st.isEmpty())
			System.out.print(st.pop() + " ");
	}
}
class Pair implements Comparable<Pair>{
	int v, cost;
	Pair(int  v, int cost){
		this.v = v;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.cost, o.cost);
	}
}