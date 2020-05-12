import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, K, cnt;
	static int[][] dp;
	static ArrayList<Integer>[] arr;
	static ArrayList<Integer> aly = new ArrayList<>();
	static boolean[] visit;
	static int[] chk;
	static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        chk = new int[N + 1];
        
        for(int i = 1; i <= N; i++){
        	arr[i] = new ArrayList<>();
        	chk[i] = -1;
        }
        
        for(int i = 0; i < M; i++){
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	arr[a].add(b);
        	arr[b].add(a);
        }
        
        cnt = 0;
        for(int i = 1; i <= N; i++){
        	if(visit[i]) continue;
        	isCycle(i);
        }
        
        dp = new int[aly.size()][K+1];
        for(int i = 0; i < aly.size(); i++)
        	Arrays.fill(dp[i], -1);
        
        if(isCan(0, 0) > 0) bw.write("SAFE");
        else bw.write("DOOMED");
        bw.flush();
    }
	private static int isCan(int idx, int sum) {
		if(sum == K) return 1;
		if(idx >= aly.size()) return 0;
		if(dp[idx][sum] != -1) return dp[idx][sum];
		int ret = 0;
		
		for(int i = idx; i < aly.size(); i++)
			if(sum + aly.get(i) <= K) 
				ret = Math.max(ret, isCan(i + 1, sum + aly.get(i)));
		
		return dp[idx][sum] = ret;
	}
	private static int isCycle(int idx) {
		chk[idx] = ++cnt;
		int num = chk[idx];
		stack.push(idx);
		
		for(int next : arr[idx]){
			if(chk[next] == -1) num = Math.min(num, isCycle(next));
			else if(!visit[next]) num = Math.min(num, chk[next]);
		}
		
		if(num == chk[idx]){
			int count = 0;
			while(true){
				int tmp = stack.pop();
				++count;
				if(tmp == idx) break;
			}
			aly.add(count);
		}
		return num;
	}
}