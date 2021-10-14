import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	HashMap<Character, Integer> hm = new HashMap<>();
    	hm.put('B', 1);
    	hm.put('F', 1);
    	hm.put('P', 1);
    	hm.put('V', 1);
    	hm.put('C', 2);
    	hm.put('G', 2);
    	hm.put('J', 2);
    	hm.put('K', 2);
    	hm.put('Q', 2);
    	hm.put('S', 2);
    	hm.put('X', 2);
    	hm.put('Z', 2);
    	hm.put('D', 3);
    	hm.put('T', 3);
    	hm.put('L', 4);
    	hm.put('M', 5);
    	hm.put('N', 5);
    	hm.put('R', 6);
    	
    	while(sc.hasNext()) {
    		char[] ch = sc.next().toCharArray();
    		StringBuilder sb = new StringBuilder();
    		int pre = 0;
    		
    		for(char c : ch) {
    			if(!hm.containsKey(c)) {
    				pre = 0;
    				continue;
    			}
    			
    			int v = hm.get(c);
    			if(pre == v) continue;
    			sb.append(v);
    			pre = v;
    		}
    		
    		System.out.println(sb.toString());
    	}
	}
}