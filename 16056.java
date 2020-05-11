import java.util.*;

public class Main {
	static int N, M, K;
	static int[] chk, chk2, col;
	static boolean[] visit;
	static ArrayList<Integer>[] arr, rev;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        arr = new ArrayList[M+1];
        rev = new ArrayList[N+1];
        col = new int[M+1];
        chk = new int[M+1];
        chk2 = new int[N+1];
        visit = new boolean[M+1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int i = 1; i <= M; i++){
        	arr[i] = new ArrayList<>();
        	chk[i] = -1;
        }
        for(int i = 1; i <= N; i++){
        	rev[i] = new ArrayList<>();
        	chk2[i] = -1;
        }
        
        for(int i = 0; i < K; i++){
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	++col[b];
        	rev[a].add(b);
        	arr[b].add(a);
        }
        
        for(int i = 1; i <= M; i++)
        	pq.offer(new Pair(i, col[i]));
        
        int res = 0;
        while(!pq.isEmpty()){
        	Pair p = pq.poll();
        	Arrays.fill(visit, false);
        	if(dfs(p.idx)) ++res;
        }
        
        int end = 3, tmp = res;
        for(int i = 1; i <= N; i++){
        	int cnt = 0;
        	end = 3;
        	if(chk2[i] != 0) end = 2;
        	
        	for(int next : rev[i]){
        		if(chk[next] == -1) ++cnt;
        		if(cnt == end) break;
        	}
        	
        	res = Math.max(res, tmp + cnt);
        }
        
        System.out.println(res);
    }
	private static boolean dfs(int idx) {
		if(visit[idx]) return false;
		visit[idx] = true;
		
		for(int next : arr[idx])
			if(chk2[next] == -1 || (chk2[next] != -1 && dfs(chk2[next]))){
				chk2[next] = idx;
				chk[idx] = next;
				return true;
			}
		return false;
	}
}
class Pair implements Comparable<Pair>{
	int idx, num;
	Pair(int idx, int num){
		this.idx = idx;
		this.num = num;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.num > this.num) return -1;
		else if(o.num == this.num) return o.idx > this.idx ? -1 : 1;
		else return 1;
	}
}