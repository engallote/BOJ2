import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] arr;
	static int[] chk;
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	arr = new ArrayList[N + 1];
    	chk = new int[N + 1];
    	
    	for(int i = 1; i <= N; i++)
    		arr[i] = new ArrayList<>();
    	
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		arr[b].add(a);
    	}
    	
    	int num = Integer.parseInt(br.readLine());
    	int res = solve(num) - 1;
    	
    	bw.write(res+"");
    	bw.flush();
	}
	private static int solve(int num) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(num);
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			cnt += size;
			while(--size >= 0) {
				int x = q.poll();
				
				for(int next : arr[x])
					if(chk[next] == 0) {
						chk[next] = 1;
						q.offer(next);
					}
			}
		}
		
		return cnt;
	}
}