import java.util.*;

public class Main {
	static int[] par;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        par = new int[N];
        char[][] arr = new char[N][N];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int sum = 0;
        
        for(int i = 0; i < N; i++) {
        	par[i] = i;
        	arr[i] = sc.next().toCharArray();
        	for(int j = 0; j < N; j++)
        		if(arr[i][j] != '0') {
        			if('A' <= arr[i][j] && arr[i][j] <= 'Z') {
        				pq.offer(new Pair(i, j, arr[i][j] -'A' + 27));
        				sum += arr[i][j] -'A' + 27;
        			}
        			else {
        				pq.offer(new Pair(i, j, arr[i][j] -'a' + 1));
        				sum += arr[i][j] -'a' + 1;
        			}
        		}
        }
        
        int cnt = 0;
        while(!pq.isEmpty()) {
        	Pair p = pq.poll();
        	
        	int ap = find(p.a), bp = find(p.b);
        	
        	if(ap == bp) continue;
        	
        	par[bp] = ap;
        	sum -= p.c;
        	++cnt;
        	if(cnt == N - 1) break;
        }
        
        if(cnt == N - 1) System.out.println(sum);
        else System.out.println(-1);
    }
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}
class Pair implements Comparable<Pair>{
	int a, b, c;
	Pair(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
		
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.c, o.c);
	}
}