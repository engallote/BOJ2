import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int A = sc.nextInt();
    	int B = sc.nextInt();
    	int C = sc.nextInt();
    	
    	int N = sc.nextInt();
    	int max = 0;
    	
    	for(int i = 0; i < N; i++) {
    		int sum = 0;
    		for(int j = 0; j < 3; j++) {
    			int a = sc.nextInt();
        		int b = sc.nextInt();
        		int c = sc.nextInt();
        		
        		sum += a * A + b * B + c * C;
    		}
    		
    		max = Math.max(max, sum);
    	}
    	
    	System.out.println(max);
	}
}