import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M, cnt, res;
	static ArrayList<Integer>[] arr;
	static int[] par, chk, chk2;
	static boolean[] finish;
	static Stack<Integer> stack;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N];
		chk = new int[N];
		chk2 = new int[N];
		finish = new boolean[N];
		stack = new Stack<>();
		
		for(int i = 0; i < N; i++) {
			arr[i] = new ArrayList<>();
			chk[i] = 0;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a].add(b);
		}
		
		for(int i = 0; i < N; i++)
			dfs(i);
		
		Arrays.fill(finish, false);
		cnt = res = 0;
		while(!stack.isEmpty()) {
			int x = stack.pop();
			
			if(finish[x]) continue;
			++res;
			find(x);
		}
		
		bw.write(res+"");
		bw.flush();
	}
	private static void dfs(int idx) {
		if(finish[idx]) return;
		finish[idx] = true;
		
		for(int next : arr[idx])
			dfs(next);
		
		stack.push(idx);
	}
	private static void find(int idx) {
		if(finish[idx]) return;
		finish[idx] = true;
		
		for(int next : arr[idx])
			find(next);
	}
}