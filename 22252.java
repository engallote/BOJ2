import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int Q = Integer.parseInt(br.readLine());
    	PriorityQueue<Long>[] pq = new PriorityQueue[100001];
    	HashMap<String, Integer> hm = new HashMap<>();
    	
    	for(int i = 0; i <= 100000; i++)
    		pq[i] = new PriorityQueue<>(Collections.reverseOrder());
    	
    	int idx = 0;
    	long res = 0;
    	StringTokenizer st;
    	for(int i = 0; i < Q; i++) {
    		st = new StringTokenizer(br.readLine());
    		int order = Integer.parseInt(st.nextToken());
    		String name = st.nextToken();
    		
    		if(!hm.containsKey(name)) {
    			hm.put(name, idx);
    			idx += 1;
    		}
    		
    		if(order == 1) {
    			int k = Integer.parseInt(st.nextToken());
    			int key = hm.get(name);
    			
    			for(int j = 0; j < k; j++) {
    				int num = Integer.parseInt(st.nextToken());
    				pq[key].offer((long)num);
    			}
    		}
    		else {
    			int b = Integer.parseInt(st.nextToken());
    			if(!hm.containsKey(name)) continue;
    			
    			int key = hm.get(name);
    			
    			while(!pq[key].isEmpty() && --b >= 0)
    				res += pq[key].poll();
    		}
    	}
    	
    	bw.write(res+"");
    	bw.flush();
	}
}