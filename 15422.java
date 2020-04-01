import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//city
		int M = sc.nextInt();//road
		int F = sc.nextInt();//flight
		int S = sc.nextInt();//start
		int T = sc.nextInt();//end
		long[] chk = new long[N];
		ArrayList<Pair>[] arr = new ArrayList[N];
		Arrays.fill(chk, Long.MAX_VALUE);
		for(int i = 0; i < N; i++)
			arr[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			arr[a].add(new Pair(b, 0, c));
			arr[b].add(new Pair(a, 0, c));
		}
		
		for(int i = 0; i < F; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a].add(new Pair(b, 1, 0));
		}
		
		Queue<Pair> q = new LinkedList<Pair>();
		chk[S] = 0;
		q.offer(new Pair(S, 1, 0));
		int size = 0;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				if(p.v == T) continue;
				
				for(Pair next : arr[p.v]){
					if(next.k == 0){//not flight
						if(chk[next.v] > p.c + next.c){
							chk[next.v] = p.c + next.c;
							q.offer(new Pair(next.v, p.k, chk[next.v]));
						}
					}
					else{//flight
						if(p.k == 1 && chk[next.v] > p.c){//have op
							chk[next.v] = p.c;
							q.offer(new Pair(next.v, 0, chk[next.v]));
						}
					}
				}
			}
		}
		
		System.out.println(chk[T]);
	}
}
class Pair{
	int v, k;
	long c;
	Pair(int v, int k, long c){
		this.v = v;
		this.k = k;
		this.c = c;
	}
}