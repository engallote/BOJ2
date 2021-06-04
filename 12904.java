import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	char[] S = sc.next().toCharArray();
    	char[] T = sc.next().toCharArray();
    	Deque<Character> dq = new LinkedList<>(), tmp = new LinkedList<>();
    	
    	for(char c : T) dq.offer(c);
    	
    	while(true) {
    		if(dq.size() == S.length) {
    			for(int i = 0; i < S.length; i++)
    				if(dq.pollFirst() != S[i]) {
    					System.out.println(0);
    					return;
    				}
    			System.out.println(1);
    			return;
    		}
    		
    		if(dq.peekLast() == 'A') dq.pollLast();
    		else {
    			dq.pollLast();
    			
    			while(!dq.isEmpty()) tmp.offer(dq.pollLast());
    			while(!tmp.isEmpty()) dq.offer(tmp.poll());
    		}
    	}
	}
}