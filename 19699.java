import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	static boolean[] visit;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        visit = new boolean[10000];
        visit[0] = visit[1] = true;
        
        for(int i = 2; i < 10000; i++)
        	if(!visit[i])
        		for(int j = i + i; j < 10000; j+=i) visit[j] = true;
        
        for(int i = 0; i < N; i++)
        	arr[i] = sc.nextInt();
        
        dfs(0, 0, 0);
        
        if(pq.isEmpty()){
        	System.out.println(-1);
        	return;
        }
        
        while(!pq.isEmpty())
        	System.out.print(pq.poll() + " ");
    }
	private static void dfs(int cnt, int chk, int sum) {
		if(cnt == M){
			if(visit[sum] || pq.contains(sum)) return;
			pq.offer(sum);
			return;
		}
		
		for(int i = 0; i < N; i++)
			if((chk&(1<<i)) == 0)
				dfs(cnt + 1, chk|(1<<i), sum + arr[i]);
	}
}