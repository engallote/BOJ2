import java.util.*;

public class Main {
	static int N, cur = 1, res = 0;
	static ArrayList<Integer>[] arr;
	static int[] chk;
	static boolean[] visit;
	static Stack<Integer> st;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		arr = new ArrayList[N + 1];
		chk = new int[N + 1];
		visit = new boolean[N + 1];
		st = new Stack<>();
		
		for(int i = 1; i <= N; i++)
			arr[i] = new ArrayList<>();
		
		while(--M >= 0){
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a].add(b);
		}
		
		for(int i = 1; i <= N; i++){
			if(visit[i]) continue;
			cycle(i);
		}
		
		System.out.println(res);
	}
	private static int cycle(int idx) {
		chk[idx] = cur;
		int num = cur;
		st.push(idx);
		++cur;
		
		for(int next : arr[idx]){
			if(chk[next] == 0) num = Math.min(num, cycle(next));
			else if(!visit[next]) num = Math.min(num, chk[next]);
		}
		
		if(num == chk[idx]){
			int sum = 0;
			while(!st.isEmpty()){
				int tmp = st.pop();
				visit[tmp] = true;
				++sum;
				if(tmp == idx) break;
			}
			res = Math.max(res, sum);
		}
		return num;
	}
}