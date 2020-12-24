import java.util.*;

public class Main {
	static int N, P;
	static ArrayList<Pair>[] path;
	static Pair[] arr;
	static long[] sum, chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();//����
			P = sc.nextInt();//ģ��
			int M = sc.nextInt();//����
			path = new ArrayList[N + 1];
			sum = new long[N + 1];
			chk = new long[N + 1];
			arr = new Pair[P];
			
			for(int i = 1; i <= N; i++)
				path[i] = new ArrayList<>();
			
			for(int i = 0; i < P; i++) {
				int x = sc.nextInt();//i�� ģ���� ��� ���� ��ȣ
				long v = sc.nextLong();//1��ŭ �����̴� �� �ɸ��� �ð�
				arr[i] = new Pair(x, v);
			}
			
			for(int i = 0; i < M; i++) {
				long D = sc.nextLong();//���ΰ� �������� ���õ� ������ �Ÿ�
				int L = sc.nextInt();//���ΰ� �������� ���� ��
				
				int s = sc.nextInt(), e = 0;
				for(int j = 1; j < L; j++) {
					e = sc.nextInt();
					path[s].add(new Pair(e, D));
					path[e].add(new Pair(s, D));
					s = e;
				}
			}
			
			long res = Long.MAX_VALUE;
			for(int i = 0; i < P; i++) {
				go(i);
				for(int j = 1; j <= N; j++) {
					if(sum[j] == -1) continue;
					if(chk[j] == Long.MAX_VALUE) sum[j] = -1;
					else sum[j] = Math.max(sum[j], chk[j]);
				}
			}
			
			for(int i = 1; i <= N; i++)
				if(sum[i] != -1)
					res = Math.min(res, sum[i]);
			
			if(res == Long.MAX_VALUE) res = -1;
			System.out.println("Case #" + test_case + ": " + res);
		}
	}
	private static void go(int idx) {
		Queue<Pair> q = new LinkedList<>();
		Arrays.fill(chk, Long.MAX_VALUE);
		q.offer(new Pair(arr[idx].v, 0));
		chk[arr[idx].v] = 0;
		long d = arr[idx].cost;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			for(Pair next : path[p.v])
				if(chk[next.v] > p.cost + next.cost * d) {
					chk[next.v] = p.cost + next.cost * d;
					q.offer(new Pair(next.v, chk[next.v]));
				}
		}
	}
}
class Pair {
	int v;
	long cost;
	Pair(int v, long cost) {
		this.v = v;
		this.cost = cost;
	}
}