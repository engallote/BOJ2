import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int K = sc.nextInt();
    	char[] ch = sc.next().toCharArray();
    	
    	int res = 0;
    	for(int i = 0; i < N; i++) {
    		if(ch[i] == 'H') continue;
    		else if(ch[i] == 'P'){
    			for(int j = Math.max(i - K, 0); j <= Math.min(i + K, N - 1); j++)
    				if(ch[j] == 'H') {
    					ch[j] = '.';
    					++res;
    					break;
    				}
    		}
    	}
    	
    	System.out.println(res);
    }
}