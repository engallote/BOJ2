import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	char[] ch = sc.next().toCharArray();
    	HashSet<String> hs = new HashSet<>();
    	hs.add(new String(ch));
    	long res = 0;
    	
    	while(true) {
    		char c = ch[ch.length - 1];
    		
    		for(int i = ch.length - 1; i > 0; i--)
    			ch[i] = ch[i - 1];
    		ch[0] = c;
    		
    		long num = Long.parseLong(new String(ch));
    		res += num;
    		
    		if(hs.contains(new String(ch))) break;
    	}
    	
    	System.out.println(res);
    }
}