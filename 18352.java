import java.util.*;

public class Main {
	static int N, M, K, X;
	static ArrayList<Integer>[] arr;
	static int[] chk;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();
        arr = new ArrayList[N+1];
        chk = new int[N+1];
        
        for(int i = 1; i <= N; i++){
        	arr[i] = new ArrayList<>();
        	chk[i] = Integer.MAX_VALUE;
        	if(i == X) chk[i] = 0;
        }
        
        for(int i = 0; i < M; i++){
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	arr[a].add(b);
        }
        
        bfs();
        
        boolean flag = false;
        for(int i = 1; i <= N; i++)
        	if(chk[i] == K){
        		flag = true;
        		System.out.println(i);
        	}
        
        if(!flag) System.out.println(-1);
	}
	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(X);
		int size;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				int x = q.poll();
				
				for(int next : arr[x])
					if(chk[next] > chk[x] + 1){
						chk[next] = chk[x] + 1;
						q.offer(next);
					}
			}
		}
	}
}