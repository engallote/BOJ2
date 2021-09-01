import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M;
	static boolean[] chk;
	static int[] arr;
	static ArrayList<Integer>[] aly;
    public static void main(String[] args) throws IOException {
//    	Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	StringTokenizer st;
    	
    	while(--T >= 0) {
    		st = new StringTokenizer(br.readLine());
    		N = Integer.parseInt(st.nextToken());
    		M = Integer.parseInt(st.nextToken());
    		arr = new int[N + 1];
    		chk = new boolean[N + 1];
    		aly = new ArrayList[N + 1];
    		
    		for(int i = 1; i <= N; i++)
    			aly[i] = new ArrayList<>();
    		
    		for(int i = 0; i < M; i++) {
    			st = new StringTokenizer(br.readLine());
    			int a = Integer.parseInt(st.nextToken());
    			int b = Integer.parseInt(st.nextToken());
    			
    			aly[a].add(b);
    			aly[b].add(a);
    		}
    		
    		for(int i = 1; i <= N; i++)
    			if(!chk[i]) {
    				chk[i] = true;
    				solve(i, 0);
    			}
    		
    		boolean flag = true;
    		loop:for(int i = 1; i <= N; i++) {
    			for(int next : aly[i])
    				if(arr[i] == arr[next]) {
    					flag = false;
    					break loop;
    				}
    		}
    		
    		System.out.println(flag ? "YES" : "NO");
    	}
	}
	private static void solve(int idx, int c) {
		arr[idx] = c;
		int nextC = (c + 1) % 2;
		
		for(int next : aly[idx]) {
			if(chk[next]) continue;
			chk[next] = true;
			solve(next, nextC);
		}
	}
}