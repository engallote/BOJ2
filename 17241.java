import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M;
	static Queue<Integer>[] arr;
	static boolean[] chk;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		arr = new LinkedList[N + 1];
		chk = new boolean[N + 1];
		
		for(int i = 1; i <= N; i++)
			arr[i] = new LinkedList<Integer>();
		
		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		
		while(--Q >= 0){
			int idx = Integer.parseInt(br.readLine());
			bw.write(find(idx)+"\n");
		}
		bw.flush();
	}
	private static int find(int idx) {
		int res = 0;
		
		if(!chk[idx]) ++res;
		chk[idx] = true;
		
		while(!arr[idx].isEmpty()){
			int x = arr[idx].poll();
			if(!chk[x]){
				chk[x] = true;
				++res;
			}
		}
		return res;
	}
}