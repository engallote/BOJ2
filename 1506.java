import java.util.*;

public class Main {
	static int N, cnt, res;
	static int[] cost, chk;
	static ArrayList<Integer>[] arr;
	static Stack<Integer> st;
	static boolean[] finish;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		st = new Stack<>();
		cost = new int[N];
		chk = new int[N];
		arr = new ArrayList[N];
		finish = new boolean[N];
		
		for(int i = 0; i < N; i++){
			cost[i] = sc.nextInt();
			chk[i] = -1;
			arr[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N; i++){
			char[] ch = sc.next().toCharArray();
			for(int j = 0; j < N; j++)
				if(i != j && ch[j] == '1') arr[i].add(j);
		}
		
		res = 0;
		cnt = 0;
		for(int i = 0; i < N; i++){
			if(finish[i]) continue;
			cycle(i);
		}
		
		System.out.println(res);
	}
	private static int cycle(int idx) {
		chk[idx] = ++cnt;
		int cur = chk[idx];
		st.push(idx);
		
		for(int next : arr[idx]){
			if(chk[next] == -1) cur = Math.min(cur, cycle(next));
			else if(!finish[next]) cur = Math.min(cur, chk[next]);
		}
		
		if(cur == chk[idx]){
			int tmp = 0, min = Integer.MAX_VALUE;
			while(true){
				tmp = st.pop();
				finish[tmp] = true;;
				min = Math.min(min, cost[tmp]);
				if(tmp == idx) break;
			}
			res += min;
		}
		
		return cur;
	}
}