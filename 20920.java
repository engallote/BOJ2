import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> hm = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine().trim();
			
			if(str.length() >= M) {
				if(hm.containsKey(str)) hm.replace(str, hm.get(str) + 1);
				else hm.put(str, 1);
			}
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		Iterator<String> it = hm.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			int value = hm.get(key);
			pq.offer(new Pair(key, value));
		}
		
		while(!pq.isEmpty())
			bw.write(pq.poll().str+"\n");
		bw.flush();
	}
}
class Pair implements Comparable<Pair> {
	int cnt;
	String str;
	Pair(String str, int cnt) {
		this.str = str;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		if(this.cnt > o.cnt) return -1;
		else if(o.cnt == this.cnt) {
			if(o.str.length() > this.str.length()) return 1;
			else if(o.str.length() == this.str.length()) {
				return this.str.compareTo(o.str);
			}
			else return -1;
		}
		return 1;
	}
}