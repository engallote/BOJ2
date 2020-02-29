import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int res = Integer.MAX_VALUE;
		
		for(int i = 0; i < M; i++)
		{
			int u = sc.nextInt();
			int d = sc.nextInt();
			
			res = Math.min(res, find(u, d, N));
		}
		System.out.println(res);
	}

	private static int find(int u, int d, int N) {
		int cur = 0, cnt = 0;
		ArrayList<Integer> arr = new ArrayList<>();
		
		while(cnt < N){
			if(cur >= d) cur -= d;
			else cur += u;
			arr.add(cur);
			++cnt;
			if(cur == 0) break;
		}
		
		if(cnt < N) cur = arr.get((N-cnt - 1) % arr.size());
		if(cur == 0) cur = arr.get(arr.size() - 2) + u;
		
		return cur;
	}
}