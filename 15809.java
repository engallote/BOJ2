import java.util.*;

public class Main {
	static int N;
	static int[] par, arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		par = new int[N + 1];
		arr = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
			par[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			int O = sc.nextInt();
			int P = sc.nextInt();
			int Q = sc.nextInt();
			
			int ap = find(P), bp = find(Q);
			if(ap == bp) continue;
			if(O == 1) {//µ¿¸Í
				if(ap < bp) {
					par[bp] = ap;
					arr[ap] += arr[bp];
					arr[bp] = arr[ap];
				}
				else {
					par[ap] = bp;
					arr[bp] += arr[ap];
					arr[ap] = arr[bp];
				}
			}
			else {//ÀüÀï
				if(arr[ap] > arr[bp]) {
					arr[ap] -= arr[bp];
					arr[bp] = 0;
					par[bp] = ap;
				}
				else if(arr[ap] < arr[bp]) {
					arr[bp] -= arr[ap];
					arr[ap] = 0;
					par[ap] = bp;
				}
				else arr[ap] = arr[bp] = 0;
			}
		}
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i = 1; i <= N; i++)
			if(arr[i] > 0 && par[i] == i)
				q.offer(arr[i]);
		
		System.out.println(q.size());
		while(!q.isEmpty())
			System.out.print(q.poll() + " ");
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}