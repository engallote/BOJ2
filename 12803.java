import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	
    	while(--T >= 0) {
    		int N = sc.nextInt();
    		int M = sc.nextInt();
    		boolean[] chk = new boolean[N + 1];
    		
    		for(int i = 0; i < M; i++) {
    			char op = sc.next().charAt(0);
    			int num = sc.nextInt();
    			
    			if(op == '-') chk[num] = chk[N - num + 1] = true;
    			else {
    				for(int j = 1; j <= N; j++) {
    					if(!chk[j]) --num;
    					
    					if(num == 0) {
    						System.out.println(j);
    						break;
    					}
    				}
    			}
    		}
    	}
	}
}