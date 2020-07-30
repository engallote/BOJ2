import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int Q = sc.nextInt();
		int K = sc.nextInt();
		int[] chk = new int[N+1];
		ArrayList<Integer>[] arr = new ArrayList[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i = 1; i <= N; i++){
			chk[i] = Integer.MAX_VALUE;
			arr[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < Q; i++){
			int num = sc.nextInt();
			chk[num] = 0;
			q.offer(num);
		}
		
		for(int i = 0; i < M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a].add(b);
			arr[b].add(a);
		}
		
		int size, cnt = 0, time = 1;
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				int x = q.poll();
				
				for(int next : arr[x])
					if(chk[next] > time){
						chk[next] = time;
						q.offer(next);
					}
			}
			
			++cnt;
			if(cnt == K * time){
				cnt = 0;
				++time;
			}
		}
		
		for(int i = 1; i <= N; i++)
			System.out.print(chk[i] + " ");
	}
}