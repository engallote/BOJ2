import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	
    	HashMap<String, Integer> hs = new HashMap<>(), hs2 = new HashMap<>();
    	for(int i = 0; i < N * 3; i++) {
    		String str = br.readLine();
    		if(hs.containsKey(str)) hs.replace(str, hs.get(str) + 1);
    		else hs.put(str, 1);
    		
    		if(hs2.containsKey(str)) hs2.replace(str, i);
    		else hs2.put(str, i);
    	}
    	
    	PriorityQueue<Pair> pq = new PriorityQueue<>();
    	Iterator<String> it = hs.keySet().iterator();
    	
    	while(it.hasNext()) {
    		String key = it.next();
    		int val = hs.get(key);
    		
    		pq.offer(new Pair(key, val, hs2.get(key)));
    	}
    	
    	int len = pq.size();
    	for(int i = 0; i < K && i < len; i++)
    		bw.write(pq.poll().str + "\n");
    	
    	bw.flush();
	}
}
class Pair implements Comparable<Pair> {
	int idx, cnt;
	String str;
	Pair(String str, int cnt, int idx) {
		this.str = str;
		this.cnt = cnt;
		this.idx = idx;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.cnt > this.cnt) return 1;
		else if(o.cnt == this.cnt) {
			if(o.idx < this.idx) return -1;
			else return 1;
		}
		else return -1;
	}
}