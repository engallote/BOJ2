import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, S, D;
	static int[] num;
	static boolean[] chk;
	static ArrayList<Integer>[] arr;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N + 1];
		chk = new boolean[N + 1];
		num = new int[N + 1];
		
		for(int i = 1; i <= N; i++)
			arr[i] = new ArrayList<>();
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		
		solve(S);
		
		Arrays.fill(chk, false);
		Queue<Integer> q = new LinkedList<>();
		q.offer(S);
		chk[S] = true;
		int res = 0;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			
			for(int next : arr[x])
				if(!chk[next] && num[next] >= D) {
					chk[next] = true;
					q.offer(next);
					++res;
				}
		}
		for(int i = 1; i <= N; i++)
			System.out.println(i + " : " + num[i]);
		res *= 2;
		bw.write(res+"");
		bw.flush();
	}
	private static int solve(int idx) {
		chk[idx] = true;
		boolean leaf = true;
		int ret = 0;
		for(int next : arr[idx])
			if(!chk[next]) {
				leaf = false;
				ret = Math.max(ret, solve(next) + 1);
			}
		if(!leaf) num[idx] = ret;
		return ret;
	}
}