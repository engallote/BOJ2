import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	while(true) {
    		int N = sc.nextInt();
    		int M = sc.nextInt();
    		
    		if(N == 0 && M == 0) break;
    		
    		int num = (N - M) / 2;
    		int mod = (N - M) % 2;
    		
    		if(mod == 0) System.out.println(num + " 0");
    		else {
    			if(num == 0) {
    				if(N - M == 3) System.out.println("0 1");
    				else System.out.println("0 0");
    			}
    			else {
    				System.out.println((num - 1) + " 1");
    			}
    		}
    	}
	}
}