import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int[] par;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        
        while(--T >= 0) {
        	int N = Integer.parseInt(br.readLine());
        	int M = Integer.parseInt(br.readLine());
        	par = new int[N + 1];
        	boolean[][] chk = new boolean[N + 1][N + 1];
        	        	
        	for(int i = 1; i <= N; i++)
        		par[i] = i;
        	
        	boolean flag = true;
        	if(M != N - 1) flag = false;
        	
        	StringTokenizer st;
        	for(int i = 0; i < M; i++) {
        		st = new StringTokenizer(br.readLine());
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		
        		if(!flag) continue;
        		if(a == b || chk[a][b]) {
        			flag = false;
        			continue;
        		}
        		chk[a][b] = chk[b][a] = true;
        		int ap = find(a), bp = find(b);
        		if(ap == bp) {
        			flag = false;
        			continue;
        		}
        		
        		par[bp] = ap;
        	}
        	
        	HashSet<Integer> hs = new HashSet<>();
        	for(int i = 1; i <= N; i++)
        		hs.add(find(i));
        	
        	if(flag && hs.size() == 1) bw.write("tree");
        	else bw.write("graph");
        	bw.newLine();
        }
        bw.flush();
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}