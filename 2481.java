import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, K;
	static int[] par;
	static ArrayList<Integer>[] arr;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		par = new int[N+1];
		HashMap<Long, Integer> hs = new HashMap<>();
		
		for(int i = 1; i <= N; i++){
			par[i] = -1;
			arr[i] = new ArrayList<>();
			char[] ch = br.readLine().trim().toCharArray();
			long sum = 0;
			for(int j = K - 1; j >= 0; j--)
				sum += (ch[j] - '0') * (1 << K - j - 1);
			hs.put(sum, i);
		}
		
		Iterator<Long> it = hs.keySet().iterator();
		while(it.hasNext()){
			long key = it.next();
			int idx = hs.get(key);
			
			for(int i = 0; i < K; i++)
				if(hs.containsKey(key^(1<<i)))
					arr[idx].add(hs.get(key^(1<<i)));
		}
		
		int M = Integer.parseInt(br.readLine());
		
		par[1] = 0;
		bfs();
		
		Stack<Integer> stack = new Stack<>();
		while(--M >= 0){
			int e = Integer.parseInt(br.readLine());
			if(par[e] == -1){
				bw.write("-1\n");
				continue;
			}
			
			stack.clear();
			stack.push(e);
			int idx = e;
			
			while(par[idx] != 0){
				stack.push(par[idx]);
				idx = par[idx];
			}
			
			while(!stack.isEmpty()) bw.write(stack.pop() + " ");
			bw.write("\n");
		}
		bw.flush();
	}
	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		int size;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				int v = q.poll();
				
				for(int next : arr[v])
					if(par[next] == -1){
						par[next] = v;
						q.offer(next);
					}
			}
		}
	}
}