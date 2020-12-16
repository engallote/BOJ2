import java.util.*;

public class Main {
	static int N, K, max = 65536;
	static long[] tree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		long[] arr = new long[N];
		tree = new long[max * 4];
		
		for(int i = 0; i < N; i++) 
			arr[i] = sc.nextLong();
		
		for(int i = 0; i < K; i++) 
			update(arr[i], 1, 1, 0, max);
		
		long sum = find((K + 1) / 2, 1, 0, max);
		
		for(int i = K; i < N; i++) {
			update(arr[i], 1, 1, 0, max);
			update(arr[i - K], -1, 1, 0, max);
			sum += find((K + 1) / 2, 1, 0, max);
		}
		
		System.out.println(sum);
	}
	private static long find(long idx, int node, int s, int e) {
		if(s == e) return s;
		if(idx <= tree[node * 2]) return find(idx, node * 2, s, (s + e) / 2);
		return find(idx - tree[node * 2], node * 2 + 1, (s + e) / 2 + 1, e);
	}
	private static long update(long num, long cnt, int node, int s, int e) {
		if(e < num || num < s) return tree[node];
		if(s == e) {
			tree[node] += cnt;
			return tree[node];
		}
		return tree[node] = update(num, cnt, node * 2, s, (s + e) / 2) + update(num, cnt, node * 2 + 1, (s + e) / 2 + 1, e);
	}
}