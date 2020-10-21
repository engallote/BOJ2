import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N;
	static int[] par;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		par = new int[N + 1];
		HashSet<String> hs = new HashSet<>();
		ArrayList<Pair> aly = new ArrayList<>();
		
		for(int i = 1; i <= N; i++) {
			par[i] = i;
			String[] arr = br.readLine().split(" ");
			for(int j = 1; j <= N; j++) {
				int num = Integer.parseInt(arr[j-1]);
				if(num == 0 || hs.contains(i + " " + j) || hs.contains(j + " " + i)) continue;
				hs.add(i + " " + j);
				aly.add(new Pair(i, j, num));
			}
		}
		
		Collections.sort(aly);
		
		for(Pair p : aly) {
			int ap = find(p.a), bp = find(p.b);
			
			if(ap == bp) continue;
			par[bp] = ap;
			bw.write(p.a + " " + p.b + "\n");
		}
		bw.flush();
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}
class Pair implements Comparable<Pair> {
	int a, b, cost;
	Pair(int a, int b, int cost) {
		this.a = a;
		this.b = b;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cost > this.cost ? -1 : (o.cost == this.cost ? 0 : 1);
	}
}