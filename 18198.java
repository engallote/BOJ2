import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	char[] ch = sc.next().toCharArray();
    	
    	int a = 0, b = 0;
    	for(int i = 0; i < ch.length; i++)
    		if('0' <= ch[i] && ch[i] <= '9') {
    			if(ch[i - 1] == 'A') a += ch[i] - '0';
    			else b += ch[i] - '0';
    		}
    	if(a > b) System.out.println("A");
		else System.out.println("B");
    }
}