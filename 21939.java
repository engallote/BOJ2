import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	HashMap<Integer, Integer> hm = new HashMap<>();
    	PriorityQueue<Integer>[] pq = new PriorityQueue[101];
    	int[][] mm = new int[101][2];
    	for(int i = 1; i <= 100; i++) {
    		pq[i] = new PriorityQueue<>();
    		mm[i][0] = Integer.MAX_VALUE;
    	}
    	
    	StringTokenizer st;
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int P = Integer.parseInt(st.nextToken());
    		int L = Integer.parseInt(st.nextToken());
    		
    		hm.put(P, L);
    		pq[L].offer(P);
    		mm[L][0] = Math.min(mm[L][0], P);
    		mm[L][1] = Math.max(mm[L][1], P);
    	}
    	
    	int M = Integer.parseInt(br.readLine());
    	
    	for(int t = 0; t < M; t++) {
    		st = new StringTokenizer(br.readLine());
    		String order = st.nextToken();
    		
    		if(order.equals("add")) {
    			int p = Integer.parseInt(st.nextToken());
    			int l = Integer.parseInt(st.nextToken());
    			hm.put(p, l);
    			pq[l].offer(p);
    			
    			mm[l][0] = Math.min(mm[l][0], p);
    			mm[l][1] = Math.max(mm[l][1], p);
    		}
    		else if(order.equals("solved")) {
    			int p = Integer.parseInt(st.nextToken());
    			int l = hm.get(p);
    			
    			hm.remove(p);
    			pq[l].remove(p);
    			
    			if(mm[l][1] == p || mm[l][0] == p) {
    				mm[l][0] = Integer.MAX_VALUE;
    				mm[l][1] = 0;
    				Iterator<Integer> it = pq[l].iterator();
    				while(it.hasNext()) {
    					int cur = it.next();
    					mm[l][0] = Math.min(mm[l][0], cur);
    					mm[l][1] = Math.max(mm[l][1], cur);
    				}
    			}
    		}
    		else {
    			int l = Integer.parseInt(st.nextToken());
    			
    			if(l == 1) {//가장 어려운 문제의 번호
    				for(int i = 100; i >= 1; i--)
    					if(mm[i][1] != 0) {
    						System.out.println(mm[i][1]);
    						break;
    					}
    			}
    			else {//가장 쉬운 문제의 번호
    				for(int i = 1; i <= 100; i++)
    					if(mm[i][0] != Integer.MAX_VALUE) {
    						System.out.println(mm[i][0]);
    						break;
    					}
    			}
    		}
    	}
	}
}