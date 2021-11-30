import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	HashMap<String, String> hm = new HashMap<>();
    	
    	for(int i = 0; i < N; i++) {
    		String mean = sc.next();
    		String ch = sc.next();
    		
    		hm.put(ch, mean);
    	}
    	
    	char[] ch = sc.next().toCharArray();
    	StringBuilder sb = new StringBuilder();
    	
    	for(char c : ch) sb.append(hm.get(c+""));
    	
    	int s = sc.nextInt() - 1;
    	int e = sc.nextInt();
    	
    	System.out.println(sb.substring(s, e));
    }
}