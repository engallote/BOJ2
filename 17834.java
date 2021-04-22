import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M;
	static long res;
	static int[] chk;
	static boolean flag;
	static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
//    	Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	res = 0;
    	flag = false;
    	chk = new int[N + 1];
    	arr = new ArrayList[N + 1];
    	
    	for(int i = 1; i <= N; i++)
    		arr[i] = new ArrayList<>();
    	
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		arr[a].add(b);
    		arr[b].add(a);
    	}
    	
    	dfs(1, 1);
    	
    	if(flag) bw.write("0");
    	else bw.write((2 * res * (N - res)) + "");
    	bw.flush();
	}
	private static void dfs(int idx, int color) {
		chk[idx] = color;
		
		if(chk[idx] == 1) ++res;
		
		for(int next : arr[idx]) {
			if(chk[next] == 0) dfs(next, 3 - color);	
			else if(chk[next] == color) {
				flag = true;
				return;
			}
		}
		
	}
}