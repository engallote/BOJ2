import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> st = new Stack<>();
        Queue<Character> res = new LinkedList<>();
        char[] ch = sc.next().toCharArray();
        
        for(int i = 0; i < ch.length; i+=2) {
        	if(ch[i] == ch[i + 1]) {
        		if(ch[i] == '<') {//<<
        			if(!st.isEmpty()) {
        				if(st.peek() == '>') {
        					st.pop();
        					res.offer(']');
        				}
        				else {
        					st.push(ch[i]);
        					res.offer('[');
        				}
        			}
        			else {
        				st.push(ch[i]);
        				res.offer('[');
        			}
        		}
        		else {//>>
        			if(!st.isEmpty()) {
        				if(st.peek() == '<') {
        					st.pop();
        					res.offer(']');
        				}
        				else {
        					st.push(ch[i]);
        					res.offer('[');
        				}
        			}
        			else {
        				st.push(ch[i]);
        				res.offer('[');
        			}
        		}
        	}
        	else {
        		System.out.println("Keine Loesung");
        		return;
        	}
        }
        
        if(!st.isEmpty()) {
        	System.out.println("Keine Loesung");
        	return;
        }
        
        while(!res.isEmpty())
        	System.out.print(res.poll());
    }
}