import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] chk = new boolean[N+1];
		int[] res = new int[N+1];
		ArrayList<Integer>[] arr = new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++){
			arr[i] = new ArrayList<>();
			res[i] = -1;
			
			while(true){
				int num = sc.nextInt();
				if(num == 0) break;
				
				arr[i].add(num);
			}
		}
		
		int M = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>(), tmp = new LinkedList<Integer>();
		
		for(int i = 0; i < M; i++){
			int num = sc.nextInt();
			q.offer(num);
			chk[num] = true;
			res[num] = 0;
		}
		
		int size = 0, time = 1;
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				int x = q.poll();
				
				for(int next : arr[x]){
					if(chk[next]) continue;
					int cnt = 0;
					for(int next2 : arr[next])
						if(chk[next2]) ++cnt;
					
					if((double)arr[next].size() / 2 <= cnt) tmp.offer(next);
				}
			}
			
			while(!tmp.isEmpty()){
				int x = tmp.poll();
				q.offer(x);
				chk[x] = true;
				res[x] = time;
			}
			++time;
		}
		
		for(int i = 1; i <= N; i++)
			System.out.print(res[i] + " ");
	}
}