import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	
    	while(--T >= 0) {
    		int N = sc.nextInt();
    		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    		double sum = 0;
    		
    		for(int i = 0; i < N; i++) {
    			int num = sc.nextInt();
    			min = Math.min(min, num);
    			max = Math.max(max, num);
    			sum += num;
    		}
    		
    		double A = (double)(min + max) / 2.0;
    		sum /= (double) N;
    		
    		if(Math.abs(A - sum) <= 1) System.out.println("Yes");
    		else System.out.println("No");
    	}
	}
}