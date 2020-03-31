import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//정점
		int M = sc.nextInt();//간선
		int c = sc.nextInt();//백준 수도
		int v = sc.nextInt();//큐브 수도
		ArrayList<Pair>[] arr = new ArrayList[N];
		int[] chk = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = new ArrayList<>();
		Arrays.fill(chk, -1);
		
		for(int i = 0; i < M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int width = sc.nextInt();
			arr[a].add(new Pair(b, width));
			arr[b].add(new Pair(a, width));
		}
		
		chk[c] = 10000000;
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(c, 10000000));
		int size = 0, res = 0;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				if(p.v == v){
					res = Math.max(res, p.c);
					continue;
				}
				
				for(Pair next : arr[p.v])
					if(chk[next.v] < Math.min(p.c, next.c)){
						chk[next.v] = Math.min(p.c, next.c);
						q.offer(new Pair(next.v, chk[next.v]));
					}
			}
		}
		
		System.out.println(res);
	}
}
class Pair{
	int v, c;
	Pair(int v, int c){
		this.v = v;
		this.c = c;
	}
}