import java.util.*;

public class Main {
	static int N;
	static int[] stuff, chk1, chk2;
	static ArrayList<Pair>[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		stuff = new int[N + 1];
		chk1 = new int[N + 1];
		chk2 = new int[N + 1];
		arr = new ArrayList[N + 1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
			stuff[i] = sc.nextInt();
			chk1[i] = 1000000000;
			chk2[i] = -1;
		}
		
		int M = sc.nextInt();
		while(--M >= 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int d = sc.nextInt();
			arr[a].add(new Pair(b, d));
			arr[b].add(new Pair(a, d));
		}
		
		bfs();
	}
	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		chk1[1] = 0;
		chk2[1] = stuff[1];
		int size;
		
		while(!q.isEmpty()) {
			size = q.size();
			while(--size >= 0) {
				int x = q.poll();
				
				if(x == N) continue;
				
				for(Pair next : arr[x]) {
					if(chk1[next.v] > chk1[x] + next.d) {
						chk1[next.v] = chk1[x] + next.d;
						chk2[next.v] = chk2[x] + stuff[next.v];
						q.offer(next.v);
					}
					else if(chk1[next.v] == chk1[x] + next.d && chk2[next.v] < chk2[x] + stuff[next.v]) {
						chk1[next.v] = chk1[x] + next.d;
						chk2[next.v] = chk2[x] + stuff[next.v];
						q.offer(next.v);
					}
				}
			}
		}
		
		if(chk2[N] == -1) System.out.println("impossible");
		else System.out.println(chk1[N] + " " + chk2[N]);
	}
}
class Pair {
	int v, d;
	Pair(int v, int d) {
		this.v = v;
		this.d = d;
	}
}