import java.util.*;

public class Main {
	static int N, S, P;
	static ArrayList<Integer>[] arr;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);    	
    	N = sc.nextInt();
    	S = sc.nextInt();
    	P = sc.nextInt();
    	arr = new ArrayList[N + 1];
    	
    	for(int i = 1; i <= N; i++)
    		arr[i] = new ArrayList<>();
    	
    	for(int i = 1; i < N; i++) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		arr[a].add(b);
    		arr[b].add(a);
    	}
    	
    	int[] chk = new int[N + 1];
    	Arrays.fill(chk, Integer.MAX_VALUE);
    	chk[P] = 0;
    	
    	Queue<Integer> q = new LinkedList<>();
    	q.offer(P);
    	int size;
    	while(!q.isEmpty()) {
    		size = q.size();
    		while(--size >= 0) {
    			int x = q.poll();
    			
    			for(int next : arr[x])
    				if(chk[next] > chk[x] + 1) {
    					chk[next] = chk[x] + 1;
    					q.offer(next);
    				}
    		}
    	}
    	
    	PriorityQueue<Pair> pq = new PriorityQueue<>();
    	for(int i = 1; i <= S; i++)
    		pq.offer(new Pair(i, chk[i]));
    	
    	int res = 0;
    	for(int i = 0; i < 2; i++)
    		res += pq.poll().cnt;
    	
    	System.out.println(N - (res + 1));
	}
}
class Pair implements Comparable<Pair> {
	int idx, cnt;
	Pair(int idx, int cnt) {
		this.idx = idx;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.cnt, o.cnt);
	}
}