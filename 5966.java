import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while(--T >= 0) {
        	int N = sc.nextInt();
        	char[] ch = sc.next().toCharArray();
        	Stack<Character> st = new Stack<>();
        	boolean flag = true;
        	
        	for(int i = 0; i < N; i++) {
        		if(ch[i] == '>') st.push(ch[i]);
        		else {
        			if(st.isEmpty()) {
        				flag = false;
        				break;
        			}
        			st.pop();
        		}
        	}
        	
        	if(st.isEmpty() && flag) System.out.println("legal");
        	else System.out.println("illegal");
        	
        }
    }
}