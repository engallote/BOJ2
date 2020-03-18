import java.util.*;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] arr;
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new ArrayList[N+1];
		chk = new boolean[N+1];
		
		for(int i = 1; i <= N; i++)
			arr[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a].add(b);
			arr[b].add(a);
		}
		
		int C = sc.nextInt();
		int H = sc.nextInt();
		int K = sc.nextInt();
		
		findEnemy(H);
		int res = hand(C);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 1; i <= N; i++)
			if(!chk[i]) pq.offer(hand(i));
			
		while(!pq.isEmpty() && --K >= 0) 
			res += pq.poll();
		
		System.out.println(res);
	}
	private static int hand(int idx) {
		Queue<Integer> q = new LinkedList<Integer>();
		int cnt = 0, size;
		chk[idx] = true;
		q.offer(idx);
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				int x = q.poll();
				++cnt;
				
				for(int next : arr[x])
					if(!chk[next]){
						chk[next] = true;
						q.offer(next);
					}
			}
		}
		return cnt;
	}
	private static void findEnemy(int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(s);
		chk[s] = true;
		while(!q.isEmpty()){
			int x = q.poll();
			
			for(int next : arr[x])
				if(!chk[next]){
					chk[next] = true;
					q.offer(next);
				}
		}
	}
}