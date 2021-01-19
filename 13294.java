import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        
        if(N.equals("1")) {
        	System.out.println(1);
        	return;
        }
        if(N.equals("2")) {
        	System.out.println(2);
        	return;
        }
        if(N.equals("6")) {
        	System.out.println(3);
        	return;
        }
        if(N.equals("24")) {
        	System.out.println(4);
        	return;
        }
        if(N.equals("120")) {
        	System.out.println(5);
        	return;
        }
        if(N.equals("720")) {
        	System.out.println(6);
        	return;
        }
        
        int len = N.length() - 1;
        double res = 0;
        
        for(int i = 1;; i++) {
        	res += Math.log10(i);
        	
        	if((int)res == len) {
        		System.out.println(i);
        		break;
        	}
        }
    }
}