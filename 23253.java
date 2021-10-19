import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	boolean flag = true;
    	
    	for(int i = 0; i < M; i++) {
    		int pre = 100000000;
    		int num = sc.nextInt();
    		while(--num >= 0) {
    			int x = sc.nextInt();
    			if(pre < x) flag = false;
    			pre = x;
    		}
    	}
    	
    	System.out.println(flag ? "Yes" : "No");
	}
}