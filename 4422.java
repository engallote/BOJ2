import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	char[] key = "the quick brown fox jumps over the lazy dog".toCharArray();
    	String[] arr = new String[100];
    	int idx = 0;
    	
    	while(sc.hasNextLine()) {
    		arr[idx] = sc.nextLine();
    		++idx;
    	}
    	HashMap<Character, Character> hm = new HashMap<>();
    	
    	for(int i = 0; i < idx; i++) {
    		char[] str = arr[i].toCharArray();
    		
    		if(str.length == key.length) {
    			boolean flag = true;
    			for(int j = 0; j < key.length; j++) {
    				if(str[j] == ' ' && key[j] == ' ') continue;
    				if((str[j] == ' ' && key[j] != ' ') || (str[j] != ' ' && key[j] == ' ')) {
    					flag = false;
    					break;
    				}
    			}
    			
    			if(flag) {
    				for(int j = 0; j < key.length; j++) {
    					if(key[j] == ' ') continue;
    					if(hm.containsKey(str[j])) {
    						if(hm.get(str[j]) == key[j]) continue;
    						else {
    							hm.clear();
    							flag = false;
    							break;
    						}
    					}
						hm.put(str[j], key[j]);
    				}
    				if(flag) break;
    			}
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	boolean flag;
    	for(int i = 0; i < idx; i++) {
    		flag = true;
    		for(int j = 0; j < arr[i].length(); j++) {
    			if(arr[i].charAt(j) == ' ') {
    				sb.append(" "); 
    				continue;
    			}
    			if(hm.containsKey(arr[i].charAt(j))) sb.append(hm.get(arr[i].charAt(j)));
    			else {
    				flag = false;
    				break;
    			}
    		}
    		if(flag) sb.append("\n");
    		else {
    			System.out.println("No solution.");
    			return;
    		}
    	}
    	
    	System.out.println(sb.toString());
	}
}