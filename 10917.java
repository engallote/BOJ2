import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<Integer>[] arr = new ArrayList[N+1];
		boolean[] chk = new boolean[N+1];
		
		for(int i = 1; i <= N; i++) arr[i] = new ArrayList<>();
		for(int i = 0; i < M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a].add(b);
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		chk[1] = true;
		int size = 0, time = 0;
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				int x = q.poll();
				
				if(x == N){
					System.out.println(time);
					return;
				}
				for(int next:arr[x])
					if(!chk[next]) {
						chk[next] = true;
						q.offer(next);
					}
			}
			++time;
		}
		
		System.out.println(-1);
	}
}