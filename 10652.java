import java.util.*;

public class Main {
	static int N, M;
	static long B, E, P;
	static ArrayList<Integer>[] arr;
	static long[] chk1, chk2, chk3;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		B = sc.nextLong();
		E = sc.nextLong();
		P = sc.nextLong();
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new ArrayList[N + 1];
		chk1 = new long[N + 1];
		chk2 = new long[N + 1];
		chk3 = new long[N + 1];
		
		for(int i = 1; i <= N; i++){
			arr[i] = new ArrayList<>();
			chk1[i] = Long.MAX_VALUE;
			chk2[i] = Long.MAX_VALUE;
			chk3[i] = Long.MAX_VALUE;
		}
		
		for(int i = 0; i < M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a].add(b);
			arr[b].add(a);
		}
		
		bfsB(1);
		bfsE(2);
		bfsTo();
		
		long res = Long.MAX_VALUE;
		for(int i = 1; i <= N; i++){
			if(chk1[i] == Long.MAX_VALUE || chk2[i] == Long.MAX_VALUE || chk3[i] == Long.MAX_VALUE)
				continue;
			long tmp = chk1[i] + chk2[i] + chk3[i];
			res = Math.min(res, tmp);
		}
		
		System.out.println(res);
	}
	private static void bfsTo() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(N);
		chk3[N] = 0;
		
		int size = 0;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				int x = q.poll();
				
				for(int next : arr[x])
					if(chk3[next] > chk3[x] + P){
						chk3[next] = chk3[x] + P;
						q.offer(next);
					}
			}
		}
	}
	private static void bfsB(int start) {
		chk1[start] = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		
		int size = 0;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				int x = q.poll();
				
				if(x == N) continue;
				
				for(int next : arr[x])
					if(chk1[next] > chk1[x] + B){
						chk1[next] = chk1[x] + B;
						q.offer(next);
					}
			}
		}
	}
	private static void bfsE(int start) {
		chk2[start] = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		
		int size = 0;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				int x = q.poll();
				
				if(x == N) continue;
				
				for(int next : arr[x])
					if(chk2[next] > chk2[x] + E){
						chk2[next] = chk2[x] + E;
						q.offer(next);
					}
			}
		}
	}
}