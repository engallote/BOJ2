import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	char[] ch = sc.next().toCharArray();
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i = 0; i < N; i++) {
    		if(ch[i] == 'J' || ch[i] == 'A' || ch[i] == 'V') continue;
    		sb.append(ch[i]);
    	}
    	
    	System.out.println(sb.length() == 0 ? "nojava" : sb.toString());
	}
}