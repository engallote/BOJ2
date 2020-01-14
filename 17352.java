import java.util.*;

public class Main {
	static int N, cnt = 1;
	static ArrayList<Integer>[] arr;
	static int[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new ArrayList[N + 1];
		chk = new int[N + 1];
		
		for(int i = 1; i <= N; i++) arr[i] = new ArrayList<>();
		for(int i = 0; i < N - 2; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a].add(b);
			arr[b].add(a);
		}
		
		int res = 0;
		for(int i = 1; i <= N; i++)
			if(chk[i] == 0) {
				chk[i] = cnt;
				if(cnt == 2) {
					res = i;
					break;
				}
				solve(i);
				++cnt;
			}
		
		System.out.println("1 " + res);
	}
	private static void solve(int idx) {
		for(int next : arr[idx])
			if(chk[next] == 0) {
				chk[next] = cnt;
				solve(next);
			}
	}
}