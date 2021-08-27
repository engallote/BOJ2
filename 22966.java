import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	long min = Long.MAX_VALUE;
    	String res = "";
    	
    	for(int i = 0; i < N; i++) {
    		String name = sc.next();
    		long num = sc.nextLong();
    		
    		if(num < min) {
    			min = num;
    			res = name;
    		}
    	}
    	
    	System.out.println(res);
	}
}