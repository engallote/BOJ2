import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> st = new Stack<Character>();
        char[] ch = sc.next().toCharArray();
        
        if(new String(ch).equals("P")) {
        	System.out.println("PPAP");
        	return;
        }
        
        boolean isA = false;
        
        for(int i = 0; i < ch.length; i++) {
        	if(ch[i] == 'P') st.push(ch[i]);
        	else {
        		isA = true;
        		if(st.size() >= 2 && i + 1 < ch.length && ch[i + 1] == 'P') {
        			st.pop();
        			st.pop();
        		}
        		else {
        			System.out.println("NP");
        			return;
        		}
        	}
        }
        
        System.out.println(isA ? "PPAP" : "NP");
    }
}