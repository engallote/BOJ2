import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(--T >= 0){
			int N = sc.nextInt();
			ArrayList<Integer>[] arr = new ArrayList[N+1], rev = new ArrayList[N+1];
			
			for(int i = 1; i <= N; i++){
				arr[i] = new ArrayList<>();
				rev[i] = new ArrayList<>();
			}
			
			for(int i = 1; i < N; i++){
				int a = sc.nextInt();
				int b = sc.nextInt();
				arr[a].add(b);
				rev[b].add(a);
			}
			int A = sc.nextInt();
			int B = sc.nextInt();
			HashSet<Integer> hs = new HashSet<>();
			boolean[] chk = new boolean[N+1];
			Queue<Integer> q = new LinkedList<Integer>();
			q.offer(A);
			chk[A] = true;
			
			while(!q.isEmpty()){
				int x = q.poll();
				hs.add(x);
				for(int next : rev[x])
					if(!chk[next]) {
						chk[next] = true;
						q.offer(next);
					}
			}
			
			q.clear();
			q.offer(B);
			Arrays.fill(chk, false);
			chk[B] = true;
			
			while(!q.isEmpty()){
				int x = q.poll();
				
				if(hs.contains(x)){
					System.out.println(x);
					break;
				}
				for(int next : rev[x])
					if(!chk[next]) {
						chk[next] = true;
						q.offer(next);
					}
			}
			
		}
	}
}