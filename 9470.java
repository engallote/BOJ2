import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(--T >= 0){
			int K = sc.nextInt();//테케 번호
			int M = sc.nextInt();//노드 수
			int P = sc.nextInt();//간선 수
			int[] indgree = new int[M + 1], chk = new int[M + 1];
			ArrayList<Integer>[] arr = new ArrayList[M+1], rev = new ArrayList[M+1];
			
			for(int i = 1; i <= M; i++){
				arr[i] = new ArrayList<>();
				rev[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < P; i++){
				int a = sc.nextInt();
				int b = sc.nextInt();
				arr[b].add(a);
				rev[a].add(b);
				++indgree[b];
			}
			
			Queue<Integer> q = new LinkedList<Integer>();
			for(int i = 1; i <= M; i++)
				if(indgree[i] == 0){//root
					q.offer(i);
					chk[i] = 1;
				}
			
			int size = 0;
			boolean flag = true;
			while(!q.isEmpty() && flag){
				size = q.size();
				while(--size >= 0){
					int x = q.poll();
					
					if(!arr[x].isEmpty()){
						int max = -1, cnt = 1;
						for(int next : arr[x]){
							if(max < chk[next]){
								max = chk[next];
								cnt = 1;
							}
							else if(max == chk[next]) ++cnt;
						}
						if(chk[x] != max) flag = true;
						if(cnt == 1) chk[x] = max;
						else chk[x] = max + 1;
					}
					for(int next : rev[x])
						q.offer(next);
				}
			}
			
			int res = 0;
			for(int i = 1; i <= M; i++)
				res = Math.max(res, chk[i]);
			
			System.out.println(K + " " + res);
			
		}
	}
}