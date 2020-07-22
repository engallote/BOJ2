import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int[] par;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++){
			int N = Integer.parseInt(br.readLine());
			int k = Integer.parseInt(br.readLine());
			par = new int[N];
			Arrays.fill(par, -1);
			
			StringTokenizer st;
			for(int i = 0; i < k; i++){
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				
				if(u > v){
					int tmp = u;
					u = v;
					v = tmp;
				}
				
				merge(u, v);
			}
			
			int M = Integer.parseInt(br.readLine());
			bw.write("Scenario " + test_case + ":\n");
			while(--M >= 0){
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				
				int ap = find(u), bp = find(v);
				if(ap == bp) bw.write("1\n");
				else bw.write("0\n");
			}
			bw.write("\n");
		}
		bw.flush();
	}
	public static void merge(int a, int b){
		int ap = find(a), bp = find(b);
		if(ap == bp) return;
		
		par[ap] += par[bp];
		par[bp] = ap;
	}
	public static int find(int x){
		if(par[x] < 0) return x;
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}