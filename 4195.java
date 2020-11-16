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
		HashMap<String, Integer> hs = new HashMap<>();
		
		while(--T >= 0) {
			int N = Integer.parseInt(br.readLine());
			par = new int[N *2];
			int[] fr = new int[N * 2];
			ArrayList<Integer>[] arr = new ArrayList[N * 2];
			hs.clear();
			
			for(int i = 0; i < N * 2; i++) {
				par[i] = i;
				fr[i] = 1;
				arr[i] = new ArrayList<>();
				arr[i].add(i);
			}
			
			int idx = 0;
			StringTokenizer st;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String s1 = st.nextToken();
				String s2 = st.nextToken();
				
				int x1 = 0, x2 = 0;
				if(hs.containsKey(s1)) x1 = hs.get(s1);
				else {
					hs.put(s1, idx);
					x1 = idx;
					++idx;
				}
				if(hs.containsKey(s2)) x2 = hs.get(s2);
				else {
					hs.put(s2, idx);
					x2 = idx;
					++idx;
				}
				
				int ap = find(x1), bp = find(x2);
				if(ap == bp) {
					bw.write(fr[ap]+"\n");
					continue;
				}
				else {
					par[bp] = ap;
					fr[ap] += arr[bp].size();
					for(int num : arr[bp]) {
						par[num] = ap;
						arr[ap].add(num);
					}
					arr[bp].clear();
					bw.write(fr[ap]+"\n");
				}
			}
		}
		bw.flush();
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}