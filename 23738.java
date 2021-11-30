import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	char[] ch = sc.next().toCharArray();
    	HashMap<Character, String> hm = new HashMap<>();
    	hm.put('B', "v");
    	hm.put('E', "ye");
    	hm.put('H', "n");
    	hm.put('P', "r");
    	hm.put('C', "s");
    	hm.put('Y', "u");
    	hm.put('X', "h");
    	
    	for(char c : ch) {
    		if(hm.containsKey(c)) System.out.print(hm.get(c));
    		else System.out.print((c+"").toLowerCase());
    	}
    }
}