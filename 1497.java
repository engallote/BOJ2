import java.util.*;

public class Main {
	static int N, M, res, ans;
	static String[] str;
	static char[][] arr;
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		str = new String[N];
		chk = new boolean[N];
		arr = new char[N][M];
		res = 0;
		ans = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++){
			str[i] = sc.next();
			arr[i] = sc.next().toCharArray();
		}
		
		solve(0, 0);
		if(ans == Integer.MAX_VALUE || ans == 0) ans = -1;
		System.out.println(ans);
	}
	private static void solve(int idx, int cnt) {
		int num = find();
		
		if(num > res){
			res = num;
			ans = cnt;
		}
		else if(num == res) ans = Math.min(ans, cnt);
		
		for(int i = idx; i < N; i++){
			chk[i] = true;
			solve(i + 1, cnt + 1);
			chk[i] = false;
		}
	}
	private static int find() {
		HashSet<Integer> hs = new HashSet<>();
		
		for(int i = 0; i < N; i++)
			if(chk[i]){
				for(int j = 0; j < M; j++)
					if(arr[i][j] == 'Y') hs.add(j);
			}
		return hs.size();
	}
}