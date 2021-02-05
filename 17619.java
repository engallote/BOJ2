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
		StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        par = new int[N + 1];
        Pair[] arr = new Pair[N];
        
        for(int i = 1; i <= N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken());
        	int e = Integer.parseInt(st.nextToken());
        	int h = Integer.parseInt(st.nextToken());
        	arr[i - 1] = new Pair(i, s, e, h);
        	par[i] = i;
        }
        
        Arrays.sort(arr);
        
        for(int i = 0; i < N; i++)
        	for(int j = i + 1; j < N; j++) {
        		Pair p1 = arr[i], p2 = arr[j];
        		
        		if(p1.e < p2.s) break;
            	
            	int ap = find(p1.idx), bp = find(p2.idx);
            	
            	if(ap == bp) continue;
            	par[bp] = ap;
        	}
        
        while(--Q >= 0) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	if(par[a] == par[b]) bw.write("1");
        	else if(find(a) == find(b)) bw.write("1");
        	else bw.write("0");
        	bw.newLine();
        }
        bw.flush();
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}
class Pair implements Comparable<Pair> {
	int idx, s, e, h;
	Pair(int idx, int s, int e, int h) {
		this.idx = idx;
		this.s = s;
		this.e = e;
		this.h = h;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.s > this.s) return -1;
		else if(o.s == this.s) return 0;
		else return 1;
	}
}