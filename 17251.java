import java.util.*;

public class Main {
	static int N;
	static int[] arr, tree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int len = (int)Math.pow(2, Math.ceil(Math.log(N) / Math.log(2))+1);
		arr = new int[N + 1];
		tree = new int[len + 1];
		Arrays.fill(tree, -1);
		for(int i = 1; i <= N; i++)
			arr[i] = sc.nextInt();
		
		makeMax(1, 1, N);
		
		int r = 0, b = 0;
		for(int i = 1; i < N; i++)
		{
			int tmpL = findMax(1, 1, N, 1, i), tmpR = findMax(1, 1, N, i + 1, N);
			if(tmpL > tmpR) ++r;
			else if(tmpL < tmpR) ++b;
		}
		
		System.out.println(r > b ? "R" : r == b ? "X" : "B");
	}
	private static int findMax(int node, int s, int e, int l, int r) {
		if(l > e || r < s) return -1;
		if(l <= s && e <= r) return tree[node];
		return Math.max(findMax(node * 2, s, (s + e) / 2, l, r), findMax(node * 2 + 1, (s + e) / 2 + 1, e, l, r));
	}
	private static int makeMax(int node, int s, int e) {
		if(s == e) return tree[node] = arr[s];
		else return tree[node] = Math.max(makeMax(node * 2, s, (s + e) / 2),
								makeMax(node * 2 + 1, (s + e) / 2 + 1, e));
	}
}