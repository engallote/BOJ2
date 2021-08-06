import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//    	Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int N = Integer.parseInt(br.readLine());
    	HashMap<Integer, Integer> hm = new HashMap<>();
    	StringTokenizer st;
    	HashSet<Integer> hs = new HashSet<>();
    	
    	while(--N >= 0) {
    		st = new StringTokenizer(br.readLine());
    		String order = st.nextToken();
    		int num = Integer.parseInt(st.nextToken());
    		
    		if(order.equals("insert")) {
    			if(hm.containsKey(num)) {
    				hm.replace(num, hm.get(num) + 1);
    				hs.add(num);
    			}
        		else hm.put(num, 1);
    		}
    		else {
    			if(hm.containsKey(num)) {
    				int cur = hm.get(num);
    				if(cur - 1 > 0) {
    					hm.replace(num, cur - 1);
    					if(cur - 1 < 2) hs.remove(num);
    				}
    				else hm.remove(num);
    			}
    		}
    		
    		boolean ho = false, he = false;
    		if(hm.size() > 1) he = true;
    		if(hs.size() > 0) ho = true;
    		
    		if(ho && he) bw.write("both");
    		else if(ho) bw.write("homo");
    		else if(he) bw.write("hetero");
    		else bw.write("neither");
    		bw.newLine();
    	}
    	bw.flush();
	}
}