import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int T = Integer.parseInt(st.nextToken());
    	HashMap<Integer, Integer> hm = new HashMap<>();
    	Queue<Pair>[] q = new LinkedList[N + 1];
    	int[] arr = new int[T];
    	
    	for(int i = 1; i <= N; i++) q[i] = new LinkedList<>();
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < T; i++) arr[i] = Integer.parseInt(st.nextToken());
    	
    	int cnt = 0;
    	for(int i = 0; i < T && cnt < T; i++) {
    		if(!q[arr[i]].isEmpty()) {
    			Pair p = q[arr[i]].peek();
    			++cnt;
    			bw.write(p.id+"\n");
    			if(!hm.containsKey(p.num)) {
    				hm.put(p.num, arr[i]);
    				q[arr[i]].poll();
    			}
    			continue;
    		}
    		
    		st = new StringTokenizer(br.readLine());
    		int id = Integer.parseInt(st.nextToken());
    		String order = st.nextToken();
    		
    		if(order.equals("next")) {
    			bw.write(id+"\n");
    			++cnt;
    			continue;
    		}
    		else if(order.equals("acquire")) {
    			int num = Integer.parseInt(st.nextToken());
    			bw.write(id+"\n");
    			if(hm.containsKey(num)) q[arr[i]].offer(new Pair(id, order, num));
    			else {
    				hm.put(num, arr[i]);
    				++cnt;
    			}
    		}
    		else {
    			int num = Integer.parseInt(st.nextToken());
    			bw.write(id+"\n");
    			hm.remove(num);
    			++cnt;
    		}
    	}
    	bw.flush();
	}
}
class Pair {
	int id, num;
	String order;
	Pair(int id, String order, int num) {
		this.id = id;
		this.order = order;
		this.num = num;
	}
}