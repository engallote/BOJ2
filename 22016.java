import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	char[] ch = sc.next().toCharArray();
    	
    	for(int i = 0; i < N; i++) {
    		if(i + 1 < M) System.out.print(ch[i]);
    		else {
    			if(ch[i] == 'j' || ch[i] == 'o' || ch[i] == 'i') 
    				System.out.print(new String(ch[i]+"").toUpperCase());
    			else
    				System.out.print(new String(ch[i]+"").toLowerCase());
    		}
    	}
	}
}