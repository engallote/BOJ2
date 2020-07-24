import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		ArrayList<Integer> aly1 = new ArrayList<>(), aly2 = new ArrayList<>();
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		dfs(0, N / 2 - 1, 0, aly1);
		dfs(N / 2, N - 1, 0, aly2);
		
		int res = 0;
		for(int i = 0; i < aly1.size(); i++)
			for(int j = 0; j < aly2.size(); j++)
				if(aly1.get(i) + aly2.get(j) <= M) ++res;
		
		System.out.println(res);
	}
	private static void dfs(int idx, int end, int sum, ArrayList<Integer> aly) {
		if(sum > M) return;
		if(idx > end){
			aly.add(sum);
			return;
		}
		
		dfs(idx + 1, end, sum, aly);
		dfs(idx + 1, end, sum + arr[idx], aly);
	}
}