import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, K;
	static int[] par;
	static long[] ham;
	static ArrayList<Integer>[] arr;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		ham = new long[N+1];
		par = new int[N+1];
		
		for(int i = 1; i <= N; i++){
			par[i] = -1;
			arr[i] = new ArrayList<>();
			String str = br.readLine().trim();
			ham[i] = Long.parseLong(str, 2);
			
			for(int j = 1; j < i; j++){
				 if(Long.bitCount(ham[j]^ham[i]) > 1) continue;//거리가 1 넘는 건 패스
				 arr[i].add(j);
				 arr[j].add(i);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
		
		par[s] = 0;
		bfs(s, e);
		
		if(par[e] == -1){
			System.out.println(-1);
			return;
		}
		
		Stack<Integer> stack = new Stack<>();
		stack.push(e);
		int idx = e;
		
		while(par[idx] != 0){
			stack.push(par[idx]);
			idx = par[idx];
		}
		
		while(!stack.isEmpty()) bw.write(stack.pop() + " ");
		bw.flush();
	}
	private static void bfs(int s, int e) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(s);
		int size;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				int v = q.poll();
				
				if(v == e) continue;
				
				for(int next : arr[v])
					if(par[next] == -1){
						par[next] = v;
						q.offer(next);
					}
			}
		}
	}
}