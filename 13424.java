import java.util.*;

public class Main {
	static int N, M;
	static ArrayList<Pair>[] arr;
	static int[][] chk;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(--T >= 0){
        	N = sc.nextInt();
        	M = sc.nextInt();
        	arr = new ArrayList[N+1];
        	chk = new int[N+1][N+1];
        	
        	for(int i = 1; i <= N; i++){
        		arr[i] = new ArrayList<>();
        		Arrays.fill(chk[i], Integer.MAX_VALUE);
        	}
        	
        	for(int i = 0; i < M; i++){
        		int a = sc.nextInt();
        		int b = sc.nextInt();
        		int c = sc.nextInt();
        		arr[a].add(new Pair(b, c));
        		arr[b].add(new Pair(a, c));
        	}
        	
        	int K = sc.nextInt();
        	for(int i = 1; i <= K; i++){
        		int num = sc.nextInt();
        		bfs(i, num);
        	}
        	
        	int res = Integer.MAX_VALUE, idx = 0;
        	for(int i = 1; i <= N; i++){
        		int sum = 0;
        		for(int j = 1; j <= K; j++){
        			if(chk[j][i] == Integer.MAX_VALUE){
        				sum = Integer.MAX_VALUE;
        				break;
        			}
        			sum += chk[j][i];
        		}
        			
        		if(res > sum){
        			res = sum;
        			idx = i;
        		}
        	}
        	
        	System.out.println(idx);
        }
    }
	private static void bfs(int idx, int start) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(start, 0));
		chk[idx][start] = 0;
		int size;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				for(Pair next : arr[p.v])
					if(chk[idx][next.v] > p.cost + next.cost){
						chk[idx][next.v] = p.cost + next.cost;
						q.offer(new Pair(next.v, chk[idx][next.v]));
					}
			}
		}
		
	}
}
class Pair{
	int v, cost;
	Pair(int v, int cost){
		this.v = v;
		this.cost = cost;
	}
}